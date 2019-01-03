package com.zheliu.querier;

import com.zheliu.querier.Greper.FolderGreper;
import com.zheliu.querier.Com.Client;
import com.zheliu.querier.MemberShip.MemberTable;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Scanner;

public class Interpreter {
    private String rootPath;
    private MemberTable memberTable;
    /*
        local IP and port is used for each node to tell server about itself
     */
    private InetAddress localIP;
    private int localPort;
    public Interpreter(String rootPath,InetAddress localIP,int localPort) {
        this.rootPath = rootPath;
        this.memberTable = new MemberTable();
        initMemberTable();
        this.localIP = localIP;
        this.localPort = localPort;
    }

    //Hard coded server address for each node

    private void initMemberTable(){
        try {
            memberTable.addTable(InetAddress.getLocalHost(),9001);
            memberTable.addTable(InetAddress.getLocalHost(),9002);
            memberTable.addTable(InetAddress.getLocalHost(),9003);
            memberTable.addTable(InetAddress.getLocalHost(),9004);
        }catch (Exception e){
            System.out.println("Exception when creating member table in Interpreter.java");
        }

    }

    public void interprept(){
        Scanner in = new Scanner(System.in);
        while(true){
            String reg = in.nextLine();
            if(reg.equals("quit") || reg.equals("exit")){
                break;
            }
            System.out.println(rootPath);

            //send reg to each server in the member table
            for (MemberTable.MemberInfo info: memberTable.getTable()
                 ) {
                String temp = localIP.toString();
                String IP = temp.substring(temp.indexOf("/")+1,temp.length());
                Client client = new Client(info.getIP(),info.getPort());
                client.sendToServer(reg,IP,localPort);
            }
        }

    }
}
