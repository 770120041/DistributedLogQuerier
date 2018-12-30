package com.zheliu.querier.Test;

import com.zheliu.querier.Greper.FileGreper;

import java.util.ArrayList;

/*
    Unit test for Single File Greper
 */
public class SingleFileTest {
    private FileGreper fileGreper;
    private static final int presetResult = 30;
    private String reg;
    public SingleFileTest(String reg,String fileName) {
        this.reg = reg;
        this.fileGreper = new FileGreper(fileName);
    }
    public void test(){
        System.out.println("Performing Test for Single File:");
        ArrayList<String> result = fileGreper.grepFile(reg);
        int grepResult = result.size();
        assert grepResult == presetResult ;
        System.out.println("GrepResult:"+ grepResult+" vs PresetResult:"+presetResult);
        System.out.println();
    }
}

