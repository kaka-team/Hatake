package boot.spring.suanfa.BFS;

import boot.spring.suanfa.tree.BuildTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: SSM
 * @description: 给定一个二叉树，找出其最小深度。
 * @author: Hatake
 * @create: 2020-08-11 22:42
 **/
public class MinDepth {
    public int minDepth(BuildTree.TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<BuildTree.TreeNode> queue = new LinkedList<>();
        int depth = 1;
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i =0;i<size;i++){
                BuildTree.TreeNode cur = queue.poll();
                //达成条件
                if(cur.leftNode == null && cur.rightNode == null){
                    return depth;
                }
                if(cur.leftNode != null){
                    queue.offer(cur.leftNode);
                }
                if(cur.rightNode != null){
                    queue.offer(cur.rightNode);
                }
            }
            //如果经历了上面的for循环，说明这一层的节点没有合适的，进入下一层，depth++
            depth++;
        }
        return depth;
    }
}
