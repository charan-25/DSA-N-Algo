package Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class NQueens {

    public static void main(String[] args) {
        Set<String> set = new TreeSet<>((a,b)-> b.compareTo(a));
        set.add("Charan");
        set.add("Balaji");
        set.add("Ajay");
        set.add("Lakshmi");
        set.add("Yagyna");
        System.out.println(set);
       // System.out.println(solveNQueens(4));
    }

    public static ArrayList<ArrayList<Integer>> solveNQueens(int n){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int[][] arr = new int[n][n];
        nQueens(arr,res,0);
        return res;
    }

    public static void nQueens(int[][] arr,ArrayList<ArrayList<Integer>> res,int i){
        if(i==arr.length){
            res.add(insertToList(arr));
            return;
        }

        for(int c=0;c<arr.length;c++){

            if(isSafePlace(arr,i,c)){
                arr[i][c] = 1;
                nQueens(arr,res,i+1);
                arr[i][c] = 0;
            }
        }
    }

    public static boolean isSafePlace(int[][] arr,int i,int j){
        for(int r=i-1;r>=0;r--){
            if(arr[r][j] == 1)
                return false;
        }

        for(int r=i-1,c=j-1;r>=0 && c>=0;r--,c--){
            if(arr[r][c] == 1)
                return false;
        }

        for(int r=i-1,c=j+1;r>=0 && c<arr.length;r--,c++){
            if(arr[r][c] == 1)
                return false;
        }
        return true;
    }

    public static ArrayList<Integer> insertToList(int[][] arr){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                list.add(arr[i][j]);
            }
        }

        return list;
    }
}
