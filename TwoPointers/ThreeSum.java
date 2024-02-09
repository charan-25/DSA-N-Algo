package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.



Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.


Constraints:

3 <= nums.length <= 3000
-105 <= nums[i] <= 105*/
public class ThreeSum {

    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        System.out.println(zeroThreeSum(arr));
    }

    public static List<List<Integer>> zeroThreeSum(int[] arr){
        int n = arr.length;
        List<List<Integer>> res = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));
        for(int i=0;i<n;i++){
            int j = i+1,k=n-1;
            while(j<k){
                int target = - arr[i];
                int sum = arr[j] + arr[k];
                if(sum == target){
                    List<Integer> list = new ArrayList<>();
                    list.add(arr[j]);
                    list.add(arr[k]);
                    list.add(arr[i]);
                    if(set.add(list))
                        res.add(list);
                    j++;k--;
                }else if(sum<target)
                    j++;
                else
                    k--;
            }
        }
        return res;
    }
}
