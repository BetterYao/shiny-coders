/**
 * Created by shily on 2014/9/18.
 */
public class BinarySearch {

    public static void main(String[] args){
        int[] a = new int[]{1,2,3,4,5,6,6,7};
        System.out.print(binarySearch(a,8));
    }

    private static int binarySearch(int[] a,int n){
        int i = 0;
        int j = a.length-1;
        while (i<=j){
           int mid = i+(j-i)/2;//位置是从left算起的
           if(a[mid]>n){
               j=mid-1;
           }else if(a[mid]<n){
               i=mid+1;
           }else{
               return mid;
           }
        }
        return -1;
    }
}
