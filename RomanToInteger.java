import java.util.HashMap;

public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(romanToInt("LVIII"));
    }

    public static int romanToInt(String str){
       // int[] numbers = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        //String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        HashMap<String,Integer> map = new HashMap<>();
        map.put("M",1000);
        map.put("D",500);
        map.put("C",100);
        map.put("L",50);
        map.put("X",10);
        map.put("V",5);
        map.put("I",1);
        int num =0,n= str.length();
        int prev = 0,res=0;
        for(int i=n-1;i>=0;i--){
            int curr = map.get(""+str.charAt(i));
            if(curr < prev){
                res -= curr;
            }else{
                res += curr;
            }
            prev = curr;
        }
        return res;
    }
}
