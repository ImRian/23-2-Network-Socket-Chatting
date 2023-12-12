package network.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.security.PrivateKey;

public class StudyRoomSetActivity extends AppCompatActivity {
    Button btnStudyGroup, btnStudyRoom, btnChatting;
    ImageButton imageBtnUp, imageBtnDown;
    TextView textViewTemp;
    private String temperature;
    private int tempNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_room_set);

        btnStudyGroup = findViewById(R.id.btnRoomToSG);
        btnStudyRoom = findViewById(R.id.btnRoomToSR);
        btnChatting = findViewById(R.id.btnRoomToChat);
        textViewTemp = findViewById(R.id.temperatureNum);
        imageBtnUp = findViewById(R.id.upBTN);
        imageBtnDown = findViewById(R.id.downBTN);

        btnStudyGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudyRoomSetActivity.this, StudyCategoryActivity.class);
                startActivity(intent);
            }
        });
        btnStudyRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudyRoomSetActivity.this, StudyRoomSetActivity.class);
                startActivity(intent);
            }
        });
        btnChatting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudyRoomSetActivity.this, Chatting.class);
                startActivity(intent);
            }
        });
        imageBtnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temperature = textViewTemp.getText().toString();
                tempNum = Integer.parseInt(temperature) + 1;
                temperature = Integer.toString(tempNum);
                textViewTemp.setText(temperature);
            }
        });
        imageBtnDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temperature = textViewTemp.getText().toString();
                tempNum = Integer.parseInt(temperature) - 1;
                temperature = Integer.toString(tempNum);
                textViewTemp.setText(temperature);
            }
        });
    }
}