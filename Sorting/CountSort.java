package Sorting;

import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        int[] arr = {4,2,2,8,3,3,0,1};
        System.out.println("Original Array :: ");
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println("Sorted Array :: ");
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr){
        int n = arr.length,min=arr[0],max=arr[0];
        for(int  i=0;i<n;i++){
            min = Math.min(min,arr[i]);
            max = Math.max(max,arr[i]);
        }

        int range = max- min + 1;
        int[] count = new int[range];
        for(int i=0;i<n;i++){
            count[arr[i]-min]++;
        }
        int index =0;
        for(int i=0;i<range;i++){
            while(count[i]>0){
                arr[index++] = i + min;
                count[i]--;
            }
        }
    }
}
