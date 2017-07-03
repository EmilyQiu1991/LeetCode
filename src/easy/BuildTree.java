package easy;

public class BuildTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inorder={1,2};
		int[] preorder={2,1};
		BuildTree b = new BuildTree();
		b.buildTree(inorder, preorder);
	}
	static int rootIndex=0;
    public TreeNode buildTree(int[] inorder, int[] preorder) {
        if(inorder.length==0||preorder.length==0||preorder.length!=inorder.length) return null;
       return helper(inorder,preorder,0,inorder.length-1);
    }
	public TreeNode helper(int[] inorder,int[] preorder, int start,int end){
	    if(start>end){
	        return null;
	    }
        TreeNode root = new TreeNode(preorder[rootIndex]);
        //assume it is valid
        int index = search(inorder,preorder[rootIndex],start,end);
        if(start <= index-1)
        {
            rootIndex++;
            root.left = helper(inorder,preorder,start,index-1);
        }
        if(index+1 <= end){
            rootIndex++;
            root.right= helper(inorder,preorder,index+1,end);
        }
        return root;
	}
	public int search(int[] inorder,int target, int start, int end){
	    for(int i=start;i<=end;i++){
	        if(inorder[i]==target){
	            return i;
	        }
	    }
	    return -1;
	}

}
