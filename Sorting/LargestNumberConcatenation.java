package Sorting;

import java.util.Arrays;

public class LargestNumberConcatenation {

    public static void main(String[] args) {
        int[] arr = {3,30};
        System.out.println(largestNumber(arr));
    }

    public static String largestNumber(int[] arr){
        int n = arr.length;
        String[] str = new String[n];
        for(int i=0;i<n;i++){
            str[i] = ""+arr[i];
        }

        Arrays.sort(str,(a,b)->{
           String val1 = a + b;
           String val2 = b + a;
           Long num1 = Long.parseLong(val1);
           Long num2 = Long.parseLong(val2);
           if(num1<num2)
               return 1;
           else if(num1>num2)
               return -1;
           else
               return 0;
        });

        StringBuilder sb = new StringBuilder();
        for(String s : str){
            sb.append(s);
        }
        return new String(sb);
    }
}
