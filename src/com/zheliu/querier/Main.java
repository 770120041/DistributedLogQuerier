package com.zheliu.querier;

import java.io.*;
import java.net.ServerSocket;
import java.util.ArrayList;

public class Main {
    static final String rootPath = "E:\\projects\\DistributedGreper\\src\\data\\";

    public static void main(String[] args) {
	// write your code here
        Greper greper = new Greper("public");

        String fileName = "data1.txt";
        try {
            LineFeeder lineFeeder = new LineFeeder(rootPath+fileName);
            LineFeeder.Sequencer sequencer =  lineFeeder.sequencer();

            String line = sequencer.nextLine();
            while (line != null){
                greper.grep(line);
                line = sequencer.nextLine();
            }
            ArrayList<String> res = greper.getResult();
            for (String x: res
                 ) {
                System.out.println(x);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
