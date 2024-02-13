/*Problem Description
        Given an array of integers, A denoting a stream of integers. New arrays of integer B and C are formed.
        Each time an integer is encountered in a stream, append it at the end of B and append the median of array B at the C.

        Find and return the array C.

        NOTE:

        If the number of elements is N in B and N is odd, then consider the median as B[N/2] ( B must be in sorted order).
        If the number of elements is N in B and N is even, then consider the median as B[N/2-1]. ( B must be in sorted order).


        Problem Constraints
        1 <= length of the array <= 100000
        1 <= A[i] <= 109



        Input Format
        The only argument given is the integer array A.



        Output Format
        Return an integer array C, C[i] denotes the median of the first i elements.



        Example Input
        Input 1:

        A = [1, 2, 5, 4, 3]
        Input 2:

        A = [5, 17, 100, 11]


        Example Output
        Output 1:

        [1, 1, 2, 2, 3]
        Output 2:

        [5, 5, 17, 11]


        Example Explanation
        Explanation 1:

        stream          median
        [1]             1
        [1, 2]          1
        [1, 2, 5]       2
        [1, 2, 5, 4]    2
        [1, 2, 5, 4, 3] 3
        Explanation 2:

        stream          median
        [5]              5
        [5, 17]          5
        [5, 17, 100]     17
        [5, 17, 100, 11] 11
*/
import java.util.*;
public class RunningMedian {
    public static void main(String[] args) {
        int[] arr = {59,64,10,39};
        System.out.println(Arrays.toString(runningMedian(arr)));
        System.out.println(Arrays.toString(bruteRunningMedian(arr)));
    }

    //Optimized Approach
    public static int[] runningMedian(int[] arr){
        int n = arr.length;
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            if(left.size() == right.size()){
                right.add(arr[i]);
                left.add(right.remove());
                res[i] = left.peek();
            }else{
                left.add(arr[i]);
                right.add(left.remove());
                res[i] = (left.peek()+right.peek())/2;
            }
        }
        return res;
    }

    //BruteForce Approach
    public static int[] bruteRunningMedian(int[] arr){
        int n = arr.length;
        int[] res = new int[n];
        int k=0;
        for(int i=0;i<n;i++){
            int[] ans = new int[i+1];
            int index = 0;
            for(int j=0;j<=i;j++){
                ans[index] = arr[j];
                index++;
            }
            Arrays.sort(ans);
            if(ans.length%2==0){
                int len = ans.length/2;
                res[k] = (ans[len-1]+ans[len])/2;
            }
            else
                res[k] =ans[ans.length/2];
            k++;
        }
        return res;
    }
}
