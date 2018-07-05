/**
 * MergeSort
 * Created by IntelliJ IDEA.
 *
 * @author Wang Qi
 * @version 1.0 2018/7/5 18:50
 * @see MergeSort
 * To change this template use File | Settings | File Templates.
 */

public class MergeSort<T extends Comparable<? super T>> {
    //核心两组有序数据合并算法,注意在这里并没有明显拆分出2个数组，只是在同一个数组中引用
    private void merge(T[] target, T[] store, int a_pointer, int b_pointer, int end){//入参为一个要排序的数组和两个数组的指针，和当前处理数组的长度
        //a数组的结尾
        int ae_pointer = b_pointer - 1;//b数组第一个节点左移一位就是a数组的结尾
        int store_pointer = a_pointer; //这个就是c数组的指针，也就是存储数组的指针，这样做的目的是能动态的变动这个数组
        int element_size = end - a_pointer + 1;//这个表示当前处理元素数量

        //while循环，如果数组没有用完就一直循环
        while(a_pointer <= ae_pointer && b_pointer <= end){
            if(target[a_pointer].compareTo(target[b_pointer]) <= 0){//如果a数组指针指向位置小于b指针指向位置，那么就要把a数据存储到c中，并移动指针
                store[store_pointer++] = target[a_pointer++];
            }else{
                store[store_pointer++] = target[b_pointer++];
            }
        }


        //如果某一个数组用完，那么需要把另外一个数组拷贝到c数组中
        while(a_pointer <= ae_pointer){//b数组用完，则把a数组剩余拷贝到c中
            store[store_pointer++] = target[a_pointer++];
        }

        while(b_pointer <= end){//a数组用完，则把b数组剩余拷贝到c中
            store[store_pointer++] = target[b_pointer++];
        }


        //我们把排序好的部分放入目标数组中
        for (int i = 0; i < element_size; i++, end--) {
            target[end] = store[end];
        }
    }



    private void mergeSort(T[] target, T[] store, int start, int end){//需要排序的目标数组
        //递归临界条件，数组必须存在
        if(end > start){
            //把目标数据拆分为两部分
            int mid = (start + end)/2;
            //左边的数组排序
            mergeSort(target, store, start, mid);
            //右边的数组排序
            mergeSort(target, store, mid + 1, end);

            //执行归并
            merge(target, store, start, mid+1, end);
        }
    }


    public void mergeSort(T[] target){//方法我们主要是把c数组，也就是存储数组单独拿出来创建，这样一来只会创建一次,可以有效提升效率
        T[] store = (T[]) new Comparable[target.length];
        mergeSort(target, store, 0, target.length - 1);
    }


    public static void main(String[] args) {
        MergeSort<Integer> sort = new MergeSort<Integer>();
        Integer[] target = {6,5,9,7,5,8,4,2,1};
        sort.mergeSort(target);
        for (Integer integer : target) {
            System.out.print(integer + " ");
        }

    }
}
