package com.zheliu.querier.Greper;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Greper {
    private Pattern pattern;
    private ArrayList<String> result;

    public Greper(String regExpr) {
        setPattern(regExpr);
        result = new ArrayList<String>();
    }

    public void setPattern(String regExpr) {
        this.pattern = Pattern.compile(regExpr);
    }

    public void grep(String line){
//        System.out.println(line);
        if(line == null){
            return;
        }
        Matcher m = pattern.matcher(line);
        if(m.find()){
            result.add(line);
        }
    }

    public ArrayList<String> getResult() {
        return result;
    }
}
