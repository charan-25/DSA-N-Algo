package Hashing;

import java.util.HashMap;

/*Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:
Input: nums = [1,1,1], k = 2
Output: 2

Example 2:
Input: nums = [1,2,3], k = 3
Output: 2

Constraints:
1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107*/
public class SubarraySumK {
    public static void main(String[] args) {
        int[] arr ={1,-1,0};
        System.out.println(subarraySum(arr,0));
        System.out.println(bruteSubarraySum(arr,0));
    }


    //Optimized Using HashMaps TC:O(N) SC:O(N)
    public static int subarraySum(int[] arr,int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum =0,count =0;
        for(int num : arr) {
            sum += num;
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    //Brute Force TC:(N^3) SC:O(1)
    public static int bruteSubarraySum(int[] arr,int target){
        int count =0,n=arr.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int sum = 0;
                for(int k=i;k<=j;k++){
                    sum += arr[k];
                }
                if(sum ==0)
                    count++;
            }
        }
        return count;
    }
}
