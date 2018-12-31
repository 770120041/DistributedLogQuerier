package com.zheliu.querier;

import com.zheliu.querier.Greper.FolderGreper;
import com.zheliu.querier.Network.Client;
import com.zheliu.querier.Network.Server;
import com.zheliu.querier.Test.FolderGrepTest;
import com.zheliu.querier.Test.SingleFileTest;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.ArrayList;

public class Main {
    /*
        The log file Root path is hard coded. Change it to your directory for your data
     */
    static String rootPath = "E:\\projects\\DistributedGreper\\src\\data\\";
    static String resultPath = rootPath+"\\result\\";

    static InetAddress address;
    static final int serverPort = 3666;
    static int clientPort;

    static boolean isServer;
    /*Unitest*/
    private static  void unitTest(){
        rootPath += "test\\";

        SingleFileTest singleFileTest = new SingleFileTest("public",rootPath+"testData.txt");
        singleFileTest.test();

        //accept all files
        FolderGrepTest folderGrepTest = new FolderGrepTest("public",rootPath,".*");
        folderGrepTest.test();

        //accpet only txt files
        folderGrepTest = new FolderGrepTest("public",rootPath,".*\\.txt");
        folderGrepTest.test();





    }


    /*
        For arguments:
        argument 0: determine if it is server
        argument 1: port number for client
        argumetn 2: clinet root path
     */

    static void setUpNetwork(String[] args){
        if (args[0].equals("server")){
            isServer = true;
        }
        else {
            isServer = false;
        }



        try {
            address = InetAddress.getLocalHost();
        }catch (Exception e){
            System.out.println("cannot get local host address");
        }

        if(args.length>1){
            rootPath += args[1]+"\\";
        }

    }

    public static void main(String[] args) {
        /*used to setup UnitTest or setup Interperter */
//        unitTest();

        if(args.length <2){
            System.out.println("needs more args for qurey");
            return;
        }
        else{
            setUpNetwork(args);
        }


        /*
            set up server and Client here
         */
        if(isServer){
            Server server = new Server(serverPort,resultPath);
            server.start();
        }
        Interpreter interpreter = new Interpreter(address,serverPort,rootPath);
        interpreter.interprept();



    }
}
