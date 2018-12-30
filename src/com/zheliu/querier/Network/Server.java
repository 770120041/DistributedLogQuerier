package com.zheliu.querier.Network;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
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
        while (true){
            try {
                Socket socket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(socket);
                clientHandler.start();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
