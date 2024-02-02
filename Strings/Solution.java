package Strings;

public class Solution {
    public static void main(String[] args) {
        System.out.println(bruteLPS("abracarabra"));
    }

    //Optimized Approach
    public static String longestPalindromicSubString(String str){
        int n = str.length(),start=0,end=0;
        for(int i=0;i<n;i++){
            int even = palindromLength(str,i,i+1);
            int odd  = palindromLength(str,i-1,i+1);
            int len  = Math.max(odd,even);
            if(len > end-start+1){
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=start;i<=end;i++){
            sb.append(str.charAt(i));
        }
        return new String(sb);
    }

    public static int palindromLength(String str,int i,int j){
        int n = str.length();
        while(i>=0 && j<n && str.charAt(i)==str.charAt(j)){
            i--;j++;
        }
        return j-i-1;
    }

    //Brute Force
    public static String bruteLPS(String str){
        int n = str.length();
        String res = "";
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                StringBuilder sb = new StringBuilder();
                for(int k=i;k<=j;k++){
                    sb.append(str.charAt(k));
                }
                String s = new String(sb);
                if(isPalindrome(s) && res.length()<s.length())
                    res = s;
            }
        }
        return res;
    }

    public static boolean isPalindrome(String str){
        int i=0,j=str.length()-1;
        while(i<j){
            if(str.charAt(i)!=str.charAt(j))
                return false;
            i++;j--;
        }
        return true;
    }
}
