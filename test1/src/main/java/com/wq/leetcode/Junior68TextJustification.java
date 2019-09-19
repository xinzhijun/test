package com.wq.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Junior68TextJustification {
    public static List<String>  fullJustify(String[] words, int maxWidth) {
        int total = 0;
        StringBuilder group = new StringBuilder();
        //todo 每组
        List<String> juniorGroup = new ArrayList<>(words.length);
        List<String> finalGroup = new ArrayList<>(words.length);
        //todo 最小空格数
        int minNil = 0;
        for(String one:words){
            if((total+one.length())>(maxWidth-juniorGroup.size())){
                //todo 空格数
                float div =(juniorGroup.size()-1)<1?1:(juniorGroup.size()-1);
                int nil = Math.round((maxWidth-total)/div);
                if (minNil != 0) {
                    if(nil<minNil){
                        minNil =nil;
                    }
                } else {
                    minNil =nil;
                }
                int max = maxWidth;
                for(String ss:juniorGroup){
                    if((max-ss.length())<0){
                        group.delete(group.length()-(ss.length()-max),group.length());
                    }
                    group.append(ss);
                    max -=ss.length();
                    if(max>0){
                        for(int i=0;i<nil;i++,max--){
                            group.append("$");
                        }
                    }

                }
                for(int i=0;i<max;i++){
                    group.append("$");
                }
                finalGroup.add(group.toString());
                group.delete(0,group.length());
                juniorGroup.clear();
                juniorGroup.add(one);
                total = one.trim().length();
            }else{
                juniorGroup.add(one);
                total +=one.trim().length();
            }
        }
        //todo 最后一行
        int max = maxWidth;
        minNil = minNil-1>0?minNil-1:1;
        for(String ss:juniorGroup){
            group.append(ss);
            max -=ss.length();
            if(max>0){
                for(int i=0;i<minNil;i++,max--){
                    group.append("$");
                }
            }
        }
        for(int i=0;i<max;i++){
            group.append("$");
        }
        finalGroup.add(group.toString());
        return finalGroup;
    }

    public static  void main(String[] args){
//        String[] words =new String[]{"What","must","be","acknowledgment","shall","be"};
//        String[] words =new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        String[] words =new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};

        int maxWidth = 20;
        List<String>  fina = fullJustify(words,maxWidth);
        fina.forEach(System.out::println);
    }
}
