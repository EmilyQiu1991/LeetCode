package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import easy.TreeNode;

public class SerializeAndDeSerialize {
	private static final String NN = "X";
	private static final String spliter = ",";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    	//build preOrder traversal String
        StringBuilder sb = new StringBuilder();
        buildString(root,sb);
        return sb.toString();
    }
    public void buildString(TreeNode root, StringBuilder sb){
    	if(root==null){
    		sb.append(NN).append(spliter);
    	}else{
    		sb.append(root.val).append(spliter);
    		buildString(root.left,sb);
    		buildString(root.right,sb);
    	}
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(spliter);
        Queue<String> list = new LinkedList<String>(Arrays.asList(nodes));
        return buildTree(list);
    }
	private TreeNode buildTree(Queue<String> nodes) {
		String value = nodes.poll();
		if(value.equals(NN)){
			return null;
		}else{
			TreeNode node = new TreeNode(Integer.valueOf(value));
			node.left = buildTree(nodes);
			node.right = buildTree(nodes);
			return node;
		}
		
	}

}
