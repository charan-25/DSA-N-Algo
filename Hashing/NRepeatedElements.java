package Hashing;

import java.util.HashMap;

/*You are given an integer array nums with the following properties:

nums.length == 2 * n.
nums contains n + 1 unique elements.
Exactly one element of nums is repeated n times.
Return the element that is repeated n times.



Example 1:

Input: nums = [1,2,3,3]
Output: 3
Example 2:

Input: nums = [2,1,2,5,3,2]
Output: 2
Example 3:

Input: nums = [5,1,5,2,5,3,5,4]
Output: 5


Constraints:

2 <= n <= 5000
nums.length == 2 * n
0 <= nums[i] <= 104
nums contains n + 1 unique elements and one of them is repeated exactly n times.*/
public class NRepeatedElements {
    public static void main(String[] args) {
        int[] arr = {5,1,5,2,5,3,5,4};
        System.out.println(repeatedNTimes(arr));
    }

    public static int repeatedNTimes(int[] arr){
        int len = arr.length,n=len/2;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : arr) map.put(num,map.getOrDefault(num,0)+1);

        for(Integer key:map.keySet()){
            int val = map.get(key);
            if(val==n) return key;
        }
        return -1;
    }
}
