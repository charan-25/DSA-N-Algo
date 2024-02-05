package Backtracking;
/*Problem statement
You are given an integer 'N'. For a given 'N' x 'N' chessboard, find a way to place 'N' queens such that no queen can attack any other queen on the chessboard.

A queen can be killed when it lies in the same row, or same column, or the same diagonal of any of the other queens. You have to print all such configurations.

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= 'N' <= 10

Time Limit: 1sec


For Example:
For a chessboard of size 4*4
The configurations are

Sample Input 1:
4
Sample Output 1:
0 0 1 0 1 0 0 0 0 0 0 1 0 1 0 0
0 1 0 0 0 0 0 1 1 0 0 0 0 0 1 0
Explanation For Sample Input 1:
Output depicts two possible configurations of the chessboard for 4 queens.

The Chessboard matrix for the first configuration looks as follows:-

0 0 1 0
1 0 0 0
0 0 0 1
0 1 0 0

Queen contained cell is depicted by 1. As seen, No queen is in the same row, column, or diagonal as the other queens. Hence this is a valid configuration.
Sample Input 2:
3
Sample Output2:
      (Blank)
Explanation For Sample Input 2:
Since no possible configuration exists for 3 Queen's.The output remains Empty.*/

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
