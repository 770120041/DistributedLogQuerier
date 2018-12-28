package com.zheliu.querier.Greper;

import com.zheliu.querier.FileHandler.LineFeeder;

import java.util.ArrayList;

public class FileGreper {
    private LineFeeder.Sequencer sequencer;

    public FileGreper( String filePath) {
        try {
            LineFeeder lineFeeder = new LineFeeder(filePath);
            this.sequencer =  lineFeeder.sequencer();
        }catch (Exception e){
            System.out.println("Tester Initialied failed, cannot open file:"+filePath);
        }

    }
    public ArrayList<String> grepFile(String reg){
        Greper greper = new Greper(reg);
        String line = sequencer.nextLine();
        while (line != null){
            greper.grep(line);
            line = sequencer.nextLine();
        }
        ArrayList<String> res = greper.getResult();
        return res;
    }
}
