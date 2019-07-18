/**
 * 
 */
package dfs;

import java.util.*;

import easy.TreeNode;

/**
 * @author qiuyu
 *
 */
public class DistanceK {
	public static void main(String[] args){
		String input = "[3,5,1,6,2,0,8,null,null,7,4]";
		TreeNode root = stringToTreeNode(input);
		Map<TreeNode , TreeNode> map = new HashMap<>();
		map.putIfAbsent(new TreeNode(1), null);
		System.out.println(map.size());
		distanceK(root, root.left, 2);
	}
		public static Map<TreeNode, TreeNode> parent = new HashMap<>();
		
	   public static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
		   List<Integer> res = new ArrayList<>();
	        dfs(root,null);
	        Queue<TreeNode> queue = new LinkedList<TreeNode>();
	        Set<TreeNode> set = new HashSet<>();
	        queue.add(target);
	        int dis = 0;
	        while(!queue.isEmpty()){
	        	int count = queue.size(); // current size of level
	        	while(count>0){
		        	TreeNode node = queue.poll();
		        	set.add(node);
	        		if(node.left!= null && !set.contains(node.left)){
	        			queue.add(node.left);
	        		}
	        		
	        		if(node.right!= null && !set.contains(node.right)){
	        			queue.add(node.right);
	        		}
	        		if(parent.get(node)!= null && !set.contains(parent.get(node))){
	        			queue.add(parent.get(node));
	        		}
	        		if(dis == K){
		        	res.add(node.val);	
		        	}
	        		count--;
	        	
	        	
	        }
	        	dis++;

	        }
	        System.out.println(res);
	        return res;
	   }
	   public static void dfs(TreeNode root, TreeNode par){
		   if(root == null)
			   return;
		   System.out.println(root.val);
		   parent.putIfAbsent(root, par);
		   dfs(root.left, root);
		   dfs(root.right,root);
	   }
	   public static TreeNode stringToTreeNode(String input) {
	        input = input.trim();
	        input = input.substring(1, input.length() - 1);
	        if (input.length() == 0) {
	            return null;
	        }
	    
	        String[] parts = input.split(",");
	        String item = parts[0];
	        TreeNode root = new TreeNode(Integer.parseInt(item));
	        Queue<TreeNode> nodeQueue = new LinkedList<>();
	        nodeQueue.add(root);
	    
	        int index = 1;
	        while(!nodeQueue.isEmpty()) {
	            TreeNode node = nodeQueue.remove();
	    
	            if (index == parts.length) {
	                break;
	            }
	    
	            item = parts[index++];
	            item = item.trim();
	            if (!item.equals("null")) {
	                int leftNumber = Integer.parseInt(item);
	                node.left = new TreeNode(leftNumber);
	                nodeQueue.add(node.left);
	            }
	    
	            if (index == parts.length) {
	                break;
	            }
	    
	            item = parts[index++];
	            item = item.trim();
	            if (!item.equals("null")) {
	                int rightNumber = Integer.parseInt(item);
	                node.right = new TreeNode(rightNumber);
	                nodeQueue.add(node.right);
	            }
	        }
	        return root;
	    }
}
