package Array;
/*Given an array of integers nums, calculate the pivot index of this array.
The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.
If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.
Return the leftmost pivot index. If no such index exists, return -1.

Example 1:
Input: nums = [1,7,3,6,5,6]
Output: 3
Explanation:
The pivot index is 3.
Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
Right sum = nums[4] + nums[5] = 5 + 6 = 11

Example 2:
Input: nums = [1,2,3]
Output: -1
Explanation:
There is no index that satisfies the conditions in the problem statement.

Example 3:
Input: nums = [2,1,-1]
Output: 0
Explanation:
The pivot index is 0.
Left sum = 0 (no elements to the left of index 0)
Right sum = nums[1] + nums[2] = 1 + -1 = 0

Constraints:
1 <= nums.length <= 104
-1000 <= nums[i] <= 1000
*/
public class PivotIndex {
    public static void main(String[] args) {
        int[] arr = {1,7,3,6,5,6};
        System.out.println(pivotIndex(arr));
    }

    public static int pivotIndex(int[] arr){
        int n = arr.length;
        int[] pf = new int[n];
        pf[0] = arr[0];
        for(int i=1;i<n;i++) pf[i] = pf[i-1]+arr[i];
        int[] sf = new int[n];
        sf[n-1] = arr[n-1];
        for(int i=n-2;i>=0;i--) sf[i] = sf[i+1]+arr[i];

        for(int i=0;i<n;i++){
            if(sf[i]==pf[i])
                return i;
        }
        return -1;
    }
}
