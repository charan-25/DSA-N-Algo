package Strings;

import java.util.HashMap;

public class IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println(isoMorphic("badc","baba"));
        System.out.println(isIsomorphic("13","42"));
    }

    public static boolean isoMorphic(String s,String t){
        int[] m1 = new int[256];
        int[] m2 = new int[256];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) return false;
            m1[s.charAt(i)] = i + 1;
            m2[t.charAt(i)] = i + 1;
        }
        return true;
    }

    public static boolean isIsomorphic(String s, String t) {
        int n =s.length(),m=t.length();
        if(n!=m)
            return false;
        HashMap<Character,Character> map = new HashMap<>();
        HashMap<Character,Boolean> mapped = new HashMap<>();

        for(int i=0;i<n;i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(map.containsKey(c1)){
                if(map.get(c1)!=c2)
                    return false;
            }else{
                if(mapped.containsKey(c2))
                    return false;
                mapped.put(c2,true);
                map.put(c1,c2);
            }
        }
        return true;
    }
}
