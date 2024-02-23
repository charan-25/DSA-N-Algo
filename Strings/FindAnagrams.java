package Strings;

import java.util.*;

public class FindAnagrams {
    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd","abc"));
    }

    public static List<Integer> findAnagrams(String s, String p){
       List<Integer> list = new ArrayList<>();
       int[] arr1 = new int[26];
       int m=p.length();
       for(char ch :p.toCharArray()){
           arr1[ch-'a']++;
       }
       int[] arr2 = new int[26];
       for(int i=0;i<m;i++){
           arr2[s.charAt(i)-'a']++;
       }

       updateAns(list,arr1,arr2,0);
       int st =1,e=m;
       while(e<s.length()){
           arr2[s.charAt(st-1)-'a']--;
           arr2[s.charAt(e)-'a']++;
           updateAns(list,arr1,arr2,st);
           st++;
           e++;
       }
       return list;
    }

    public static void updateAns(List<Integer> list,int[] arr1,int[] arr2,int index){
        if(Arrays.equals(arr1,arr2))
            list.add(index);
    }
}
