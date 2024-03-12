package Array;

import java.util.Arrays;
import java.util.HashMap;

/*You are given an integer array nums consisting of 2 * n integers.

You need to divide nums into n pairs such that:

Each element belongs to exactly one pair.
The elements present in a pair are equal.
Return true if nums can be divided into n pairs, otherwise return false.



Example 1:

Input: nums = [3,2,3,2,2,2]
Output: true
Explanation:
There are 6 elements in nums, so they should be divided into 6 / 2 = 3 pairs.
If nums is divided into the pairs (2, 2), (3, 3), and (2, 2), it will satisfy all the conditions.
Example 2:

Input: nums = [1,2,3,4]
Output: false
Explanation:
There is no way to divide nums into 4 / 2 = 2 pairs such that the pairs satisfy every condition.


Constraints:

nums.length == 2 * n
1 <= n <= 500
1 <= nums[i] <= 500*/
public class DivideArray {
    public static void main(String[] args) {
        int[] arr = {3,2,3,2,2,2};
        System.out.println(isDivisible(arr));
        System.out.println(bruteIsDivisible(arr));
        System.out.println(betterIsDivisible(arr));
    }

    //Optimized Solution
    public static boolean isDivisible(int[] arr){
        int[] frequencyCount = new int[1001];
        for(int num:arr){
            frequencyCount[num]++;
        }

        for(int num:arr){
            if(frequencyCount[num]%2 !=0) return false;
        }

        return true;
    }

    public static boolean bruteIsDivisible(int[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:arr) map.put(num,map.getOrDefault(num,0)+1);

        for(int key : map.keySet()){
            int value = map.get(key);
            if(value%2 != 0) return false;
        }
        return true;
    }

    //Better Approach
    public static boolean betterIsDivisible(int[] arr){
        int n = arr.length;
        Arrays.sort(arr);
        for(int i=0;i<n-1;i=i+2){
            if(arr[i]!=arr[i+1]) return false;
        }
        return true;
    }
}
