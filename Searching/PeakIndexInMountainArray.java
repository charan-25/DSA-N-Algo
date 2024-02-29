package Searching;
/*An array arr is a mountain if the following properties hold:
arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given a mountain array arr, return the index i such that arr[0] < arr[1] < ... < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].
You must solve it in O(log(arr.length)) time complexity.

Example 1:
Input: arr = [0,1,0]
Output: 1

Example 2:
Input: arr = [0,2,1,0]
Output: 1

Example 3:
Input: arr = [0,10,5,2]
Output: 1

Constraints:
3 <= arr.length <= 105
0 <= arr[i] <= 106
arr is guaranteed to be a mountain array.*/
public class PeakIndexInMountainArray {
    public static void main(String[] args) {
        int[] arr = {0,10,5,2};
        System.out.println(peakIndex(arr));
    }

    public static int peakIndex(int[] arr){
        int n = arr.length;
        int low = 0,high = arr.length-1;
        if(n<3) {
            if (n == 1)
                return 0;
            else {
                if (n == 2) {
                    if (arr[0] > arr[1])
                        return 0;
                    else
                        return 1;
                }
            }
        }else{
            while(low<=high){
                int mid = low + (high - low)/2;
                if(arr[mid-1]<arr[mid] && arr[mid+1]<arr[mid])
                    return mid;
                else if(arr[mid-1]<arr[mid] && arr[mid]<arr[mid+1])
                    low = mid + 1;
                else
                    high = mid -1;
            }
        }
        return -1;
    }
}
