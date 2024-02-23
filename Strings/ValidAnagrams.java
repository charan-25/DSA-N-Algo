package Strings;

public class ValidAnagrams {
    public static void main(String[] args) {
        System.out.println(validAnagrams("anagram","nagaram"));
    }

    public static boolean validAnagrams(String str,String str1){
        int[] count = new int[26];
        for(char ch:str.toCharArray())
            count[ch-'a']++;
        for(char ch:str1.toCharArray())
            count[ch-'a']--;

        for(int i=0;i<count.length;i++){
            if(count[i]>0)
                return false;
        }
        return true;
    }
}
