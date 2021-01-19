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

    public static void main(String[] args) {
        System.out.println(test("ABCBA"));
    }
    public static boolean test(String A){
        char[] strArr = A.toCharArray();
        int start = 0;
        int end = strArr.length - 1;
        boolean flag = true;
        while (start != end){
            if(strArr[start] != strArr[end]){
                flag = false;
                break;
            }
            start++;
            end--;

        }
        return flag;
    }
    public static int getLongestPalindrome2(String A, int n) {
        char[] strArr = A.toCharArray();
        int max = 1;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0 ;i < n ; i++){
            dp[i][i] = true;
        }
        for(int i = 1 ;i < n ;i++){
            for(int j = i - 1;j >=0;j--){
                if(i - j == 1){
                    dp[j][i] = (strArr[i] == strArr[j]);
                    max = Math.max(i -j + 1,max);
                }else{
                    if(dp[j+1][i-1] &&strArr[i] == strArr[j]){
                        dp[j][i] = true;
                        max = Math.max(i -j + 1,max);
                    }else{
                        dp[j][i] = false;
                    }
                }
            }
        }
        return max;
    }
    /*
    这个题目用到了动态规划的思想具体
    注意字符串的遍历顺序一定是从后向前的，
    因为这样才能解决之前没有计算而直接出答案的问题。这里的dp数组比较难想，是应该存储所经过的子字符串是否是回文数
     */
    public static int getLongestPalindrome(String A, int n) {
        char[] aa =A.toCharArray();
        int max=1;
        boolean[][] dp = new boolean[n][n];
        for(int i=0;i<n;i++){
            dp[i][i] = true;
        }
        for(int i=1;i<n;i++)//i指向的是字符的最后一位
        {
            for(int j=i-1;j>=0;j--){//j指向的是字符的前部。
                if(i-j==1){//当两个指针靠近时，直接判断
                    dp[j][i]=(aa[i]==aa[j]);
                    if(max<i-j+1) {
                        max = i-j+1;
                    }
                }

                else{
                    if(dp[j+1][i-1]&&aa[i]==aa[j]){
                        dp[j][i]=true;
                        if(max<i-j+1)
                            max = i-j+1;
                    }
                    else
                        dp[j][i]=false;
                }
            }
        }
        return max;
    }
}
