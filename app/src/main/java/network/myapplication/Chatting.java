package network.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Chatting extends AppCompatActivity {

    private Button btnLibrarianChat, btnStudyGroupChat, btnBookClubChat;
    private ImageButton btnHome, btnStudyGroup, btnStudyRoom, btnChatting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);

        btnLibrarianChat = findViewById(R.id.libChatBtn);
        btnStudyGroupChat = findViewById(R.id.networkChatBtn);
        btnBookClubChat = findViewById(R.id.bookClubChatBtn);
        btnStudyGroup = findViewById(R.id.chat2studyGroupBTN1);
        btnStudyRoom = findViewById(R.id.chat2studyRoomBTN1);
        btnChatting = findViewById(R.id.chat2chatBTN1);
        btnHome = findViewById(R.id.chatHomeBTN1);

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
                Intent intent = new Intent(Chatting.this, ChatEnterActivity.class);
                startActivity(intent);
            }
        });

        btnBookClubChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chatting.this, BookClubChatClient.class);
                startActivity(intent);
            }
        });

        btnStudyGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chatting.this, StudyCategoryActivity.class);
                startActivity(intent);
            }
        });

        btnStudyRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chatting.this, StudyRoomSetActivity.class);
                startActivity(intent);
            }
        });

        btnChatting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chatting.this, Chatting.class);
                startActivity(intent);
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chatting.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
