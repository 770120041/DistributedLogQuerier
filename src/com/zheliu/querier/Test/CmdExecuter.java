//package com.zheliu.querier.Test;
//
//import java.io.BufferedReader;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.util.concurrent.Executors;
//import java.util.function.Consumer;
//
//public class CmdExecuter {
//    private static class StreamHandler implements Runnable {
//        private InputStream inputStream;
//
//        public StreamHandler(InputStream inputStream) {
//            this.inputStream = inputStream;
//        }
//
//        @Override
//        public void run() {
//            boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
//            String homeDirectory = System.getProperty("user.home");
//            Process process;
//            if (isWindows) {
//                process = Runtime.getRuntime()
//                        .exec(String.format("cmd.exe /c dir %s", homeDirectory));
//            } else {
//                process = Runtime.getRuntime()
//                        .exec(String.format("sh -c ls %s", homeDirectory));
//            }
//            StreamHandler streamGobbler =
//                    new StreamHandler(process.getInputStream(), System.out::println);
//            Executors.newSingleThreadExecutor().submit(streamGobbler);
//            int exitCode = process.waitFor();
//            assert exitCode == 0;
//        }
//    }
//}
