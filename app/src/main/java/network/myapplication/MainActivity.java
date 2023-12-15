package network.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton btnStudyGroup, btnStudyRoom, btnChatting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStudyGroup = findViewById(R.id.btnStudyGroup);
        btnStudyRoom = findViewById(R.id.btnStudyRoom);
        btnChatting = findViewById(R.id.btnChatting);

        btnStudyGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, StudyCategoryActivity.class);
                startActivity(intent);
            }
        });

        btnStudyRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, StudyRoomSetActivity.class);
                startActivity(intent);
            }
        });

        btnChatting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Chatting.class);
                startActivity(intent);
            }
        });
    }
}
