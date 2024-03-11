package Strings;

public class RansomNote {

    public static void main(String[] args) {
        System.out.println(canConstruct("bg","efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj"));
    }

    public static boolean canConstruct(String ransomNote,String magazine){
        int[] count1 = new int[26];
        for(char ch:ransomNote.toCharArray()) count1[ch-'a']++;
        int[] count2 = new int[26];
        for(char ch:magazine.toCharArray()) count2[ch-'a']++;
        for(int i=0;i<25;i++){
            if(count2[i]>=count1[i]) continue;
            else return false;
        }
        return true;
    }
}

