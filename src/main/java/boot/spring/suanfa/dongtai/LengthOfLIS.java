package boot.spring.suanfa.dongtai;

/**
 * @program: SSM
 * @description: 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * @author: Hatake
 * @create: 2020-07-06 23:32
 **/
public class LengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        //定义dp 存储的就是以nums[i]为下标的数组的最长子序列
        //1 重叠子问题 2最优子结构  3状态方程
        int[] du = new int[nums.length];
        for (int i = 0;i < nums.length;i++){
            //每个以nums[i]为下标的数组，至少最长子序列为1
            du[i] = 1;
        }
        for (int i=0;i < nums.length;i++){ // [1,2,1,3,6]
            for(int j = 0;j<i;j++){
                //j 从0  到 i 如果发现了nums[i] > nums[j],那么说明nums[i] 在 nums[j]的最长子序列上又+1  也就是 du[j] + 1
                if(nums[i] > nums[j]){
                    du[i] = Math.max(du[i],du[j] + 1);//假设du[1] = 1,du[j=2]= 1,du[i=1] = max(1,du[j]+1) 于是 du[2] = 2
                }
            }
        }
        int res =0;
        for(int i = 0;i<du.length;i++){
            res = Math.max(res,du[i]);
        }
        return res;
    }
}
