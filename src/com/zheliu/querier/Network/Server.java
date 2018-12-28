package com.zheliu.querier.Network;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    ServerSocket serverSocket;

    public Server(int port) {
        try {
            this.serverSocket = new ServerSocket(port);
        } catch (Exception e){
            e.printStackTrace();
        }

    }
    public void listen(){
        try {
            Socket socket = serverSocket.accept();
            InputStream inputToServer = socket.getInputStream();
            OutputStream outputFromServer = socket.getOutputStream();

            Scanner scanner = new Scanner(inputToServer,"UTF-8");
            PrintWriter serverOutput = new PrintWriter(new OutputStreamWriter(outputFromServer,"UTF-8"),true);


            boolean done = false;
            while(!done && scanner.hasNextLine()) {
                String line = scanner.nextLine();
                serverOutput.println("Echo from  Network: " + line);
                if(line.toLowerCase().trim().equals("stop")) {
                    done = true;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
