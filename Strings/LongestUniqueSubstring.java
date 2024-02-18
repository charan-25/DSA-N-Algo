package Strings;

import java.util.HashSet;

public class LongestUniqueSubstring {
    public static void main(String[] args) {
        System.out.println(longestUniqueSubstring("abcabcbb"));
    }

    public static int longestUniqueSubstring(String str){
        int n = str.length();
        HashSet<Character> set = new HashSet<>();
        int i=0,j=0,ans =0;
        while(j<n){
            if(!set.contains(str.charAt(j)))
                set.add(str.charAt(j));
            else{

                while(str.charAt(i)!=str.charAt(j)){
                    set.remove(str.charAt(i));
                    i++;
                }
                i++;
            }
            ans = Math.max(ans,set.size());
            j++;
        }
        return ans;
    }
}
