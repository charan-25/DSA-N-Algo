package Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DuplicateElements {
    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(arr));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        HashSet<Integer> set  = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int num :nums){
            if(set.contains(num))
                list.add(num);
            else
                set.add(num);
        }
        return list;
    }
}
