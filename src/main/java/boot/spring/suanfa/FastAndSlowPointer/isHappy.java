package boot.spring.suanfa.FastAndSlowPointer;

/**
 * @program: SSM
 * @description: 写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果 可以变为  1，那么这个数就是快乐数。
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 *
 * 输入：19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 * @author: Hatake
 * @create: 2020-06-23 23:59
 **/
public class isHappy {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = squareSum(n);
        while (slow != fast){
            slow = squareSum(slow);
            //比slow快2步才能判断是否成环
            fast = squareSum(squareSum(fast));

        }
        return fast == 1;

    }
    //平方和
    private  int squareSum(int n) {
        int sum = 0;
        while (n > 0){
            int temp = n % 10;
            sum += temp *temp;
            n = n / 10;
        }
        return sum;
    }

}
