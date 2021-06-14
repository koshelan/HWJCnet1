package net.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Main {

    public static final int SERVER_PORT = 54321;

    public static void main(String[] args) {
        System.out.println("server started");

        while (true) {

            try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
                 Socket socket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            ) {
                System.out.println("New connection accepted");
                final String name = in.readLine();
                out.println(String.format("Hi %s, your port is %d", name, socket.getPort()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            ;
        }

    }
}
