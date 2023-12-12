package network.myapplication;

import android.os.AsyncTask;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.net.Socket;
import android.util.Log;

public class LibrarianChatClient extends AppCompatActivity {
    private EditText editTextMessage;
    private Button buttonSend;
    private TextView textViewMessages;
    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_librarian_chat);

        editTextMessage = findViewById(R.id.editTextMessage);
        buttonSend = findViewById(R.id.buttonSend);
        textViewMessages = findViewById(R.id.textViewMessages);

        new ConnectTask().execute("172.20.19.64", "1912");

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage(editTextMessage.getText().toString());
                editTextMessage.setText("");
            }
        });
    }

    private void sendMessage(final String message) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (writer != null) {
                    writer.println(message);
                    Log.d("ChatClient", "Message sent: " + message);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textViewMessages.append("Me: " + message + "\n"); // UI 업데이트
                        }
                    });
                } else {
                    Log.e("ChatClient", "Writer is null, cannot send message");
                }
            }
        }).start();
    }

    private class ConnectTask extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... params) {
            try {
                String serverIp = params[0];
                int serverPort = Integer.parseInt(params[1]);

                socket = new Socket(serverIp, serverPort);
                writer = new PrintWriter(socket.getOutputStream(), true);
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                Log.d("ChatClient", "Connected to server");

                String line;
                while ((line = reader.readLine()) != null) {
                    final String receivedMessage = line;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textViewMessages.append(receivedMessage + "\n");
                        }
                    });
                }
            } catch (IOException e) {
                Log.e("ChatClient", "Error connecting to server", e);
                e.printStackTrace();
            }
            return null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            if (socket != null) {
                socket.close();
            }
            if (writer != null) {
                writer.close();
            }
            if (reader != null) {
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
