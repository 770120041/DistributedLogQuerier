package com.zheliu.querier.Test;

import com.zheliu.querier.Greper.FolderGreper;
/*
    Unit Test for Folder Greper
 */

public class FolderGrepTest {
    private String folderPath;
    private String regFileName;
    private String regContent;
    private static final int predefinedResult = 30;
    public FolderGrepTest(String reg,String folderPath,String regFileName) {
        this.regContent = reg;
        this.folderPath = folderPath;
        this.regFileName = regFileName;
    }
    public void test(){
        System.out.println("Performing folder grep test:");
        System.out.println("FolderPath:"+folderPath);

        FolderGreper folderGreper = new FolderGreper(folderPath,regFileName);
        System.out.println("filenames:"+folderGreper.getFileNames());

        int grepResultLength = folderGreper.grepFolder(regContent).size();
        assert grepResultLength == predefinedResult;
        System.out.println("FolderGreper:"+grepResultLength+" vs PredefinedResult:"+predefinedResult);
        System.out.println();
    }
}
