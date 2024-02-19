package Heaps;

import java.util.HashMap;
import java.util.PriorityQueue;

public class LeastUniqueIntegers {
    public static void main(String[] args) {
        int[] arr = {4,3,1,1,3,3,2};
        int k =3;
        System.out.println(leastUniqueIntegers(arr,k));
    }

    public static int leastUniqueIntegers(int[] arr,int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:arr) map.put(num,map.getOrDefault(num,0)+1);
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
