package Stacks;

import java.util.Stack;

/*Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
return the area of the largest rectangle in the histogram.

Example 1:
Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.

Example 2:
Input: heights = [2,4]
Output: 4

Constraints:
1 <= heights.length <= 105
0 <= heights[i] <= 104
*/
public class LargestHistogramArea {
    public static void main(String[] args) {
        int[] arr  = {2,1,5,6,2,3};
        System.out.println(maxArea(arr));
    }

    public static int maxArea(int[] arr){
        int ans =0,n=arr.length;
        int[] lsi = nearestSmallerLeft(arr);
        int[] rsi = nearestSmallerRight(arr);
        for(int i=0;i<n;i++){
            int ht = arr[i];
            int wt = rsi[i]-lsi[i]-1;
            int area = ht*wt;
            ans = Math.max(area,ans);
        }
        return ans;
    }

    public static int[] nearestSmallerLeft(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] res = new int[n];
        res[0] = -1;
        stack.push(0);
        for(int i=1;i<n;i++){
            while(stack.size()>0 && arr[i]<arr[stack.peek()])stack.pop();
            if(stack.size()>0) res[i] = stack.peek();
            else res[i] = -1;
            stack.push(i);
        }
        return res;
    }

    public static int[] nearestSmallerRight(int[] arr){
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        res[n-1] = n;
        stack.push(n-1);
        for(int i=n-2;i>=0;i--){
            while(stack.size()>0 && arr[i]<arr[stack.peek()]) stack.pop();
            if(stack.size()>0) res[i] = stack.peek();
            else res[i] = n;
            stack.push(i);
        }
        return res;
    }
}
