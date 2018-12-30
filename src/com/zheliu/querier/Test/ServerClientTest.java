package com.zheliu.querier.Test;

import com.zheliu.querier.Network.Client;

import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

public class ServerClientTest {
    private ArrayList<String> msg;
    private int port;
    private InetAddress address;

    public ServerClientTest(ArrayList<String> msg, InetAddress address, int port) {
        this.msg = msg;
        this.port = port;
    }
    public void test(){
        Client client = new Client(address,port);
        client.sendToServer(msg);
    }
}
