package boot.spring.suanfa.dongtai;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: SSM
 * @description:
 * @author: Hatake
 * @create: 2020-07-03 00:59
 **/
public class CoinChange {
    private static Map<Integer,Integer> dp = new HashMap<>();

    public static int coinChange(int[] coins, int amount) {
        return dp(coins,amount);
    }

    public static int dp(int[] coins, int amount){
        //避免重复计算
        //dp函数的含义就是输入n个coin，返回满足的硬币数

        //备忘录存储了每个amount对应的金币数
        if(dp.containsKey(amount)){
            return dp.get(amount);
        }
        //base case 如果输入是0，那么返回0
        if(amount == 0){
            return 0;
        }
        if(amount < 0){
            return -1;
        }
        int res = Integer.MAX_VALUE;

        //自变量coin,因变量amount,选择硬币不同导致
        for (int c:coins) {
            //状态方程 最优解为  dp(f) = dp(f -  c) + 1;这样代表刚好 能凑整 1代表面值为c的这个硬币
            int sub = dp(coins,amount - c);
            //说明子序列中，没法再凑整，则说明这个方案不行，continue掉，重新尝试其他的
            if(sub == -1){
                continue;
            }
            res = Math.min(res,1 + sub); //将当前的res 与每个分支上的res进行比较，取最优
        }
        //因为是自上而下 如果res还是MAX_VALUE ，说明没有一条分支能凑整
        if(res == Integer.MAX_VALUE){
            res = -1;
        }
        dp.put(amount,res);
        return res;
    }

    public static void main(String[] args) {
        int[] coins = {2};
        System.out.println(dp(coins,3));
    }
}
