package Sorting;

import java.util.Arrays;

public class Sort01Array {

    public static void main(String[] args) {
        int[] arr ={1,1,0,1,0,0,1,0,0};
        sort(arr);
    }

    public static void sort(int[] arr){
        int n = arr.length,i=0,j=1;
        while(j<n){
            if(arr[j]==0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;j++;
            }else{
                j++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
