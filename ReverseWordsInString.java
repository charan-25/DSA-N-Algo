public class ReverseWordsInString {
    public static void main(String[] args) {
        System.out.println(reverseWords("a good   example"));
        System.out.println(OptimizedreverseWords("a good   example"));
    }

    //Using Regular Expression and simple code
    public static String reverseWords(String s) {
        String[] str = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i=str.length-1;i>0;i--){
            sb.append(str[i]+" ");
        }
        sb.append(str[0]);
        return new String(sb);
    }

    //optimized Approach
    public static String OptimizedreverseWords(String s){
        s = s.trim();
        int n = s.length();
        char[] arr = s.toCharArray();
        reverseArray(arr,0,n-1);
        int i=0,j=0;
        while(j<n){
            if(arr[j]==' '){
                reverseArray(arr,i,j-1);
                i = j+1;
            }
            j++;
        }
        reverseArray(arr,i,j-1);
        System.out.println(new String(arr));
        StringBuilder  sb = new StringBuilder();
        j=0;
        while(j<n){
            if(arr[j]!=' '){
                sb.append(arr[j]);
                j++;
            }
            else if(arr[j] == ' '){
                while(arr[j]==' '){
                    j++;
                }
                sb.append(' ');
            }
        }
        return new String(sb);
    }

    public static void reverseArray(char[] arr,int s,int e){
        while(s<e){
            char temp = arr[s];
            arr[s] =arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }
}
