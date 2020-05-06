package boot.spring.suanfa;

/**
 * @program: SSM
 * @description: 回文数 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * @author: Hatake
 * @create: 2020-05-06 23:11
 **/
public class IsPalindrome {
    public boolean isPalindrome(int x) {
        //小于0 或以0结尾的一定不是回文数
        if(x < 0 || (x % 10 ==0 && x != 0)){
            return false;
        }
        int revertNum = 0;
        while (x > revertNum){
            int y = x % 10;
            revertNum = revertNum * 10+ y ;
            x = x /10;
        }
        return revertNum == x || revertNum / 10 == x;
    }
}
