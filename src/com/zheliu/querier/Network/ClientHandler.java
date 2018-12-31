package com.zheliu.querier.Network;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;

public class ClientHandler extends Thread {
    private Socket socket;
    private String name;
    private String filePath;
    public ClientHandler(Socket socket,String name,String filePath) {
        this.name = name;
        this.socket = socket;
        this.filePath=filePath;
    }


    public void run(){
        try {

            InputStream is = socket.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
            ArrayList<String> msg = (ArrayList<String>) ois.readObject();

            System.out.println("Server received:");
            for (String x: msg
                ) {
                System.out.println(x);
            }
            ois.close();
            socket.close();

        }catch (Exception e){
            System.out.println("Exception happended at ClientHandler.java");
            e.printStackTrace();
        }

    }
}
