// DB 데이터 불러오는 방법
// TestApiClient, ApiClient 둘 다 javac로 컴파일하고 TestApiClient 파일을 실행시키면 됩니다. 불러온 데이터는 DBConnectActivity와 연결됩니다.
package network.myapplication;
public class TestApiClient {
    public static void main(String[] args) {
        String response = ApiClient.getGroups(null);
        System.out.println(response);
    }
}