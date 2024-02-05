package Backtracking;

/*Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.



Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]


Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.
*/

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
