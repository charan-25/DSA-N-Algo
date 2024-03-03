package Hashing;

import java.util.HashMap;

public class ContinuousSubarraySum {
    public static void main(String[] args) {
        int[] arr = {23,2,4,6,7};
        System.out.println(checkSubarraySum(arr,6));
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int sum =0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i=0;i<n;i++){
            sum += nums[i];
            if(k!=0)
                sum = sum%k;
            if(map.containsKey(sum)){
                int index = map.get(sum);
                if(i-index > 1)
                    return true;
            }else
                map.put(sum,i);
        }
        return false;
    }
}
