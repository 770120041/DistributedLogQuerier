package com.zheliu.querier.Greper;

import com.zheliu.querier.FileHandler.DirLister;

import java.util.ArrayList;

public class FolderGreper {
    private ArrayList<String> result;
    private String dirPath;
    private ArrayList<String> fileNames;
    /*
       For getting file names, can use regular expression to filter some file out in this folder
    */
    public FolderGreper( String dirPath) {
        DirLister dirLister = new DirLister(dirPath);
        this.fileNames = dirLister.list();
        this.result = new ArrayList<String>();
        this.dirPath = dirPath;
    }


    public FolderGreper(String dirPath, String regFileName) {
        DirLister dirLister = new DirLister(dirPath);
        this.fileNames = dirLister.list(regFileName);
        this.result = new ArrayList<String>();
        this.dirPath = dirPath;
    }


    public ArrayList<String> getFileNames() {
        return fileNames;
    }

    public ArrayList<String> grepFolder(String reg){
        for (String file: fileNames
             ) {
            //must contain dirpath first

            FileGreper fileGreper = new FileGreper(dirPath + file);
            result.addAll(fileGreper.grepFile(reg));
        }
        return result;
    }


}
