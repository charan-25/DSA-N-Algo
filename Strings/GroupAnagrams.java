package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] str = {"rat", "tar", "art"};
        List<List<String>> res = groupAnagarams(str);
        res.forEach(System.out::println);
    }

    public static List<List<String>> groupAnagarams(String[] strs){
        Map<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] count = new char[26];
            for(int i=0;i<str.length();i++) count[str.charAt(i)-'a']++;
            String s = new String(count);
            System.out.println(s);
            if(map.containsKey(s))
                map.get(s).add(str);
            else{
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(s,list);
            }
        }
        return new ArrayList<>(map.values());
    }

    /*
    Another Optimized Approach
    int n = strs.length;
        Map<String,List<String>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            String str = strs[i];
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            str = new String(ch);
            if(map.containsKey(str)){
                List<String> list = map.get(str);
                list.add(strs[i]);
                map.put(str,list);
            }else{
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(str,list);
            }
        }
        return new ArrayList<>(map.values());*/
}
