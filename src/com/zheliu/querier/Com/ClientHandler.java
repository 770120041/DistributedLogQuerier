package com.zheliu.querier.Com;

import com.zheliu.querier.Greper.FolderGreper;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler extends Thread {
    private Socket socket;
    private String name;
    private String rootPath;
    public ClientHandler(Socket socket,String name,String rootPath) {
        this.name = name;
        this.socket = socket;
        this.rootPath=rootPath;
    }


    public void run(){
        try {
            InputStreamReader isr = new InputStreamReader(socket.getInputStream()) ;
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            ArrayList<String> result = new ArrayList<String>();


            //flag indicates that this node received an request from another server to grep for it
            boolean flag = false;
            if(line != null) {
                String[] words = line.split("\\|");
                if(words[0].equals("query")) {
                    flag = true;
                    System.out.println("folder path is "+rootPath + " in clientHandler");
                    FolderGreper folderGreper = new FolderGreper(rootPath);
                    result = folderGreper.grepFolder(words[1]);
                    System.out.println("sending back result to "+words[2]+":"+words[3]);

                    Client client = new Client(InetAddress.getByName(words[2]),Integer.parseInt(words[3]));
                    client.sendToServer(result,name);
                }
            }

            //not reg query, means that this host require others to grep for it and it is now receiving the result.
            if(!flag){
                while(line != null) {
                    System.out.println(line);
                    line = br.readLine();
                }
            }


        }catch (Exception e){
            System.out.println("Exception happended at ClientHandler.java");
            e.printStackTrace();
        }

    }
}
