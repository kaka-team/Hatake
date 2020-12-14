package boot.spring.suanfa.dongtai;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: SSM
 * @description:
 * @author: Hatake
 * @create: 2020-08-11 23:33
 **/
public class Beibao {
    public static int cal(int /*初始容量*/initV, int /*物品数量*/num, int[]/*物品重量*/ wights,int[] /*物品价值*/vals){
        //确定dp dp[i][j] -》 在装了i件物品的时候，当前背包的剩余空间为j  数值代表的是此时可以装的最大价值
        int[][] dp = new int[num+1][initV+1];
        for (int i =0;i<=num;i++){
            for (int j = 0;j<=initV;j++){
                dp[i][j]=0;
            }
        }

        for (int i =1;i<=num;i++){//从1开始，注意
            for (int rest = 1;rest<=initV;rest++){
                //如果当前背包装不下了，说明在装第i件，且剩余容量是j的时候，容量最大也就是dp[i-1][j];和装第i-1件的时候价值相同，那么这个时候
                if(rest - wights[i-1] < 0){
                    dp[i][rest] = dp[i-1][rest];
                }else{
                    //如果可以装的下，那么在装第i件，且剩余容量是rest的时候，能装 dp[i-1]//第i-1个[rest//此时的剩余量 - wights[i-1]//第i的重量] + vals[i-1]//第i的价值     的价值的东西
                    // dp[i-1][rest - wights[i-1] //表示的是当前剩余量-第i个的重量]  代表的就是，在装进第i个商品的前提下，背包能装的最大价值。。等于预留出第i个的重量后，在装第i-1个时，能装进的最大价值
                    dp[i][rest] = Math.max(dp[i-1][rest - wights[i -1 ]] + vals[i -1],dp[i-1][rest]);
                }
            }
        }

        return dp[num][initV];
    }

    public static void main(String[] args) {
        int[] w = {2,1,3};
        int[] v ={4,2,3};
        System.out.println(cal(4,3,w,v));
    }
}
