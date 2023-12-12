//package network.myapplication;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//public class LibrarianChatServer {
//    private static final int PORT = 5000;
//    private static List<PrintWriter> clientWriters = new ArrayList<>();
//
//    public static void main(String[] args) throws Exception {
//        ExecutorService pool = Executors.newFixedThreadPool(50);
//        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
//            System.out.println("Chat Server is listening on port " + PORT);
//
//            // New thread for handling server-side sending
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
//                        String input;
//                        while ((input = consoleReader.readLine()) != null) {
//                            for (PrintWriter writer : clientWriters) {
//                                writer.println("Librarian: " + input);
//                            }
//                        }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }).start();
//
//            while (true) {
//                Socket clientSocket = serverSocket.accept();
//                pool.execute(new ClientHandler(clientSocket));
//            }
//        }
//    }
//
//    private static class ClientHandler implements Runnable {
//        private Socket clientSocket;
//        private PrintWriter out;
//        private BufferedReader in;
//
//        public ClientHandler(Socket socket) {
//            this.clientSocket = socket;
//        }
//
//        @Override
//        public void run() {
//            try {
//                out = new PrintWriter(clientSocket.getOutputStream(), true);
//                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//
//                clientWriters.add(out);
//
//                String inputLine;
//                while ((inputLine = in.readLine()) != null) {
//                    for (PrintWriter writer : clientWriters) {
//                        writer.println("Client: " + inputLine);
//                    }
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                try {
//                    clientWriters.remove(out);
//                    if (out != null) {
//                        out.close();
//                    }
//                    if (in != null) {
//                        in.close();
//                    }
//                    clientSocket.close();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//}