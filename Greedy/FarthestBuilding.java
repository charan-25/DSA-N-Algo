package Greedy;

import java.util.PriorityQueue;

public class FarthestBuilding {
    public static void main(String[] args) {
        int[] heights = {1,5,1,2,3,4,10000};
        int bricks = 4,ladders =1;
        System.out.println(furthestBuilding(heights,bricks,ladders));
    }

    public static int furthestBuilding(int[] heights,int bricks,int ladders){
        int n = heights.length;
        PriorityQueue<Integer> laddersUsed= new PriorityQueue<>();
        for(int i=0;i<n-1;i++){
            int diff = heights[i+1] - heights[i];
            if(diff>0){
                if(ladders>0){
                    laddersUsed.add(diff);
                    ladders--;
                }else if(!laddersUsed.isEmpty() && diff >laddersUsed.peek()){
                    bricks -=  laddersUsed.remove();
                    laddersUsed.add(diff);
                }else
                    bricks--;
                if(bricks< 0) return i;
            }
        }
        return n-1;
    }
}
