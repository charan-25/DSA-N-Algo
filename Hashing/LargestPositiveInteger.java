package Hashing;

import java.util.Arrays;
import java.util.HashSet;

/*Given an integer array nums that does not contain any zeros, find the largest positive integer k such that -k also exists in the array.

Return the positive integer k. If there is no such integer, return -1.



Example 1:

Input: nums = [-1,2,-3,3]
Output: 3
Explanation: 3 is the only valid k we can find in the array.
Example 2:

Input: nums = [-1,10,6,7,-7,1]
Output: 7
Explanation: Both 1 and 7 have their corresponding negative values in the array. 7 has a larger value.
Example 3:

Input: nums = [-10,8,6,7,-2,-3]
Output: -1
Explanation: There is no a single valid k, we return -1.


Constraints:

1 <= nums.length <= 1000
-1000 <= nums[i] <= 1000
nums[i] != 0*/
public class LargestPositiveInteger {
    public static void main(String[] args) {
        int[] arr = {-1,10,6,7,-7,1};
        System.out.println(findMaxK(arr));
        System.out.println(hashFindMax(arr));
        System.out.println(twoPointerFindMaxK(arr));
    }

    public static int findMaxK(int[] nums) {
        int n = nums.length;
        int ans = -1;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i]+nums[j]==0)
                    ans = Math.max(ans,Math.abs(nums[i]));
            }
        }
        return ans;
    }

    public static int hashFindMax(int[] nums){
        int ans = -1;
        HashSet<Integer> set = new HashSet<>();
        for(final int num : nums){
            if(set.contains(-num)) ans = Math.max(ans,Math.abs(num));
            else set.add(num);
        }
        return ans;
    }

    public static int twoPointerFindMaxK(int[] nums){
        Arrays.sort(nums);
        int s = 0,e=nums.length-1;
        while(s<e){
            if(nums[s]+nums[e]==0) return nums[e];
            else if(nums[s]+nums[e]>0) e--;
            else s++;
        }
        return -1;
    }

}
