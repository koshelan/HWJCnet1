package net.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static final int SERVER_PORT = 54321;

    public static void main(String[] args) {
        try (
                Socket socket = new Socket("127.0.0.1", SERVER_PORT);
                InputStream from = socket.getInputStream();
                OutputStream to = socket.getOutputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(from));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(to));
        ) {
            Scanner scanner = new Scanner(System.in);
            String message;

            while (!(message = scanner.nextLine()).isEmpty()) {
                writer.write(message);
                writer.newLine();
                writer.flush();
                System.out.println("server: " + reader.readLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ;


    }

}
