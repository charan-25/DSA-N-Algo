package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Example 1:
Input: nums = [3,2,3]
Output: [3]
Example 2:

Input: nums = [1]
Output: [1]
Example 3:

Input: nums = [1,2]
Output: [1,2]

Constraints:
1 <= nums.length <= 5 * 104
-109 <= nums[i] <= 109
*/
public class MajorityElementII {
    public static void main(String[] args) {
        int[] arr = {3,2,3};
        System.out.println(majorityElement(arr));
    }

    public static List<Integer> majorityElement(int[] nums){
        int n = nums.length;
        if(n<3){
            if(n==1||(n==2 && nums[0]==nums[1])){
                List<Integer> list = new ArrayList<>();
                list.add(nums[0]);
                return list;
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(nums[0]);
                list.add(nums[1]);
                return list;
            }
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:nums)map.put(num,map.getOrDefault(num,0)+1);
        List<Integer> res = new ArrayList<>();
        for(int key:map.keySet()){
            int value = map.get(key);
            if(value>n/3)
                res.add(key);
        }
        return res;
    }
}
