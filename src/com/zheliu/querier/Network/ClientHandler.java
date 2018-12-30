package com.zheliu.querier.Network;

import java.io.*;
import java.net.Socket;

public class ClientHandler extends Thread {
    private Socket socker
            ;

    public ClientHandler(Socket socker) {
        this.socker = socker;
    }

    @Override
    public void run(){
        try {
            InputStream is = socker.getInputStream();
            FileOutputStream fw = new FileOutputStream(Thread.currentThread().getName()+".file");
            is.transferTo(fw);
            fw.close();
            is.close();
        }catch (Exception e){
            System.out.println("Exception happended at ClientHandler.java");
            e.printStackTrace();
        }

    }
}
