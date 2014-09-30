/**
 * Created by shily on 2014/9/17.
 */
public class AStrInBStr {
    public static void main(String[] args){
        String str1 = "ABCDEFGHLMNOPQRS";
        String str2 = "DCGSDRQPOMT";
        String str3 = "ABCE";
        String str4 = "BC";
        System.out.print(isAInB(str2,str1));
    }

    private static boolean isAInB(String a,String b){
        char[] arrA = a.toCharArray();
        char[] arrB = b.toCharArray();
        boolean[] hash = new boolean[26];
        for(int i =0;i<26;i++){
            hash[i] = false;
        }
        int lenB = arrB.length;
        for(int i =0;i<lenB;i++){
            int index = arrB[i] - 'A';
            hash[index] = true;
        }
        int lenA = arrA.length;
        for(int i=0;i<arrA.length;i++){
            int index = arrA[i] - 'A';
            if(hash[index]){
                lenA--;
                if(lenA == 0){
                    return true;
                }
            }else{
                return false;
            }
        }

        return false;
    }
}
