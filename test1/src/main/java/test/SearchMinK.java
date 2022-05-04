package test;

/**
 * Created by Administrator on 2022/1/22.
 */
public class SearchMinK {
    //方法1：全部排序
    public void quickSort(int[] A,int start,int end){
        if(end > start){
            int k = LomutoPartition(A,start,end);
            quickSort(A,start,k-1);
            quickSort(A,k+1,end);
        }
    }
    //返回数值result，满足：     左边部分< A[result] <=右边部分
    public int LomutoPartition(int[] A,int start,int end){
        if(start >= end)
            return start;
        int begin = A[start];
        int result = start;
        for(int i = start + 1;i <= end;i++){
            if(A[i] < begin){
                result++;
                swap(A,i,result);
            }
        }
        swap(A,start,result);
        return result;
    }
    //交换数组m位置和n位置上的值
    public void swap(int[] arrayA,int m,int n){
        int temp = arrayA[m];
        arrayA[m] = arrayA[n];
        arrayA[n] = temp;
    }
    //输出数组前k个元素
    public void printArrayK(int[] array,int k){
        for(int i = 0;i < k;i++){
            System.out.print(array[i]+" ");
        }
    }
    public static void main(String[] args) {
        SearchMinK test = new SearchMinK();
        int[] A = {9, 8, 7, 5, 4, 3, 2, 1, 6, 3, 4, 5, 12, 32, 3, 2, 1, 4, 6, 34};
        test.quickSort(A, 0, A.length - 1);
        System.out.println("对数组进行排序后结果：");
        for (int i = 0; i < A.length; i++)
            System.out.print(A[i] + " ");
        System.out.println("\n" + "输出数组最小的5个数：");
        test.printArrayK(A, 5);
    }
}
