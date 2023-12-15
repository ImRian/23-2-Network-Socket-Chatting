// DB 데이터 불러오는 방법
// TestApiClient, ApiClient 둘 다 javac로 컴파일하고 TestApiClient 파일을 실행시키면 됩니다. 불러온 데이터는 DBConnectActivity와 연결됩니다.
package network.myapplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class ApiClient {
    public static String getGroups(String category) {
        try {
            // Modify the URL to include the selected category
            String urlString = "https://port-0-network-server-iad5e2alq3rwcdo.sel4.cloudtype.app/groups";

            // Append category parameter if it's not null or empty
            if (category != null && !category.isEmpty()) {
                urlString += "?category=" + URLEncoder.encode(category, "UTF-8");
            }

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
}
