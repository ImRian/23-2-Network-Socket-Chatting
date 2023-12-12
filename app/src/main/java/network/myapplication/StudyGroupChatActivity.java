package network.myapplication;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class StudyGroupChatActivity extends AppCompatActivity {

    private ListView messagesView;
    private EditText messageText;
    private Button sendButton;
    private ArrayAdapter<String> adapter;
    private ChatClientTask chatClientTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_group_chat);

        messagesView = findViewById(R.id.messageListView);
        messageText = findViewById(R.id.messageEditText);
        sendButton = findViewById(R.id.sendButton);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        messagesView.setAdapter(adapter);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });

        String serverAddress = "172.20.14.2"; // 서버의 IP 주소
        int serverPort = 10008; // 서버의 포트
        chatClientTask = new ChatClientTask(serverAddress, serverPort);
        chatClientTask.execute();
    }

    private void sendMessage() {
        String message = messageText.getText().toString().trim();
        if (!message.isEmpty()) {
            chatClientTask.sendMessage(message);
            messageText.setText("");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (chatClientTask != null) {
            chatClientTask.close();
        }
    }

    private class ChatClientTask extends AsyncTask<Void, String, Void> {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;
        private String serverAddress;
        private int serverPort;

        ChatClientTask(String serverAddress, int serverPort) {
            this.serverAddress = serverAddress;
            this.serverPort = serverPort;
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                socket = new Socket(serverAddress, serverPort);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                String message;
                while ((message = in.readLine()) != null) {
                    publishProgress(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            adapter.add(values[0]);
        }

        void sendMessage(String message) {
            if (out != null && !out.checkError()) {
                out.println(message);
            }
        }

        void close() {
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
