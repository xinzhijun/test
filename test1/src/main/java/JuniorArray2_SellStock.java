/**
 * SellStock
 * Created by IntelliJ IDEA.
 *
 * @author Wang Qi
 * @version 1.0 2018/6/4 14:43
 * @see JuniorArray2_SellStock
 * To change this template use File | Settings | File Templates.
 */

public class JuniorArray2_SellStock {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,6,5,5};
        int rs = maxProfit(nums);
        System.out.print(rs);
    }

    public static int maxProfit(int[] prices) {
        if(prices==null||prices.length==0){
            return 0;
        }
        int profit = 0;
        int current = prices[0];
        for(int i = 1; i < prices.length; ++i){
            if (prices[i] > current){
                profit += (prices[i] - current);
                current = prices[i];
            }else{
                current = prices[i];
            }
        }
        return profit;

    }
}
