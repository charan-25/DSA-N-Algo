package Heaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class KFrequencyElements {
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};
        int k =2;
        int[] res = topKFrequencyElements(arr,k);
        System.out.println(Arrays.toString(res));
    }

    public static int[] topKFrequencyElements(int[] arr,int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num:arr) map.put(num,map.getOrDefault(num,0)+1);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> map.get(b)-map.get(a));
        for(int key : map.keySet()) pq.add(key);
        int[] res = new int[k];
        for(int i=0;i<k;i++)res[i] = pq.remove();
        return res;
    }
}
