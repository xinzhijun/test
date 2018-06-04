import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * JuniorArray1
 * Created by IntelliJ IDEA.
 *
 * @author Wang Qi
 * @version 1.0 2018/6/4 10:09
 * @see JuniorArray1
 * To change this template use File | Settings | File Templates.
 */

public class JuniorArray1 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,1,3,0,4};
        int length = removeDuplicates(nums);
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i]);
        }
    }

    public static int removeDuplicates(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>(nums.length);
        int[] noRepeatArray = new int[nums.length];
        int j=0;
        for (int num:nums) {
            if(!hashSet.contains(num)){
                noRepeatArray[j++] = num;
            }
            hashSet.add(num);
        }
        for(int k=0;k<noRepeatArray.length;k++){
            nums[k] = noRepeatArray[k];
        }
        return hashSet.size();
    }
}
