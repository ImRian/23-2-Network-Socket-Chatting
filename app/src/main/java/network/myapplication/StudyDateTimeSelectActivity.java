package network.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class StudyDateTimeSelectActivity extends AppCompatActivity {

    Button btnTime1, btnTime2, btnDate1, btnDate2, btn_next, btnStudyGroup, btnStudyRoom, btnChatting;
    ImageButton homeBtn;
    String selectedDate1, selectedDate2, selectedTime1, selectedTime2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_date_time_select);

        btnTime1 = findViewById(R.id.btnTime1);
        btnTime2 = findViewById(R.id.btnTime2);
        btnDate1 = findViewById(R.id.btnDate1);
        btnDate2 = findViewById(R.id.btnDate2);
        btn_next = findViewById(R.id.btn_next);
        btnStudyGroup = findViewById(R.id.studyGroupBT);
        btnStudyRoom = findViewById(R.id.studyRoomBT);
        btnChatting = findViewById(R.id.chattingBT);
        homeBtn = findViewById(R.id.homeBTN);

        // 버튼에 클릭 리스너 설정
        btnDate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog1();
            }
        });
        btnDate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog2();
            }
        });

        btnTime1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePickerDialog1();
            }
        });
        btnTime2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePickerDialog2();
            }
        });
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataToMatchingActivity();
                //Intent intent = new Intent(StudyDateTimeSelectActivity.this, StudyMatching.class);
                //startActivity(intent);
            }
        });
        btnStudyGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudyDateTimeSelectActivity.this, StudyCategoryActivity.class);
                startActivity(intent);
            }
        });
        btnStudyRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudyDateTimeSelectActivity.this, StudyRoomSetActivity.class);
                startActivity(intent);
            }
        });
        btnChatting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudyDateTimeSelectActivity.this, Chatting.class);
                startActivity(intent);
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudyDateTimeSelectActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    // 날짜 선택 다이얼로그 표시 메서드
    private void showDatePickerDialog1() {
        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul"), Locale.KOREA);
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                btnDate1.setText(i + "년 " + (i1 + 1) + "월 " + i2 + "일");
            }
        }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    private void showDatePickerDialog2() {
        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul"), Locale.KOREA);
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                btnDate2.setText(i + "년 " + (i1 + 1) + "월 " + i2 + "일");
            }
        }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    // 시간 선택 다이얼로그 표시 메서드
    private void showTimePickerDialog1() {
        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul"), Locale.KOREA);
        int mHour = c.get(Calendar.HOUR_OF_DAY);
        int mMinute = c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                btnTime1.setText(i + "시 " + i1 + "분");
            }
        }, mHour, mMinute, false);
        timePickerDialog.show();
    }

    private void showTimePickerDialog2() {
        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul"), Locale.KOREA);
        int mHour = c.get(Calendar.HOUR_OF_DAY);
        int mMinute = c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                btnTime2.setText(i + "시 " + i1 + "분");
            }
        }, mHour, mMinute, false);
        timePickerDialog.show();
    }

    private void sendDataToMatchingActivity() {
        Intent intent = new Intent(StudyDateTimeSelectActivity.this, StudyMatching.class);
        intent.putExtra("selectedDate1", btnDate1.getText().toString());
        intent.putExtra("selectedTime1", btnTime1.getText().toString());
        intent.putExtra("selectedDate2", btnDate2.getText().toString());
        intent.putExtra("selectedTime2", btnTime2.getText().toString());
        startActivity(intent);
    }
}
