/**
 * Created by shily on 2014/9/16.
 */
public class ReverseWords {
    public static void main(String[] arg){
        System.out.print(reverseWords("   a   b "));
    }

    public static String reverseWords(String s) {
        if(s == null){
            return null;
        }
        s = s.trim();
        if("".equals(s)){
            return "";
        }
        char[] arr = s.toCharArray();
        s = reverseStr(arr);
        String[] strings = s.split(" ");
        String result = "";
        for(String string:strings){
            String newStr = reverseStr(string.toCharArray());
            newStr = newStr.trim();
            if("".equals(newStr)){
                continue;
            }
            result += newStr + " ";
        }
        result = result.substring(0,result.length()-1);
        return result.trim();
    }
    private static String reverseStr(char[] arr){
        int low = 0;
        int high = arr.length - 1;
        while(low < high){
            swap(arr,low++,high--);
        }
        return new String(arr);
    }
    private static void swap(char[] arr,int i,int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
