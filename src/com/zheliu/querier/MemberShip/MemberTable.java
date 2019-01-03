package com.zheliu.querier.MemberShip;

import java.net.InetAddress;
import java.util.ArrayList;

/*
    Using Json to hard coded all the members
 */

public class MemberTable {
    public static class MemberInfo{
        private InetAddress IP;
        private int port;
        public MemberInfo(InetAddress IP, int port) {
            this.IP = IP;
            this.port = port;
        }

        public InetAddress getIP() {
            return IP;
        }

        public int getPort() {
            return port;
        }
    }
    private ArrayList<MemberInfo> table;
    private  int size;

    public MemberTable() {
        this.size = 0;
        this.table = new ArrayList<MemberInfo>();
    }
    public void addTable(InetAddress IP,int port){
        table.add(new MemberInfo(IP,port));
        size++;
    }
    public ArrayList<MemberInfo> getTable(){
        return table;
    }
}
