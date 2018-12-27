package com.zheliu.querier.Test;

import com.zheliu.querier.Greper;
import com.zheliu.querier.LineFeeder;

import java.util.ArrayList;

public class GreperTest {
    private Greper greper;
    private LineFeeder.Sequencer sequencer;
    private static int publicResult = 30;
    public GreperTest(String reg, String filePath) {
        this.greper = new Greper(reg);
        try {
            LineFeeder lineFeeder = new LineFeeder(filePath);
            this.sequencer =  lineFeeder.sequencer();
        }catch (Exception e){
            System.out.println("Tester Initialied failed, cannot open file:"+filePath);
        }

    }
    public void test(){
        try {
            String line = sequencer.nextLine();
            while (line != null){
                greper.grep(line);
                line = sequencer.nextLine();
            }
            ArrayList<String> res = greper.getResult();
            System.out.println(res.size()  == publicResult);
        }catch (Exception e){
            System.out.println("Cannot read lines");
            e.printStackTrace();
        }
    }


}
