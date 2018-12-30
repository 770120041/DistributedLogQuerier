package com.zheliu.querier.FileHandler;

import java.io.File;

public class FolderCleaner {
    private String folderPath;

    public FolderCleaner(String folderPath) {
        this.folderPath = folderPath;
    }
    public void clean(){
        File folder = new File(folderPath);
        /*
            If not exist: create it. other wise clean it
         */
        if(!folder.exists()){
            folder.mkdirs();
        }
        String[]entries = folder.list();
        for(String s: entries){
            File currentFile = new File(folder.getPath(),s);
            currentFile.delete();
        }
    }
}
