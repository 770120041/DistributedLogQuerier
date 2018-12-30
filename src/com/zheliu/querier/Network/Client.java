package com.zheliu.querier.Network;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

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
            OutputStream os =  socket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(msg);
            os.close();
            oos.close();
        }catch (Exception e){
            System.out.println("Exception in Client.java in method sendToServer");
        }
    }


}
