package com.zheliu.querier.Com;

import com.zheliu.querier.FileHandler.FolderCleaner;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread{
    ServerSocket serverSocket;
    private String rootPath;
    public Server(int port,String rootPath) {

//        FolderCleaner folderCleaner = new FolderCleaner(rootPath);
//        folderCleaner.clean();
        this.rootPath = rootPath;
        try {
            this.serverSocket = new ServerSocket(port);
            System.out.println("Server started at:"+InetAddress.getLocalHost()+":"+port);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void run(){
        while (true){
            try {
                Socket socket = serverSocket.accept();
                System.out.println("Server received message from port:"+socket.getPort());
                ClientHandler clientHandler = new ClientHandler(socket,serverSocket.getInetAddress().toString() +serverSocket.getLocalPort() ,rootPath);
                clientHandler.start();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
