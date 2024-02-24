package Strings;

import java.util.Arrays;

public class PermutationsInString {
    public static void main(String[] args) {
        System.out.println(permutations("ab","eidboaooo"));
    }

    public static boolean permutations(String s1,String s2){
        int[] arr1 = new int[26];
        int n = s1.length(),m=s2.length();
        if(n>m)
            return false;
        for(char ch:s1.toCharArray())
            arr1[ch-'a']++;
        int[] arr2 = new int[26];
        for(int i=0;i<n;i++){
            arr2[s2.charAt(i)-'a']++;
        }
        if(Arrays.equals(arr1,arr2))
            return true;
        int s=1,e=n;
        while(e<m){
            arr2[s2.charAt(s-1)-'a']--;
            arr2[s2.charAt(e)-'a']++;
            if(Arrays.equals(arr1,arr2))
                return true;
            s++;
            e++;
        }
        return false;
    }
}
