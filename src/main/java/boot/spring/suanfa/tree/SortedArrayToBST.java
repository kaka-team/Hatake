package boot.spring.suanfa.tree;

import java.util.Arrays;

/**
 * @program: SSM
 * @description:面试题 04.02. 最小高度树 二叉搜索树，左<根<右 每次从中间创建，则高度最小
 * @author: Hatake
 * @create: 2020-07-02 00:14
 **/
public class SortedArrayToBST {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0){
            return null;
        }
        int pindex =nums.length / 2;
        TreeNode root = new TreeNode(nums[pindex]);
        //左闭右开
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums,0,pindex));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums,pindex + 1,nums.length));
        return root;
    }

}
