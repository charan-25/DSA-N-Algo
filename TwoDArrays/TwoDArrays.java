package TwoDArrays;
/*You are given an m x n integer matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.



Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false


Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104*/
public class TwoDArrays {
    public static void main(String[] args) {
        int[][] arr ={{1,3,5,7},{10,11,16,17},{23,30,34,60}};
        System.out.println(searchElement(arr,3));
        System.out.println(bruteSearchElement(arr,3));
    }

    //Optimized Approach
    public static boolean searchElement(int[][] arr,int target){
        int n = arr.length,m=arr[0].length;
        int i=0,j=m-1;
        while(i<n && j>=0){
            if(arr[i][j]==target)
                return true;
            else if(arr[i][j]>target)
                j--;
            else
                i++;
        }
        return false;
    }

    //Brute Force Approach
    public static boolean bruteSearchElement(int[][] arr,int target){
        int n = arr.length,m=arr[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==target)
                    return true;
            }
        }
        return false;
    }
}
