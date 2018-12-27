package com.zheliu.querier;

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
            System.out.println("Reading from file:"+fileName+" failed");
        }

    }

    /*
        Using Inner class Sequencer to read from file
     */
    public Sequencer sequencer() {
        return new Sequencer();
    }

    class Sequencer{
        public String nextLine(){
            String line="";
            try {
                line = bufferedReader.readLine();
            } catch (IOException e){
                return null;
            }
            return line;
        }
    }
}



