package boot.spring.suanfa.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: SSM
 * @description: 105. 从前序与中序遍历序列构造二叉树
 * @author: Hatake
 * @create: 2020-07-01 22:53
 **/
public class BuildTree {
    public class TreeNode{
        int val;
        TreeNode leftNode;
        TreeNode rightNode;
        TreeNode(int x){
            val = x;
        }
    }
    Map<Integer,Integer> inorderMap = new HashMap<>();

    //先序遍历的第一个肯定是根节点，然后在中序遍历中，找到这个节点，那么这个节点左边的节点都是左子树的节点，右边的都是右子树的节点
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0;i < inorder.length;i++){
            inorderMap.put(inorder[i],i);
        }
        return buildmyTree(preorder,inorder,0,preorder.length - 1,0,inorder.length- 1);
    }

    public TreeNode buildmyTree(int[] preorder,int[] inorder,int preorder_left,int preorder_right,int inorder_left,int inorder_right){
        if(preorder_left > preorder_right || inorder_left > inorder_right){
            return null;
        }
        //前序的第一个就是根节点
        int root_in_pre_index = preorder_left;
        int rootVal = preorder[root_in_pre_index];
        //找到root在中序遍历的位置
        int root_in_order_index = inorderMap.get(rootVal);
        //中序遍历 左根右
        //那么 root_in_order_index 前的为左子树[inorder_left,root_in_order_index - 1]
        //后的为右子树[root_in_order_index  + 1,inorder_right]
        //左子树节点个数
        int left_tree_node_num = root_in_order_index  - inorder_left;
        //知道了左子树节点的个数
        // 返回先序遍历里，则可以确定左子树在先序遍历的范围为[preorder_left + 1,root_in_order_index - inorder_left + preorder_left]
        //右子树的范围就是[root_in_order_index - inorder_left + preorder_left + 1,preorder_right]

        TreeNode root = new TreeNode(rootVal);
        int left_p_l = preorder_left + 1;
        int left_p_r = preorder_left + left_tree_node_num;
        int left_in_l = inorder_left;
        int left_in_r = root_in_order_index - 1;

        int right_p_l = preorder_left + left_tree_node_num + 1;
        int right_p_r = preorder_right;
        int right_in_l = root_in_order_index + 1;
        int right_in_r = inorder_right;
        root.leftNode = buildmyTree(preorder,inorder,left_p_l,left_p_r,left_in_l,left_in_r);
        root.rightNode = buildmyTree(preorder,inorder,right_p_l,right_p_r,right_in_l,right_in_r);
        return root;
    }
}
