import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by shily on 2014/9/14.
 */
public class Pyramid{

    public static void main(String[] args){
        Arhat arhat1 = new Arhat(1,2);
        Arhat arhat2 = new Arhat(3,4);
        Arhat arhat3 = new Arhat(3,2);
        Arhat arhat4 = new Arhat(2,8);
        Arhat arhat5 = new Arhat(5,1);
        Arhat arhat6 = new Arhat(100,100);
        Arhat[] arhats = new Arhat[]{arhat1,arhat2,arhat3,arhat4,arhat5,arhat6};

        System.out.print(getMaxPyramid(arhats));
    }

    public static int getMaxPyramid(Arhat[] arhats){
        int len = arhats.length;
        for(int i=0;i<len;i++){//初始化
            arhats[i].index = i;
        }
        int[] index = new int[len];//怎么存下标？

        Arhat[] sortByWeight = new Arhat[len];
        System.arraycopy(arhats,0,sortByWeight,0,len);
        Arhat[] sortByHeight = new Arhat[len];
        System.arraycopy(arhats,0,sortByHeight,0,len);
        Arrays.sort(sortByWeight,new WeightComparater());//按体重从大到小排序
        Arrays.sort(sortByHeight,new HeightComparater());//按升高从小到大排序
        //下面找出身高从小到大排序的最长子序列
        int[][] max = new int[len+1][len+1];
        for(int i=0;i<len+1;i++){
            max[0][i] = 0;
            max[i][0] = 0;
        }
        for(int i=1;i<len+1;i++){
            for(int j=1;j<len+1;j++){
                if(sortByHeight[i-1].height==sortByWeight[j-1].height){
                    max[i][j] = max[i-1][j-1] + 1;
                }else{
                    if(max[i][j-1]>max[i-1][j]){
                        max[i][j] = max[i][j-1];
                    }else{
                        max[i][j] = max[i-1][j];
                    }
                }
            }
        }
        for(int i=0;i<len+1;i++){
            for(int j=0;j<len+1;j++){
                System.out.print(max[i][j]+" ");
            }
            System.out.println();
        }
        return max[len][len];
    }

    private static class Arhat{
        public int height;
        public int weight;
        public int index;

        public Arhat(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }
    }

    static class WeightComparater implements Comparator<Arhat>{
        @Override
        public int compare(Arhat a1,Arhat a2){
            if(a2.weight == a1.weight){
                return a1.height - a2.height;
            }
            return a1.weight - a2.weight;
        }
    }
    static class HeightComparater implements Comparator<Arhat>{
        @Override
        public int compare(Arhat a1,Arhat a2){
            return a1.height - a2.height;
        }
    }
}

