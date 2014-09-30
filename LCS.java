/**
 * Created by shily on 2014/9/15.
 */
public class LCS {

    public static void main(String[] args){
        String a = "sdgqhsadkas;gkwqg";
        String b = "!!!!!!kas;k!!!!";
        System.out.print(longestStr(a,b));
    }

    public static int longestStr(String a,String b){
        if(a==null||b==null||"".equals(a)||"".equals(b)){
            return 0;
        }
        int lenA = a.length();
        int lenB = b.length();
        int[] c = new int[lenB+1];
        int max = 0;
        for (int i = 0;i<lenA;i++){
            for(int j=lenB;j>0;j--){
                if(a.charAt(i)==b.charAt(j-1)){
                    c[j] = c[j-1]+1;
                    if(c[j]>max){
                        max = c[j];
                    }
                }else{
                    c[j]= 0;
                }
            }
        }
        return max;
    }
}
