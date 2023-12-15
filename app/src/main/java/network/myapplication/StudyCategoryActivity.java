package network.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class StudyCategoryActivity extends AppCompatActivity {

    private Button btnJavaStudy, btnJsStudy, btnCStudy, btnNetworkStudy;
    private ImageButton btnHome, btnStudyGroup, btnStudyRoom, btnChatting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_category);

        btnJavaStudy = findViewById(R.id.javaStudyBtn);
        btnJsStudy = findViewById(R.id.jsStudyBtn);
        btnCStudy = findViewById(R.id.cStudyBtn);
        btnNetworkStudy = findViewById(R.id.networkStudyBtn);
        btnStudyGroup = findViewById(R.id.studyGroupBTN);
        btnStudyRoom = findViewById(R.id.studyRoomBTN);
        btnChatting = findViewById(R.id.chattingBTN);
        btnHome = findViewById(R.id.homeBTN);

        btnJavaStudy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudyCategoryActivity.this, StudyDateTimeSelectActivity.class);
                startActivity(intent);
            }
        });

        btnJsStudy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudyCategoryActivity.this, StudyDateTimeSelectActivity.class);
                startActivity(intent);
            }
        });

        btnCStudy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudyCategoryActivity.this, StudyDateTimeSelectActivity.class);
                startActivity(intent);
            }
        });

        btnNetworkStudy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudyCategoryActivity.this, StudyDateTimeSelectActivity.class);
                startActivity(intent);
            }
        });

        btnStudyGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudyCategoryActivity.this, StudyCategoryActivity.class);
                startActivity(intent);
            }
        });

        btnStudyRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudyCategoryActivity.this, StudyRoomSetActivity.class);
                startActivity(intent);
            }
        });

        btnChatting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudyCategoryActivity.this, Chatting.class);
                startActivity(intent);
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudyCategoryActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}