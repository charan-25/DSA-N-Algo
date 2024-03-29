package Array;
/*You are given an integer array nums and a positive integer k.

Return the number of subarrays where the maximum element of nums appears at least k times in that subarray.

A subarray is a contiguous sequence of elements within an array.



Example 1:

Input: nums = [1,3,2,3,3], k = 2
Output: 6
Explanation: The subarrays that contain the element 3 at least 2 times are: [1,3,2,3], [1,3,2,3,3], [3,2,3], [3,2,3,3], [2,3,3] and [3,3].
Example 2:

Input: nums = [1,4,2,1], k = 3
Output: 0
Explanation: No subarray contains the element 4 at least 3 times.


Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 106
1 <= k <= 105
*/
public class CountSubarrayWithMaxEleKTimes {
    public static void main(String[] args) {
        int[] arr = {1,3,2,3,3};
        System.out.println(subarraysWithKMax(arr,2));
    }

    public static long subarraysWithKMax(int[] nums,int k){
        int n = nums.length;
        int max_num = 1;
        for(int i=0;i<n;i++){
            max_num = Math.max(max_num,nums[i]);
        }
        long count=0,ans=0;
        for(long left =0,right=0;right<n;right++){
            if(nums[(int)right]==max_num)
                count++;
            while(count>=k){
                if(nums[(int)left]==max_num)
                    count--;
                left++;
                ans += n-right;
            }
        }
        return ans;
    }
}
