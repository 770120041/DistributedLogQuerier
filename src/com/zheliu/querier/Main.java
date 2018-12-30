package com.zheliu.querier;

import com.zheliu.querier.Test.FolderGrepTest;
import com.zheliu.querier.Test.SingleFileTest;

public class Main {
    /*
        The log file Root path is hard coded. Change it to your directory for your data
     */
    static final String rootPath = "E:\\projects\\DistributedGreper\\src\\data\\";


    /*Unitest*/
    private static  void unitTest(){
        SingleFileTest singleFileTest = new SingleFileTest("public",rootPath+"testData.txt");
        singleFileTest.test();

        FolderGrepTest folderGrepTest = new FolderGrepTest("public",rootPath,".*\\.txt");
        folderGrepTest.test();

        folderGrepTest = new FolderGrepTest("public",rootPath,".*\\.txt");
        folderGrepTest.test();

    }

    public static void main(String[] args) {
        unitTest();

    }
}
