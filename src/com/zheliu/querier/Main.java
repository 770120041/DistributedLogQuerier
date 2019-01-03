package com.zheliu.querier;

import com.zheliu.querier.Com.Server;
import com.zheliu.querier.Test.FolderGrepTest;
import com.zheliu.querier.Test.SingleFileTest;

import java.net.InetAddress;

public class Main {
    /*
        The log file Root path is hard coded. Change it to your directory to where your data is stored
     */
    static String rootPath = "E:\\projects\\DistributedGreper\\src\\data\\";;



    static InetAddress address;
    static int serverPort;

    static boolean isIntro = false;




    /*
        Actually node has a server. When we grep a word, the node will send to all servers in the whole member table.
        And after that, each host send the result back to the server. And the server printed out the result.

        For arguments:
        argument 0: port number for the server
        argumetn 1: data may reside in a subFolder of the root path
     */

    static void setUpServer(String[] args){
        serverPort = Integer.parseInt(args[0]);
        try {
            address = InetAddress.getLocalHost();
        }catch (Exception e){
            System.out.println("cannot get local host address");
        }

        rootPath += args[1]+"\\";
    }

    public static void main(String[] args) {

//        unitTest();

        if(args.length <2){
            System.out.println("needs more args for server set up");
            return;
        }
        else{
            setUpServer(args);
        }

        /*
            set up server here
         */
        Server server = new Server(serverPort,rootPath);
        server.start();


        Interpreter interpreter = new Interpreter(rootPath,address,serverPort);
        interpreter.interprept();

    }

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
}
