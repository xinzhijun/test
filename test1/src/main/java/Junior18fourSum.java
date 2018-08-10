import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Junior18fourSum
 * Created by IntelliJ IDEA.
 *
 * @author Wang Qi
 * @version 1.0 2018/8/9 11:45
 * @see Junior18fourSum
 * To change this template use File | Settings | File Templates.
 */

public class Junior18fourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> a = new ArrayList<>();
        if(nums.length==4&&(nums[0]+nums[1]+nums[2]+nums[3])==target){
            List<Integer> b = new ArrayList<>(4);
            b.add(nums[0]);
            b.add(nums[1]);
            b.add(nums[2]);
            b.add(nums[3]);
            a.add(b);
            return a;
        }
        Comparator c = (Comparator<Integer>) (o1, o2) -> o2 - o1;
        for(int i=0;i<nums.length-3;i++){
            for(int j=i+1;j<nums.length-2;j++){
                for(int m=j+1;m<nums.length-1;m++){
                    for(int n=m+1;n<nums.length;n++){
                        int rs =nums[i]+nums[j]+nums[m]+nums[n];
                        if( rs==target){
                            List<Integer> b = new ArrayList<>(4);
                            b.add(nums[i]);
                            b.add(nums[j]);
                            b.add(nums[m]);
                            b.add(nums[n]);
                            boolean ss =false;
                            if(a.size()>0){
                                for(List<Integer> before:a){
                                    before.sort(c);
                                    b.sort(c);
                                    int k=0;
                                    for(;k<before.size();k++){
                                        if(before.get(k).intValue()!=b.get(k).intValue()){
                                            break;
                                        }
                                    }
                                    if(k==4){
                                        ss=true;
                                        break;
                                    }
                                }
                                if(ss){
                                    continue;
                                }
                            }

                            a.add(b);
                            break;
                        }
                    }
                }
            }
        }
        return  a;

    }

    public static List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> a = new ArrayList<>();
        ConcurrentHashMap<Integer,List> h = new ConcurrentHashMap();
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;i++){
                ArrayList list;
                if(h.get(nums[i]+nums[j]).size()>0){
                    list = (ArrayList) h.get(nums[i]+nums[j]);
                }else{
                    list = new ArrayList();

                }
                list.add(new int[]{nums[i],nums[j]});
                h.put((nums[i]+nums[j]),list);
            }
        }
        for(int key: h.keySet()){
            if(h.containsKey(key*-1)){
                List list = h.get(key);
                list.add(h.get(key*-1));
                a.add(list);
            }
        }

        return a;
    }

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{-3,-2,-1,0,0,1,2,3},0));
    }
}
