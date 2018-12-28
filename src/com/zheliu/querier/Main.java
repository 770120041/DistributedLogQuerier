package com.zheliu.querier;

import com.zheliu.querier.FileHandler.DirLister;
import com.zheliu.querier.Test.FolderGrepTest;
import com.zheliu.querier.Test.SingleFileTest;

public class Main {
    /*
        The log file Root path is hard coded. Change it to your directory for your data
     */
    static final String rootPath = "E:\\projects\\DistributedGreper\\src\\data\\";

    public static void main(String[] args) {

        //test for single file
        SingleFileTest singleFileTest = new SingleFileTest("public",rootPath+"testData.txt");
        singleFileTest.test();

        FolderGrepTest folderGrepTest = new FolderGrepTest("public",rootPath,".*\\\\.txt");
        folderGrepTest.test();




    }
}
