// 네트워크 스터디 채팅 서버 실행시키는 방법
// StudyManagerThread.java MyServer.java 동시에 컴파일하고 MyServer을 실행시킵니다.
// MyServer.java 파일과 ChatGroupActivity.java 의 포트 번호가 동일해야 합니다.
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.ArrayList;
//
//public class MyServer {
//    public static ArrayList<PrintWriter> m_OutputList;
//
//    public static void main(String[] args){
//        m_OutputList = new ArrayList<PrintWriter>();
//
//        try{
//            ServerSocket s_socket = new ServerSocket(1913);
//            while(true){
//                Socket c_socket = s_socket.accept();
//                ClientManagerThread c_thread = new ClientManagerThread();
//                c_thread.setSocket(c_socket);
//
//                m_OutputList.add(new PrintWriter(c_socket.getOutputStream()));
//                System.out.println(m_OutputList.size());
//                c_thread.start();
//            }
//        }catch(IOException e){
//            e.printStackTrace();
//        }
//    }
//}