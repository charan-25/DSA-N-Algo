/*An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.

Example 1:
Input: low = 100, high = 300
Output: [123,234]

Example 2:
Input: low = 1000, high = 13000
Output: [1234,2345,3456,4567,5678,6789,12345]

Constraints:
10 <= low <= high <= 10^9*/
import java.util.*;
public class SequentialDigits {
    public static void main(String[] args) {
       // System.out.println(sequentialDigits(10,13000));
       // System.out.println(optimizedSequentialDigit(10,13000));
        System.out.println(slidingWindowSequentialDigits(10,13000));
    }
    //Brute Force Approach
    public static List<Integer> sequentialDigits(int low,int high){
        List<Integer> list = new ArrayList<>();
        for(int i=low;i<=high;i++){
            if(isSequential(i))
                list.add(i);
        }
        return list;
    }

    public static boolean isSequential(int num){
        List<Integer> list = new ArrayList<>();
        boolean bol = true;
        while(num>0){
            list.add(num%10);
            num = num/10;
        }
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i) - list.get(i+1) !=1)
                return bol=false;
        }
        return bol;
    }

    //Optimized Approach
    public static List<Integer> optimizedSequentialDigit(int low,int high){
        int[] arr = {12,23,34,45,56,67,78,89,123,234,345,456,567,678,789,1234,
                     2345,3456,4567,5678,6789,12345,23456,34567,45678,56789,
                     123456,234567,345678,456789,1234567,2345678,3456789,12345678,
                     23456789,123456789};
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(low<=arr[i] && arr[i]<=high)
                list.add(arr[i]);
        }
        return list;
    }

    //Sliding Window Approach
    public static List<Integer> slidingWindowSequentialDigits(int low,int high){
        Set<Integer> set = new HashSet<>();
        for(int i= String.valueOf(low).length();i<=String.valueOf(high).length();i++){
            set.addAll(slidingCount(i,low,high));
        }
        List<Integer> res = new ArrayList<>(set);
        Collections.sort(res);
        return res;
    }

    public static List<Integer> slidingCount(int num,int min,int max){
        List<Integer> list = new ArrayList<>();
        String str = "123456789";
        int i=0,j=num;
        while(j<=9){
            int count = Integer.parseInt(str.substring(i,i+num));
            if(min<=count && count<=max)
                list.add(count);
            i++;
            j++;
        }
        return list;
    }
}
