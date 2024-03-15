package Array;

import java.util.Arrays;

/*Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]

Constraints:
2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)*/
public class ProductOfArray {
    public static void main(String[] args) {
        int[] arr = {-1,1,0,-3,3};
        int[] res = productExpect(arr);
        System.out.println(Arrays.toString(res));
    }

    public static int[] productExpect(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];

        //Prefix Array
        int[] pf = new int[n];
        pf[0] = arr[0];
        for(int i=1;i<n;i++) pf[i] = pf[i-1] * arr[i];

        //Suffix Array
        int[] sf = new int[n];
        sf[n-1] = arr[n-1];
        for(int i=n-2;i>=0;i--) sf[i] = sf[i+1] * arr[i];

        ans[0] = sf[1];
        ans[n-1] = pf[n-2];
        for(int i=1;i<n-1;i++) ans[i] = pf[i-1] * sf[i+1];

        return ans;
    }
}
