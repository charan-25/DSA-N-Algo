package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

Example 2:
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

Constraints:
1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104*/
public class MergeInterval {

    public static void main(String[] args) {
        int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
        int[][] res = mergeIntervals(arr);
        for(int i=0;i<res.length;i++){
            System.out.println(res[i][0]+" "+res[i][1]);
        }
    }

    public static int[][] mergeIntervals(int[][] arr){
        List<int[]> res = new ArrayList<>();
        int n = arr.length;
        Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0]));
        int[] currentInterval = arr[0];
        for(int i=1;i<n;i++){
            int[] nextInterval = arr[i];
            if(currentInterval[1]>=nextInterval[0])
                currentInterval[1] = Math.max(currentInterval[1],nextInterval[1]);
            else{
                res.add(currentInterval);
                currentInterval = nextInterval;
            }
        }
        res.add(currentInterval);
        return res.toArray(new int[res.size()][]);
    }
}
