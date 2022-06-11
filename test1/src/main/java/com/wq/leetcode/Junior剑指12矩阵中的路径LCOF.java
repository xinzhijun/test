package com.wq.leetcode;

public class Junior剑指12矩阵中的路径LCOF {
    public boolean exist(char[][] board, String word) {
        int size1 = board.length,size2=board[0].length;
        char[] s = word.toCharArray();
        for(int k =0;k<s.length;k++){
            for(int i=0;i<size1;i++){
                for(int j=0;j<size2;j++){
                    if(find(board,i,j,s,0)){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    boolean find(char[][] s,int l,int r,char[] w,int k){
        if(l>s.length||r<0||r>s[0].length||s[l][r]!=w[k]){
            return false;
        }
        s[l][r]='\0';
        if(k==w.length-1) return true;
        boolean rs = find(s,l+1,r,w,k+1)||find(s,l-1,r,w,k+1)||find(s,l,r+1,w,k+1)||find(s,l,r-1,w,k+1);
        s[l][r] = w[k];
        return rs;
    }
}
