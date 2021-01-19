package boot.spring.suanfa.dongtai;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: SSM
 * @description:斐波那契额
 * @author: Hatake
 * @create: 2020-07-03 00:20
 **/
public class Fib {

    public int fib(int n){
        if(n == 1|| n == 2){
            return 1;
        }
        Map<Integer,Integer> dp = new HashMap<>();
        dp.put(1,1);
        dp.put(2,1);
        for (int i = 3;i <=n ;i ++){
            int num = dp.get(i - 2) + dp.get(i - 1);
            dp.put(i,num);
        }
        return dp.get(n);
    }


    public int fib2(int n){
        if(n == 1|| n == 2){
            return 1;
        }
        return fib2(n-1)+fib2(n -2);
    }









   /* public int fib(int n) {
        if(n == 1 || n == 2){
            return 1;
        }
        Map<Integer,Integer> dp =  new HashMap<>();
        dp.put(1,1);
        dp.put(2,1);
        for(int i = 3;i<=n;i++){
            int sum = dp.get(i - 1) + dp.get(i - 2);
            dp.put(i,sum);
        }
        return dp.get(n);
    }*/
}
