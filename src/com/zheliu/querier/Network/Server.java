package com.zheliu.querier.Network;

import com.zheliu.querier.FileHandler.FolderCleaner;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    ServerSocket serverSocket;
    private  int counter;// used for different file names
    private String resultPath;
    public Server(int port,String resultPath) {
        /*
            If not exist: create it. Otherwise clean it
         */
        FolderCleaner folderCleaner = new FolderCleaner(resultPath);
        folderCleaner.clean();

        counter = 0;
        this.resultPath = resultPath;
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
                ClientHandler clientHandler = new ClientHandler(socket, "client"+counter,resultPath);
                clientHandler.start();
                counter++;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
