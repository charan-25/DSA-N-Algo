package Strings;

public class PalindromicSubstrings {
    public static void main(String[] args) {
        System.out.println(countPalindromicSubstrings("abaa"));
    }

    public static int countPalindromicSubstrings(String str){
        int n = str.length(),count = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<=n;j++){
                if(isPalindrome(str.substring(i,j))){
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean isPalindrome(String str){
        int start = 0,end=str.length()-1;
        while(start<end){
            if(str.charAt(start)!=str.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}
