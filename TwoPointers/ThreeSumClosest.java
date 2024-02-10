package TwoPointers;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] arr = {4,0,5,-5,3,3,0,-4,-5};
        int target = -2;
        System.out.println(closestThreeSum(arr,target));
    }

    public static int closestThreeSum(int[] arr,int target){
        int n = arr.length;
        Arrays.sort(arr);
        int minDiff = Math.abs(arr[0]+arr[1]+arr[2]-target);
        int bestTillNow = arr[0]+arr[1]+arr[2];
        for(int i=0;i<n;i++){
            int j =i+1,k=n-1,diff=target-arr[i];
            while(j<k){
                int sum = arr[j] + arr[k];
                int newDiff = Math.abs(sum-diff);
                if(newDiff < minDiff){
                    minDiff = newDiff;
                    bestTillNow = arr[i] + arr[j] + arr[k];
                    j++;k--;
                }

                if(sum < diff)
                    j++;
                else
                    k--;
            }
        }
        return bestTillNow;
    }
}
