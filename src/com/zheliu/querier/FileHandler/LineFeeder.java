package com.zheliu.querier.FileHandler;

import java.io.*;

public class LineFeeder {
    private String fileName;
    private FileInputStream fileInputStream;
    private BufferedReader bufferedReader;




    public LineFeeder(String fileName) throws Exception{
        this.fileName = fileName;
        try {
            fileInputStream = new FileInputStream(fileName);
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        } catch (Exception e){
            System.out.println("At LineFeeder :Reading from file:"+fileName+" failed");
//            e.printStackTrace();
        }

    }

    /*
        Using Inner class Sequencer to read from file
     */
    public Sequencer sequencer() {
        return new Sequencer();
    }

    public class Sequencer{
        public String nextLine(){
            String line;
            try {
                line = bufferedReader.readLine();
            } catch (Exception e){
                System.out.println("get line from:"+ fileName +" failed");

                return null;
            }
            return  line;
        }
    }
}



