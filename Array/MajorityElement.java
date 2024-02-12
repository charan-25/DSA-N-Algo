package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/*Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.



Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2


Constraints:

n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109*/
public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(arr));
        System.out.println(majorityElementUsingSorting(arr));
        System.out.println(majorityElementOptimized(arr));
    }

    //Using Hashing Approach TC :O(N) SC:O(N)
    public static int majorityElement(int[] arr){
        int n = arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue()> n/2)
                return entry.getKey();
        }
        return -1;
    }

    //Using Sorting Algorithm TC:O(NlogN) SC:O(1)
    public static int majorityElementUsingSorting(int[] arr){
        int n = arr.length;
        Arrays.sort(arr);
        return arr[n/2];
    }

    public static int majorityElementOptimized(int[] arr){
        int count =0,majority =arr[0];
        for(int num : arr){
            if(count==0){
                majority = num;
                count = 1;
            }else if (majority == num)
                count++;
            else
                count--;
        }
        System.out.println("Count :: "+count+" Element :: "+majority);
        return majority;
    }
}
