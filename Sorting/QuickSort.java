package Sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {3,6,14,11,8,20,27,31,23,18};
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr,int start,int end){
        if(start>end)
            return;
        int pi = partitionArray(arr,start,end);
        sort(arr,start,pi-1);
        sort(arr,pi+1,end);
    }

    public static int partitionArray(int[] arr,int start,int end){
        int i=start,j=start,pivot=arr[end];
        while(j<end){
            if(arr[j]>=pivot)
                j++;
            else{
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;j++;
            }
        }
        int temp = arr[i];
        arr[i] = arr[end];
        arr[end] = temp;
        return i;
    }
}
