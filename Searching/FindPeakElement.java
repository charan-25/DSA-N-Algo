package Searching;
/*A peak element is an element that is strictly greater than its neighbors.
Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.
You must write an algorithm that runs in O(log n) time.

Example 1:
Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.

Example 2:
Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.

Constraints:
1 <= nums.length <= 1000
-231 <= nums[i] <= 231 - 1
nums[i] != nums[i + 1] for all valid i.
*/
public class FindPeakElement {
    public static void main(String[] args) {
        int[] arr = {6,5,4,3,2,3,2};
        System.out.println(peakElement(arr));
        System.out.println(optimizedPeakElement(arr));
    }

    //TC:O(N) Approach
    public static int peakElement(int[] arr){
        int n = arr.length;
        if(n<3){
            if(n==1)
                return 0;
            else{
                if(arr[0]>arr[1])
                    return 0;
                else
                    return 1;
            }
        }
        for(int i=1;i<n-1;i++){
            if(arr[i-1]<arr[i] && arr[i+1]<arr[i])
                return i;
        }
        if(arr[0]>arr[1])
            return 0;
        else if(arr[n-1]>arr[n-2])
            return n-1;
        else
            return -1;
    }

    //Binary Search Approach
    public static int optimizedPeakElement(int[] nums){
        if(nums.length == 1) return 0; // single element

        int n = nums.length;

        // check if 0th/n-1th index is the peak element
        if(nums[0] > nums[1]) return 0;
        if(nums[n-1] > nums[n-2]) return n-1;

        // search in the remaining array
        int start = 1;
        int end = n-2;

        while(start <= end) {
            int mid = start + (end - start)/2;
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) return mid;
            else if(nums[mid] < nums[mid-1]) end = mid - 1;
            else if(nums[mid] < nums[mid+1]) start = mid + 1;
        }
        return -1; // dummy return statement
    }
}
