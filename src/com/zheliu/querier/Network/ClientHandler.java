package com.zheliu.querier.Network;

import java.io.*;
import java.net.Socket;

public class ClientHandler extends Thread {
    private Socket socket;
    private String name;
    private String filePath;
    public ClientHandler(Socket socket,String name,String filePath) {
        this.name = name;
        this.socket = socket;
        this.filePath=filePath;
    }

    @Override
    public void run(){
        try {
            InputStream is = socket.getInputStream();
            FileOutputStream fw = new FileOutputStream(name+".file");
            is.transferTo(fw);
            fw.close();
            is.close();

            System.out.println("Server Write to file finished");

        }catch (Exception e){
            System.out.println("Exception happended at ClientHandler.java");
            e.printStackTrace();
        }

    }
}
