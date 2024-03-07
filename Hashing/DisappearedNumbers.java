package Hashing;

import java.util.Arrays;
import java.util.HashSet;

public class DisappearedNumbers {
    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        int[] res = findDisappearedNumbers(arr);
        System.out.println(Arrays.toString(res));
    }

    public static int[] findDisappearedNumbers(int[] arr){
        int n = arr.length;
        HashSet<Integer> set = new HashSet<>();
        for(int num:arr) set.add(num);
        int[] res = new int[n-set.size()];
        int index = 0;
    //    System.out.println(res.length);
        for(int i=1;i<=n;i++){
            if(!set.contains(i)) {
                res[index] = i;
                index++;
            }

        }
        return res;
    }
}
