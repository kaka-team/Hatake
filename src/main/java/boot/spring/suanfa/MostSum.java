package boot.spring.suanfa;

/**
 * @program: SSM
 * @description:
 * @author: Hatake
 * @create: 2021-01-15 16:09
 **/
public class MostSum {
    public int maxsumofSubarray (int[] arr) {
        // write code here
        if(arr.length == 0) {
            return 0;
        }
        if(arr.length == 1){
            return arr[0];
        }
        //初始化动态数组
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        int max = arr[0];
        for (int i =1;i < arr.length;i++){
            if(dp[i-1]<0){
                dp[i] = arr[i];
            }else{
                dp[i] = arr[i] + dp[i - 1];
            }
            max = Math.max(dp[i],max);
        }

        return max;
    }

    /**
     * 分治
     * @param arr
     * @return
     */
    public int maxsumofSubarray2 (int[] arr) {
// write code here
        if(arr.length == 0) {
            return 0;
        }
        int sum = arr[0];
        int max = sum;
        for(int i = 1;i < arr.length;i++){
            sum = sum > 0 ? sum + arr[i] : arr[i];
            max = Math.max(max,sum);
        }
        return max;
    }
}
