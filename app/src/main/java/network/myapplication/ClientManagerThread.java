// 네트워크 스터디 채팅 서버 실행시키는 방법
// StudyManagerThread.java MyServer.java 동시에 컴파일하고 MyServer을 실행시킵니다.
// MyServer.java 파일과 ChatGroupActivity.java 의 포트 번호가 동일해야 합니다.

//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.Socket;
//
//public class ClientManagerThread extends Thread{
//
//    private Socket m_socket;
//    private String m_ID;
//
//    @Override
//    public void run(){
//        super.run();
//        try{
//            BufferedReader in = new BufferedReader(new InputStreamReader(m_socket.getInputStream()));
//            String text;
//
//            while(true){
//                text = in.readLine();
//                if(text!=null) {
//                    for(int i=0;i<MyServer.m_OutputList.size();++i){
//                        MyServer.m_OutputList.get(i).println(text);
//                        MyServer.m_OutputList.get(i).flush();
//                    }
//                }
//            }
//
//
//        }catch(IOException e){
//            e.printStackTrace();
//        }
//    }
//    public void setSocket(Socket _socket){
//        m_socket = _socket;
//    }
//}