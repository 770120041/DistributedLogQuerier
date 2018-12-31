package com.zheliu.querier;

import com.zheliu.querier.Greper.FolderGreper;
import com.zheliu.querier.Network.Client;
import com.zheliu.querier.Test.FolderGrepTest;

import java.io.DataInputStream;
import java.io.StringBufferInputStream;
import java.io.StringReader;
import java.net.InetAddress;
import java.util.Scanner;

public class Interpreter {
    private String rootPath;
    private int serverPort;
    private InetAddress serverAddr;

    public Interpreter(InetAddress serverAddr,int serverPort,String rootPath) {
        this.rootPath = rootPath;
        this.serverPort = serverPort;
        this.serverAddr = serverAddr;
    }

    public void interprept(){
        Scanner in = new Scanner(System.in);
        while(true){
            String reg = in.nextLine();
            if(reg.equals("quit") || reg.equals("exit")){
                break;
            }
            System.out.println(rootPath);
            FolderGreper folderGreper = new FolderGreper(rootPath,".*");
            System.out.println("filenames:"+folderGreper.getFileNames());
            Client client = new Client(serverAddr,serverPort);
            client.sendToServer(folderGreper.grepFolder(reg));

        }

    }
}
