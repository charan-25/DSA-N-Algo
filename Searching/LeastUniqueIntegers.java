package Searching;

import java.util.HashMap;
import java.util.PriorityQueue;

/*Given an array of integers arr and an integer k. Find the least number of unique integers after removing exactly k elements.
Example 1:

Input: arr = [5,5,4], k = 1
Output: 1
Explanation: Remove the single 4, only 5 is left.
Example 2:
Input: arr = [4,3,1,1,3,3,2], k = 3
Output: 2
Explanation: Remove 4, 2 and either one of the two 1s or three 3s. 1 and 3 will be left.


Constraints:

1 <= arr.length <= 10^5
1 <= arr[i] <= 10^9
0 <= k <= arr.length
*/
public class LeastUniqueIntegers {
    public static void main(String[] args) {
        int[] arr = {4,3,1,1,3,3,2};
        int k =3;
        System.out.println(findLeastNumOfUniqueInts(arr,k));
    }

    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        int n = arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++)
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        PriorityQueue<Integer> pq = new PriorityQueue<>(map.values());
        int element = 0;
        while(pq.size()>0){
            element += pq.peek();
            if(element>k)
                return pq.size();
            pq.remove();
        }
        return 0;
    }
}
