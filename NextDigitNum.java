/**
 * Created by shily on 2014/9/13.
 */
public class NextDigitNum {

    public static void main(String[] args) throws Exception{
        System.out.println(NextDigitNum.nextDigit(25431));
        System.out.println(NextDigitNum.nextDigit(1231241));
    }

    public static void swap(int[] a,int i,int j){
        a[i] = a[i]^a[j];
        a[j] = a[i]^a[j];
        a[i] = a[i]^a[j];
    }

    public static void reverse(int[] a,int i,int j) throws Exception{
        if(i>j){
            throw new Exception("j must greater than i!");
        }
        for(;i<j;i++,j--){
            swap(a,i,j);
        }
    }

    public static int nextDigit(int num) throws Exception{
        int j = -1,k = -1;
        String number = Integer.toString(num);
        int len = number.length();
        int[] numArr = new int[len];
        for(int i=len-1;i>=0;i--){
            numArr[i] = num%10 ;
            num = num/10;
        }
        //找到j的位置，j=max{i|Pi>Pi+1}
        for(int i = len-1;i>0;i--){
            if(numArr[i-1]<numArr[i]){
                j=i-1;
                break;
            }
        }
        if(j==-1){
            reverse(numArr,0,len-1);
            int result = 0;
            for (int i = 0; i < len; i++) {
                result = result * 10 + numArr[i];
            }
            return result;
        }
        for(int i = len-1;i>0;i--){//找到k
            if(numArr[j]<numArr[i]){
                k=i;
                break;
            }
        }
        swap(numArr,j,k);
        reverse(numArr,j+1,len-1);
        int result = 0;
        for (int i = 0; i < len; i++) {
            result = result * 10 + numArr[i];
        }
        return result;
    }
}
