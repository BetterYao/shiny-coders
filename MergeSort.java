/**
 * Created by shily on 2014/9/14.
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {4,6,0,1,4,2,3,9,-2};
        mergeSort(arr,0,arr.length-1);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }

    public static void merge(int[] arr,int start1,int end1,int start2,int end2){
        int i = start1;
        int j = start2;
        int k = 0;
        int[] temp = new int[end2-start1+1];
        while (i<=end1&&j<=end2){
            if(arr[i]<arr[j]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
            }
        }
        while (i<=end1){
            temp[k++] = arr[i++];
        }
        while (j<=end2){
            temp[k++] = arr[j++];
        }
        k = start1;
        for(int elem:temp){
            arr[k++] = elem;
        }
    }
    public static void mergeSort(int[] arr,int start,int end){
        if(start < end){
            int mid = (start+end)/2;
            mergeSort(arr,start,mid);
            mergeSort(arr,mid+1,end);
            merge(arr,start,mid,mid+1,end);
        }
    }
}
