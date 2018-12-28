package com.zheliu.querier.FileHandler;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;
/*
    used to list all fils in a given class
    and Dirlister.list have an overloaded function to grep files with given reg expression
    (in my program only used to grep suffix)
 */

class DirFilter implements FilenameFilter{
    private Pattern pattern;

    public DirFilter(String reg) {
        this.pattern = Pattern.compile(reg);
    }

    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}

public class DirLister {
    private String dirPath;
    private DirFilter dirFilter;
    ArrayList<String> res = new ArrayList<String>();

    public DirLister(String dirPath) {
        this.dirPath = dirPath;
        this.res = new ArrayList<String>();

    }
    public ArrayList<String> list(){
        File path = new File(dirPath);
        res.addAll(Arrays.asList(path.list()));
        return res;
    }
    public ArrayList<String> list(String reg){

        File path = new File(dirPath);
        res.addAll(Arrays.asList(path.list(new DirFilter(reg))));
        return res;
    }

}
