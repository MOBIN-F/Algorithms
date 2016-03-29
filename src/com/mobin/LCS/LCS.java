package com.mobin.LCS;

/**
 * Created by Mobin on 2016/2/22.
 */
public class LCS {
    /*
    * 公式：
    * LCS[i,j] ==  0  if i==0 or j ==0
      LCS[i,j] == LCS[i - 1, j -1]   if i,j > 0且 i == j
      LCS[i,j] == max(LCS[i-1,j],LCS[I,j-1])
    * */
    //求出LCS的长度
    public static int[][] length_LCS(char[] x,char[] y){
        //子问题的LCS长度
        int x_len = x.length;
        int y_len = y.length;
        int[][] c = new int[x_len+1][y_len+1];
        int[][] b = new int[x_len+1][y_len+1];

        for(int i = 1; i <= x_len;i ++){
            for(int j = 1; j <=y_len; j ++){
                  if(x[i-1] == y[j-1]) {
                      c[i][j] = c[i - 1][j - 1] + 1;
                      b[i][j] = 1;
                  }
                else if(c[i-1][j] > c[i][j-1]){
                            c[i][j] = c[i-1][j];
                            b[i][j] = 2;
                  }else {
                      c[i][j] = c[i][j - 1];
                      b[i][j] = 3;
                  }


            }
        }
        return b;

    }

    //自底向上输出LCS
    public static  void print_LCS(char[] x,int[][] b,int i,int j){
           if(i ==0 || j == 0)
               return;
           if(b[i][j] == 1){
                print_LCS(x,b,i-1,j-1);
               System.out.print(x[i-1]);
           }else if(b[i][j] == 2)
               print_LCS(x,b,i-1,j);
        else
               print_LCS(x,b,i,j-1);
    }

    public  static  void main(String[] args){
        char[] x = {'a','b','c','f','h','a','n'} ;
        char[] y = {'a','c','d','f','h','a','n'};
        int[][] b = length_LCS(x,y);
       print_LCS(x,b,x.length,y.length);
    }
}
