import test.Cackers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * description :
 *
 * @author : wangqi
 * @version :1.0
 * @date : 2022/11/9 15:52
 */
public class 饼干 {
    public static void getCracker(int i, int n, int k, ArrayDeque deque, List<List<String>> list){
        if(k<0) {
            return;
        }
        for(;i<n;i++){
            if(i==n-1){
                deque.addLast(k);
                if(deque.size()==3)
                    list.add(new ArrayList<>(deque));
                deque.removeLast();
            }
            for(int j=0;j<=k;j++){
//                System.out.println(j);
                deque.addLast(j);
                getCracker(i+1,n,k-j,deque,list);
                deque.removeLast();

            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();
        ArrayDeque deque = new ArrayDeque();
        饼干.getCracker(0,3,3,deque,list);
        System.out.println(list);
    }
}
