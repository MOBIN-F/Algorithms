package com.mobin.JianZhiOffer;

/**
 * Created by Mobin on 2016/6/5.
 * 把字符串中的空格替换成其他字符串
 */
public class ReplaceBlack {
    public static  void replaceBlack(char[] string,int length){
        if(string == null || string.length <=0)
            return;
        int orginalLength= 0;//字符串string的实际长度，也包括了空格
        int numberOfBlack = 0;
        int i= 0;
        //遍历字符串，确定替换前与替换后的字符串长度
        while(string[i] != '\0'){
            ++ orginalLength;
            if(string[i] == ' ')
                ++ numberOfBlack;
            ++ i;
        }

        //替换后字符串的长度,每个空格被替换后字符串长度加2
        int newLength = orginalLength + numberOfBlack * 2;
        if(newLength > length)
            return;

        int indexOfOriginal = orginalLength;
        int indexOfNew = newLength;
        //当indexOfNew = indexOfOriginal时说明空格已经全部被替换完
        while (indexOfNew >= 0 && indexOfNew > indexOfOriginal){
            if(string[indexOfOriginal] == ' '){
                string[indexOfNew --] = '0';
                string[indexOfNew --] = '2';
                string[indexOfNew --] = '%';
            }else
                string[indexOfNew --] = string[indexOfOriginal];  //复制字符

            -- indexOfOriginal;

        }
        System.out.print("空格被替换后的字符串：");
        System.out.println(string);
    }

    public static void main(String[] args) {
        char[] c = new char[20];
        c[0] = 'w';
        c[1] = 'e';
        c[2] = ' ';
        c[3] = 'a';
        c[4] = 'r';
        c[5] = 'e';
        c[6] = '\0';
        replaceBlack(c,c.length);
    }
}
