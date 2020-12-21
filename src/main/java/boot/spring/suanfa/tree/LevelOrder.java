package boot.spring.suanfa.tree;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @program: SSM
 * @description:给定一个二叉树，返回该二叉树层序遍历的结果，（从左到右，一层一层地遍历）
 * 思路：递归或队列
 * @author: Hatake
 * @create: 2020-12-20 21:19
 **/
public class LevelOrder {
    /**
     * 队列解法
     * @param root
     * @return
     */
    public static ArrayList<ArrayList<Integer>> levelOrderByQueue (BianLi.TreeNode root) {

        // write code here
        if(root == null){
            return new ArrayList();
        } else {
            ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
            LinkedList<BianLi.TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()){
                //先将跟节点放入队列尾部，然后再取出来，获取其子节点，再放入尾部，直到没有数据。
                //当前层的数据
                ArrayList<Integer> level = new ArrayList<Integer>();
                //每次处理到这里的时候，肯定父节点已经出去，剩下的都是当前层的子节点（同一层）
                int levelNum = queue.size();
                for(int i = 0 ;i < levelNum;i++ ){
                    if(queue.peek().left!=null){
                        queue.offer(queue.peek().left);
                    }
                    if(queue.peek().right!=null){
                        queue.offer(queue.peek().right);
                    }
                    //对头弹出父节点
                    level.add(queue.poll().val);
                }
                result.add(level);
            }
            return result;
        }

    }


    /**
     * 递归解法
     * @param root
     * @return
     */
    public static ArrayList<ArrayList<Integer>> levelOrderByDG (BianLi.TreeNode root) {
        // write code here
        if(root == null){
            return new ArrayList();
        } else {
            ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
            find(root, 0, result);
            return result;
        }
    }

    /**
     *
     * @param node 处理的节点
     * @param level 树的层级
     * @param result 结果集
     * 这样处理完以后list每个元素= 每一层的数据
     */
    public static void find(BianLi.TreeNode node,int level,ArrayList<ArrayList<Integer>> result){
        if(node == null){
            return;
        }
        //result的size应该刚好和树的层级一样
        //说明此时还没处理这一层，初始化一个list进去
        if(result.size() < level){
            result.add(new ArrayList<>());
        }
        //将该节点的数字放入
        result.get(level).add(node.val);
        //处理其左右节点
        if(node.left != null) {
            find(node.left, level+1, result);
        }
        if(node.right != null) {
            find(node.right, level+1, result);
        }
    }
}
