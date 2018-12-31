package com.zheliu.querier.Com;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;


/*
    Client shall open a socket Each time, and close it afterwards
    Shall not maintain a socket, because it will make it hard to determine when it stops
 */
public class Client {
    private Socket socket;

    public Client(InetAddress address, int port) {
        try {
            this.socket = new Socket(address,port);
        }catch (Exception e){
            System.out.println("Cannot creat Socket for port:"+port);
            throw new RuntimeException("cannot initial socket");
        }
    }
    public void sendToServer(ArrayList<String> msg){
        try {
            System.out.println("client send message to Server!");
            OutputStream os =  socket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(msg);
            os.close();
            oos.close();
            socket.close();
            System.out.println("socket closed");
        }catch (Exception e){
            System.out.println("Exception in Client.java in method sendToServer");
        }
    }


}
