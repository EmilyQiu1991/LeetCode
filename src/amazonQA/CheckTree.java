package amazonQA;
import java.util.*;

import easy.TreeNode;
public class CheckTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public boolean isSubtree(TreeNode s, TreeNode t) {
         if(s==null) return false;
         if(sameTree2(s,t)) return true;
         return isSubtree(s.left,t)||isSubtree(s.right,t);
         
    }
    public boolean sameTree(TreeNode s,TreeNode t){
        if(s==null&&t==null) return true;
        if(s==null||t==null) return false;
        if(s.val==t.val&&sameTree(s.left,t.left)&&sameTree(s.right,t.right)) return true;
        else return false;
    }
    public boolean sameTree2(TreeNode s,TreeNode t){
         Queue<TreeNode> queue = new LinkedList<TreeNode>();
         queue.offer(s);
         queue.offer(t);
         while(!queue.isEmpty()){
             TreeNode left=queue.poll();
             TreeNode right=queue.poll();
             if(left==null&&right==null) continue;
             if(left==null||right==null) return false;
             if(left.val!=right.val) return false;
             queue.offer(left.left);
             queue.offer(right.left);
             queue.offer(left.right);
             queue.offer(right.right);
         }
         return true;
    }

}
