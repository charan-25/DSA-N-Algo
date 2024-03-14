package Hashing;

import java.util.HashMap;

/*Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.

A subarray is a contiguous part of the array.



Example 1:

Input: nums = [1,0,1,0,1], goal = 2
Output: 4
Explanation: The 4 subarrays are bolded and underlined below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
Example 2:

Input: nums = [0,0,0,0,0], goal = 0
Output: 15


Constraints:

1 <= nums.length <= 3 * 104
nums[i] is either 0 or 1.
0 <= goal <= nums.length
*/
public class BinarySubarraySum {
    public static void main(String[] args) {
        int[] arr = {1,0,1,0,1};
        System.out.println(binarySubSum(arr,2));
    }

    public static int binarySubSum(int[] arr,int k){
        int n = arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum =0,ans =0;
        for(int i=0;i<n;i++){
            sum += arr[i];
            if(map.containsKey(sum-k)) ans += map.get(sum-k);

            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}
