package boot.spring.suanfa.tree;

/**
 * @program: SSM
 * @description:
 * @author: Hatake
 * @create: 2020-06-09 23:51
 **/

//t是否是s的子树
public class IsSonTree {
     public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null){
            return false;
        }
        //2树是否相等
        if(isSame(s,t)){
            return true;
        }else {
            //比较t是否包含于s的左右子树之中，也就是判断什么时候s的某棵子树与t相等
            return isSubtree(s.left,t) || isSubtree(s.right,t);
        }

    }

    public boolean isSame(TreeNode p,TreeNode q){
         //如果2个node都为null，说明进行到这一步，已经无可继续比较的子节点，可以跳出，说明匹配完毕
        if(p == null && q ==null){
            return true;
        }
        //说明匹配出现断层，
        if(p == null || q == null){
            return false;
        }
        //进行数值的比较
        if(p.val!=q.val){
            return false;
        }
        //该步骤2个节点数值相等，可以进行下一步的比较,左右都要比较
        return isSame(p.left,q.left) && isSame(p.right,q.right);
    }
}
