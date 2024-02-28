package Queues;

import java.util.ArrayDeque;
import java.util.Arrays;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] arr = {9,10,9,-7,-4,-8,2,6};
        windowMax(arr,5);
    }

    public static int[] windowMax(int[] arr,int k){
        int n = arr.length;
        if(n==1)
            return new int[]{arr[0]};
        int[] res = new int[n-k+1];
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for(int i=0;i<k;i++){
            while(dq.size()>0 && dq.getLast()<arr[i]) dq.removeLast();
            dq.add(arr[i]);
        }
        int i=k,j=0;
        while(i<n){
            res[j] = dq.peek();
            while(dq.size()>0 && dq.getLast() < arr[i])dq.removeLast();
            dq.add(arr[i]);
            if(dq.getFirst()==arr[j])
                dq.remove();
            i++;
            j++;
        }
        res[j] = dq.peek();
        System.out.println(Arrays.toString(res));
        return res;
    }
}
