/**
 * Created by shily on 2014/9/21.
 */
public class SearchforaRange {
    public static void main(String[] args){
        int[] a = {8,8,8,8,8,8,8};
        int[] b = searchRange(a,8);
        System.out.print(b[0]+" "+b[1]);
    }
    public static int[] searchRange(int[] A, int target) {
        int index = binarySearch(A,0,A.length-1,target);
        int[] targetIndexs = {-1,-1};
        if(index!=-1){
            int left  = index;
            int right = index;
            targetIndexs[0] = left;
            targetIndexs[1] = right;
            while ((left = binarySearch(A,0,left-1,target))!=-1) targetIndexs[0] = left;
            while ((right = binarySearch(A,right+1,A.length-1,target))!=-1) targetIndexs[1] = right;
        }
        return targetIndexs;
    }

    private static int binarySearch(int[] A,int low,int high,int target){
        while(low<=high){
            int mid = low + (high-low)/2;
            if      (A[mid]>target) high = mid - 1;
            else if (A[mid]<target) low  = mid + 1;
            else    return mid;
        }
        return -1;
    }
}
