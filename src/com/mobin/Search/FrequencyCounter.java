package com.mobin.Search;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by Mobin on 2016/4/16.
 */
public class FrequencyCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<String,Integer> treeMap = new TreeMap<String,Integer>();
        while (sc.hasNext()){
            //构造字符表
            String word = sc.next();
            if(!treeMap.containsKey(word))
                treeMap.put(word,1);
            else
                treeMap.put(word,treeMap.get(word)+1);
            }

        //找出出现频率最高的字符
        String max = "";
        treeMap.put(max,0);
        for (String word : treeMap.keySet())
         if(treeMap.get(word) > treeMap.get(max))
             max = word;

        System.out.println("出现次数最多的字符："+max+"  出现了 "+treeMap.get(max)+" 次");
        }


    }
