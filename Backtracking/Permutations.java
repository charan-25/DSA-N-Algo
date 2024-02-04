package Backtracking;

import java.util.ArrayList;

public class Permutations {

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(permute(arr));
    }

    public static ArrayList<ArrayList<Integer>> permute(int[] arr){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        permutations(arr,res,0);
        return res;
    }

    public static void permutations(int[] arr,ArrayList<ArrayList<Integer>> res,int i){
        if(i==arr.length-1){
            res.add(insertToList(arr));
            return ;
        }
        for(int k=i;k<arr.length;k++){
            swap(arr,i,k);
            permutations(arr,res,i+1);
            swap(arr,i,k);
        }
    }

    public static void swap(int[] arr,int i,int k){
        int temp = arr[i];
        arr[i] = arr[k];
        arr[k] = temp;
    }

    public static ArrayList<Integer> insertToList(int[] arr){
        ArrayList<Integer> res = new ArrayList<>();
        for(int num:arr) res.add(num);
        return res;
    }
}
