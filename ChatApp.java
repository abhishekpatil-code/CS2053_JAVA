import java.io.*;
import java.net.*;
import java.util.*;

public class ChatApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose mode: 1. Server  2. Client");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        if (choice == 1) {
            startServer();
        } else {
            startClient();
        }
    }

    // ---------- SERVER ----------
    public static void startServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server started. Waiting for client...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner sc = new Scanner(System.in);

            Thread receiveThread = new Thread(() -> {
                try {
                    String message;
                    while ((message = in.readLine()) != null) {
                        System.out.println("Client: " + message);
                    }
                } catch (IOException e) {
                    System.out.println("Client disconnected.");
                }
            });
            receiveThread.start();

            System.out.println("You can start chatting now...");
            while (true) {
                String msg = sc.nextLine();
                out.println(msg);
                if (msg.equalsIgnoreCase("bye")) break;
            }

            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ---------- CLIENT ----------
    public static void startClient() {
        try {
            Socket socket = new Socket("localhost", 5000);
            System.out.println("Connected to server!");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner sc = new Scanner(System.in);

            Thread receiveThread = new Thread(() -> {
                try {
                    String message;
                    while ((message = in.readLine()) != null) {
                        System.out.println("Server: " + message);
                    }
                } catch (IOException e) {
                    System.out.println("Server disconnected.");
                }
            });
            receiveThread.start();

            System.out.println("You can start chatting now...");
            while (true) {
                String msg = sc.nextLine();
                out.println(msg);
                if (msg.equalsIgnoreCase("bye")) break;
            }

            socket.close();
        } catch (IOException e) {
            System.out.println("Error connecting to server.");
        }
    }
}
