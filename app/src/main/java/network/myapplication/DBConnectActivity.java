// DB 데이터 불러오는 방법
// TestApiClient, ApiClient 둘 다 javac로 컴파일하고 TestApiClient 파일을 실행시키면 됩니다. 불러온 데이터는 DBConnectActivity와 연결됩니다.
package network.myapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import java.net.URLEncoder;


import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;

public class DBConnectActivity extends AppCompatActivity {

    private Spinner categorySpinner;
    private ListView groupListView;
    private ArrayAdapter<String> groupAdapter;
    private ImageButton btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbconnect);

        categorySpinner = findViewById(R.id.categorySpinner);
        groupListView = findViewById(R.id.groupListView);
        groupAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        groupListView.setAdapter(groupAdapter);
        btnHome = findViewById(R.id.homeBTN);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DBConnectActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // spinner, adapter 설정
        ArrayAdapter<CharSequence> categoryAdapter = ArrayAdapter.createFromResource(this,
                R.array.category_array, android.R.layout.simple_spinner_item);
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(categoryAdapter);

        // 스피너에서 항목이 선택될 때 리스너 설정
        categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // 카테고리가 선택될 때 데이터를 가져옴
                new FetchGroupsTask().execute();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // 아무것도 선택되지 않았을 때 아무 작업도 하지 않음
            }
        });
    }

    private class FetchGroupsTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            try { // 선택한 카테고리를 기반으로 데이터를 가져옴
                String selectedCategory = categorySpinner.getSelectedItem().toString();
                String urlString = "https://port-0-network-server-iad5e2alq3rwcdo.sel4.cloudtype.app/groups?category=" + URLEncoder.encode(selectedCategory, "UTF-8");

                URL url = new URL(urlString);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    StringBuilder stringBuilder = new StringBuilder();
                    String line;

                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line).append("\n");
                    }

                    bufferedReader.close();
                    return stringBuilder.toString();
                } finally {
                    urlConnection.disconnect();
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            // 데이터를 파싱하고 화면에 표시
            if (result != null) {
                parseAndDisplayGroups(result);
            }
        }
    }

    private void parseAndDisplayGroups(String data) {
        try {
            groupAdapter.clear(); // 이전 데이터를 지움
            JSONArray jsonArray = new JSONArray(data);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                // JSON 응답에서 모든 필드를 동적으로 가져와 표시
                Iterator<String> keys = jsonObject.keys();
                while (keys.hasNext()) {
                    String key = keys.next();
                    String value = jsonObject.getString(key);
                    groupAdapter.add(key + ": " + value);
                }
            }

            // 어댑터에 데이터가 변경되었음을 알림
            groupAdapter.notifyDataSetChanged();

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
