package TwoPointers;

import java.util.Arrays;

public class TwoSumII {
    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        int[] res = binaryTwoSum(arr,9);
        System.out.println(Arrays.toString(res));
        int[] ans = twoPointerSum(arr,9);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] binaryTwoSum(int[] arr,int target){
        int n = arr.length;
        int s =0,e=n-1;
        while(s<e){
            int mid = s+(e-s)/2;
            int sum = arr[s] +arr[e];
            if(sum == target){
                return new int[]{s+1,e+1};
            }else if(sum > target){
                if(arr[e] + arr[mid] < target)
                    s = mid+1;
                else
                    e--;
            }else{
                if(arr[s] + arr[mid] > target)
                    e = mid-1;
                else
                    s++;
            }
        }
        return new int[2];
    }

    public static int[] twoPointerSum(int[] arr,int target){
        int s=0,e=arr.length-1;
        while(s<e){
            int sum = arr[s]+arr[e];
            if(sum == target)
                return new int[]{s+1,e+1};
            else if(sum >target)
                e--;
            else
                s++;
        }
        return new int[2];
    }
}
