package Array;
/*Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

Example 1:
Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.

Example 2:
Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

Constraints:
1 <= nums.length <= 105
nums[i] is either 0 or 1.*/

import java.util.HashMap;

public class ContinuousBinarySum {
    public static void main(String[] args) {
        int[] arr = {0,1,0};
        System.out.println(maxLength(arr));
    }

    public static int maxLength(int[] nums){
        int n = nums.length;
        int ans = 0,sum=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0) nums[i] = -1;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i=0;i<n;i++){
            sum += nums[i];
            if(map.containsKey(sum)){
                int len = map.get(sum);
                ans = Math.max(ans,i-len);
            }else{
                map.put(sum,i);
            }
        }
        return ans;
    }
}
