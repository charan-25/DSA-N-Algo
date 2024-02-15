package Searching;

import java.util.Arrays;

/*Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]


Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109*/
public class FirstAndLastOccurence {
    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,8,8,9,9,10,10,10};
        int[] res = firstAndLastOccurrence(arr,8);
        System.out.println(Arrays.toString(res));
    }

    public static int[] firstAndLastOccurrence(int[] arr,int target){
        int left = 0,right = arr.length-1;
        int[] res = new int[]{-1,-1};
        if(arr.length==0||arr==null) return res;
        while(left<right){
            int mid = left + (right-left)/2;
            if(arr[mid]<target)
                left = mid + 1;
            else
                right = mid;
        }
        if(arr[left]!= target) return res;
        res[0] = left;
        right = arr.length-1;
        while(left<right){
            int mid = left + (right-left)/2 +1;
            if(arr[mid]>target)
                right = mid-1;
            else
                left = mid;
        }
        res[1] = right;
        return res;
    }
}
