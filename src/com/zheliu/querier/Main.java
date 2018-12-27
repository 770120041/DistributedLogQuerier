package com.zheliu.querier;

import com.zheliu.querier.Test.GreperTest;

public class Main {
    /*
        The log file Root path is hard coded
     */
    static final String rootPath = "E:\\projects\\DistributedGreper\\src\\data\\";

    public static void main(String[] args) {

        GreperTest tester = new GreperTest("public",rootPath+"testData.txt");
        tester.test();





        String fileName = "testData.txt";

    }
}
