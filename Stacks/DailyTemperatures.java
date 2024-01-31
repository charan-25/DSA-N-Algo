package Stacks;
/*Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.



Example 1:

Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
Example 2:

Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
Example 3:

Input: temperatures = [30,60,90]
Output: [1,1,0]


Constraints:

1 <= temperatures.length <= 105
30 <= temperatures[i] <= 100
*/
import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    public static void main(String[] args) {
        int[] arr = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemp(arr)));
    }

    public static int[] dailyTemp(int[] arr){
        int n = arr.length;
        Stack<Integer> stack =new Stack<>();
        int[] ans = new int[n];
        stack.push(n-1);
        for(int i=n-2;i>=0;i--){
            while(stack.size()>0 && arr[i] >= arr[stack.peek()]){
                stack.pop();
            }

            if(stack.size()>0)
                ans[i] = stack.peek() - i;
            stack.push(i);
        }
        return ans;
    }
}
