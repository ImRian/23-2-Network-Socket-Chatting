package network.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class Chatting extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);

    }


    public void onLibrarianChatClick(View view) {
        Intent intent = new Intent(this, LibrarianChatActivity.class);
        startActivity(intent);
    }


    public void onStudyGroupChatClick(View view) {
        Intent intent = new Intent(this, StudyGroupChatActivity.class);
        startActivity(intent);
    }
}
