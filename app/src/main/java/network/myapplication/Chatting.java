package network.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class Chatting extends AppCompatActivity {

    private Button btnLibrarianChat, btnStudyGroupChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);

        btnLibrarianChat = findViewById(R.id.btnLibrarianChat);
        btnStudyGroupChat = findViewById(R.id.btnStudyGroupChat);

        btnLibrarianChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chatting.this, LibrarianChatClient.class);
                startActivity(intent);
            }
        });


        btnStudyGroupChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chatting.this, StudyGroupChatActivity.class);
                startActivity(intent);
            }
        });
    }
}
