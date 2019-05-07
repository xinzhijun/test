package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//数组元素和是某个值
public class ListSum {
    public static List getSum(int first,int[] ints, int lastSum, int sum, int i, List<List<Integer>> fianlList, List<Integer> list) {
        if (fianlList == null) {
            fianlList = new ArrayList<>();
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        if (first >= ints.length|| i>= ints.length) {
            return fianlList;
        }
        lastSum = lastSum - ints[i];
        list.add(ints[i]);
        if (lastSum  == 0) {
            fianlList.add(list);
            list = new ArrayList<>();
            i=++first;
            getSum(first,ints, sum,sum,i, fianlList, list);
        } else if (lastSum < 0) {
            list.clear();
            i=++first;
            getSum(first,ints, sum,sum,i, fianlList, list);
        } else {
            getSum(first,ints, lastSum,sum,++i, fianlList, list);
        }
        return fianlList;

    }

    public  static void main(String[] args){
        int[] ints = new int[]{2,4,2,78,9,9,71};
        List  list = getSum(0,ints, 80,80, 0, null, null);
        System.out.println(list);
    }
}
