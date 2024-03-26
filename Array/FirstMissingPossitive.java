package Array;

import java.util.Arrays;
/*Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.

You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.



Example 1:

Input: nums = [1,2,0]
Output: 3
Explanation: The numbers in the range [1,2] are all in the array.
Example 2:

Input: nums = [3,4,-1,1]
Output: 2
Explanation: 1 is in the array but 2 is missing.
Example 3:

Input: nums = [7,8,9,11,12]
Output: 1
Explanation: The smallest positive integer 1 is missing.


Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1*/
public class FirstMissingPossitive {
    public static void main(String[] args) {
        int[] arr = {3,4,-1,1};
        System.out.println(missingNumber(arr));
    }

    public static int missingNumber(int[] nums){
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]<=0 || nums[i]>n)
                nums[i] = n+1;
        }

        for(int i=0;i<n;i++){
            int num = Math.abs(nums[i]);
            if(num>n)
                continue;
            num--;
            if(nums[num]>0)
                nums[num] = -1 * nums[num];
        }

        for(int i=0;i<n;i++){
            if(nums[i]>=0)
                return i+1;
        }
        return n;
    }
}
