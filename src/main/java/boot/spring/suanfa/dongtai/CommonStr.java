package boot.spring.suanfa.dongtai;

/**
 * @program: SSM
 * @description:
 * @author: Hatake
 * @create: 2021-01-13 20:21
 **/
public class CommonStr {

    public String LCS2(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[n+1][m+1];
        int max = 0;
        int end = 0;
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n ;j++){
                if(str1.charAt(i) == str2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j] + 1;
                    if(max < dp[i+1][j+1]){
                        max =  dp[i+1][j+1];
                        end = i+1;
                    }
                }
            }
        }
        return max == 0 ?"-1":str1.substring(end - max,end);
    }























        //"1AB2345CD","12345EF"
    //dp[i][j] 代表以 str1[i-1]str2[j-1]为结尾的公共字符串
    public String LCS (String str1, String str2) {

        // write code here
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[n+1][m+1];
        //end 代表str1中 最长len对应的最后一个字符
        int maxLen = 0,end =0;
        for(int i = 0 ;i < m;i++){
            for(int j =0;j < n;j++){
                if(str1.charAt(i) == str2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j] + 1;
                    if(maxLen < dp[i+1][j+1]){
                        maxLen =dp[i+1][j+1];
                        end = i + 1;
                    }
                }
            }
        }
        return maxLen == 0 ? "-1" : str1.substring(end-maxLen,end);
    }
}
