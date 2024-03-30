package Array;

import java.util.HashMap;
/*Given an integer array nums and an integer k, return the number of good subarrays of nums.

A good array is an array where the number of different integers in that array is exactly k.

For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
A subarray is a contiguous part of an array.



Example 1:

Input: nums = [1,2,1,2,3], k = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
Example 2:

Input: nums = [1,2,1,3,4], k = 3
Output: 3
Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].


Constraints:

1 <= nums.length <= 2 * 104
1 <= nums[i], k <= nums.length*/
public class SubArrayWithKDiffIntegers {
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,3};
        System.out.println(subarraysWithKDistinct(nums,2));
    }

    public static int subarraysWithKDistinct(int[] nums,int k){
        int subArray = subarrayWithAtmostK(nums,k);
        int reducedSubarray = subarrayWithAtmostK(nums,k-1);
        return subArray - reducedSubarray;
    }

    public static int subarrayWithAtmostK(int[] nums,int k){
        int n = nums.length;
        int ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int left=0,right=0;right<n;right++){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            while(map.size()>k){
                int count = map.get(nums[left]);
                if(count-1 == 0) map.remove(nums[left]);
                else map.put(nums[left],count-1);
                left++;
            }
            ans += right-left+1;
        }
        return ans;
    }
}
