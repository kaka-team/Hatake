package boot.spring.suanfa;

/**
 * @program: SSM
 * @description: 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。---前提是0-n所有数字都存在，否则无法满足 nums[i] = i
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * @author: Hatake
 * @create: 2020-08-17 21:42
 **/
public class FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        int repeat = -1;
        if(nums.length < 1){
            return repeat;
        }
        for(int i =0;i<nums.length;i++){
            //如果没有重复，正常来说，应该是数字i在nums[i]的位置，正常情况下，循环完一轮后，应该i=nums[i]跳出
            //作用是先排序 如果后续碰到某个数字，他的数值 在之前排列好的数组中有了对应，比如 1234 都拍好了， 第五个数字是2，那么发现nums[nums[5]] = numS【2】说明重复了
            while (i != nums[i]){
                if(nums[nums[i]] == nums[i]){
                    return nums[i];
                }
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return repeat;
    }
}
