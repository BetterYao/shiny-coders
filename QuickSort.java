/**
 * Created by shily on 2014/9/14.
 */
public class QuickSort {
    public static void main(String[] args){
        int[] arr = {4,6,0,1,4,5,3,9,-2};
        qSort(arr,0,arr.length-1);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
    private static void qSort(int[] arr,int i,int j){
        if(i < j && arr!=null){
            int start = i;
            int end = j;
            int temp = arr[i];
            while(i<j) {
                while (i < j && arr[j] > temp) {
                    j--;
                }
                if (i < j) {
                    arr[i] = arr[j];
                    i++;
                }
                while (i < j && arr[i] < temp) {
                    i++;
                }
                if (i < j) {
                    arr[j] = arr[i];
                    j--;
                }
                arr[i] = temp;
            }
            qSort(arr,start,i-1);
            qSort(arr,i+1,end);
        }
    }
}
