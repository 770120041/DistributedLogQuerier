package com.zheliu.querier.Com;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;


/*
    Client shall open a socket Each time, and close it afterwards
    Shall not maintain a socket, because it will make it hard to determine when it stops
 */
public class Client {
    private Socket socket;
    private int localPort;

    public Client(InetAddress address, int port) {
        try {
            this.socket = new Socket(address,port);
        }catch (Exception e){
            System.out.println("Cannot creat Socket for port:"+port);
            throw new RuntimeException("cannot initial socket");
        }
    }

    public Client(InetAddress address, int port,int localPort) {
        this(address,port);
        this.localPort = localPort;
    }

    public void sendToServer(ArrayList<String> msg,String name){
        try {
            System.out.println("client send message back to Server!");
            OutputStream os =  socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            for (String x: msg
                 ) {
                pw.println("From:" + name+" about:"+x);
            }
            pw.close();
            socket.close();
            System.out.println("socket closed");
        }catch (Exception e){
            System.out.println("Exception in Client.java in method sendToServer");
        }
    }
    /*
        local Ip and port is used for server to send info back
     */
    public void sendToServer(String reg,String localIp,int port){
        try {
            OutputStream os =  socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.println("query|"+reg+"|"+localIp+"|"+port);
            pw.close();
            socket.close();

        }catch (Exception e){
            System.out.println("Exception in client.java for second method");
        }

    }


}
