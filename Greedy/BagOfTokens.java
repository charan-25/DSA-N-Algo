package Greedy;

import java.util.Arrays;

public class BagOfTokens {
    public static void main(String[] args) {
        int[] arr = {200,100};
        System.out.println(countScore(arr,150));
    }

    public static int countScore(int[] tokens,int power){
        int n = tokens.length,score=0;
        Arrays.sort(tokens);
        int start =0,end=n-1;
        int maxScore =0;
        while(start<=end){
            if(power>=tokens[start]){
                power -= tokens[start];
                start++;
                score++;
                maxScore = Math.max(maxScore,score);
            }else if(score>=1 && tokens[end]>power){
                power += tokens[end];
                end--;
                score--;
                maxScore = Math.max(score,maxScore);
            }else{
                start++;
            }
        }
        return maxScore;
    }
}
