package TwoPointers;

import java.util.Arrays;
/*Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

Example 1:
Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].

Example 2:
Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]


Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.


Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?
*/
public class SquaresOfSortedArray {
    public static void main(String[] args) {
        int[] arr = {-7,-3,2,3,11};
        squaresOfArray(arr);
        bruteSquaresOfArray(arr);
    }

    //Using Optimized Two Pointers
    public static int[] squaresOfArray(int[] arr){
        int left=0,right=arr.length-1;
        int sq =0,i=arr.length-1;
        int[] res = new int[arr.length];
        while(left<=right){
            if(Math.abs(arr[left])>Math.abs(arr[right])) {
                sq = arr[left];
                left++;
            }else{
                sq = arr[right];
                right--;
            }
            res[i--] = sq * sq;
        }
        System.out.println(Arrays.toString(res));
        return res;
    }

    //Brute Force Approach
    public static int[] bruteSquaresOfArray(int[] arr){
        int n = arr.length;
       // int[] res = new int[n];
        for(int i =0;i<n;i++){
            arr[i] = arr[i] * arr[i];
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        return arr;
    }
}
