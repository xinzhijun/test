import java.util.HashMap;

/**
 * TwoSum
 * Created by IntelliJ IDEA.
 *
 * @author Wang Qi
 * @version 1.0 2018/6/4 14:02
 * @see TwoSum
 * To change this template use File | Settings | File Templates.
 */

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int[] rs = twoSum(nums, 9);
        for (int i = 0; i < rs.length; i++) {
            System.out.print(rs[i]);
        }
    }
    public static  int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){

            Integer value = map.get(target-nums[i]);
            if(value==null){
                map.put(nums[i],i);
            } else{
                return new int[]{value,i};
            }
        }
        return new int[]{0,0};
    }
}
