package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumArrowsRequired {
    public static void main(String[] args) {
        int[][] arr = {{-2147483646,-2147483645},{2147483646,2147483647}};
        System.out.println(findMinArrowShots(arr));
    }

    public static int findMinArrowShots(int[][] points) {
        int n = points.length;
        if(n==0) return 0;
        Arrays.sort(points,(a,b)->Integer.compare(a[0],b[0]));
        int count = 1;
        int end = points[0][1];
        for(int i=1;i<n;i++){
            if(points[i][0]>end){
                count++;
                end = points[i][1];
            }else
                end = Math.min(end,points[i][1]);
        }
        return count;
    }


}


