package Array;
/*Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.



Example 1:

Input: nums = [10,5,2,6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are:
[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
Example 2:

Input: nums = [1,2,3], k = 0
Output: 0


Constraints:

1 <= nums.length <= 3 * 104
1 <= nums[i] <= 1000
0 <= k <= 106
*/
public class SubarrayProduct {
    public static void main(String[] args) {
        int[] arr = {10,5,2,6};
        System.out.println(bruteProductLessThanK(arr,100));
    }

    //Optimized Approach
    public static int productLessThanK(int[] arr,int k){
        int n = arr.length;
        int count =0,prod=1;
        for(int l=0,r=0;r<n;r++){
            prod *= arr[r];
            while(prod >= k)
                prod /= arr[l++];
            count += r-l+1;
        }
        return count;
    }

    //Brute Force Approach
    public static int bruteProductLessThanK(int[] arr,int k){
        int n = arr.length;
        int ans = 0;
        for(int i=0;i<n;i++){
            int prod = 1;
            for(int j=i;j<n;j++) {
                prod *= arr[j];
                if (prod >= k)
                    break;
                ans++;
            }
        }
        return ans;
    }
}
