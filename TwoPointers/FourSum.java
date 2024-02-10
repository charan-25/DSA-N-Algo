package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashSet;
public class FourSum {
    public static void main(String[] args) {
        int[] arr = {1000000000,1000000000,1000000000,1000000000};
        System.out.println(fourSum(arr,-294967296));
    }

    public static List<List<Integer>> fourSum(int[] arr, long target) {
        int n = arr.length;
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int p=j+1,q=n-1;long diff = target - arr[i] - arr[j];
                while(p<q){
                    long sum = arr[p] +arr[q];
                    if(sum == diff){
                        List<Integer> list = new ArrayList<>();
                        list.add(arr[i]);
                        list.add(arr[j]);
                        list.add(arr[p]);
                        list.add(arr[q]);
                        if(set.add(list))
                            res.add(list);
                        p++;q--;
                    }
                    else if(sum < diff)
                        p++;
                    else
                        q--;
                }
            }
        }
        return res;
    }
}
