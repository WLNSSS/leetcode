package lettercode;

import java.util.Arrays;

public class BuildTree_106 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		int inorderLen = inorder.length;
		int postorderLen = postorder.length;
		if(inorderLen == 0 &&  postorderLen == 0) 
			return null;
		TreeNode root = new TreeNode(postorder[postorderLen - 1]);
		int inorderIndex = 0;
		for(int i = 0;i < inorderLen;i++) {
			if(inorder[i] == root.val) {
				inorderIndex = i;
				break;
			}
		}
		root.left = buildTree(Arrays.copyOf(inorder, inorderIndex),Arrays.copyOf(postorder, inorderIndex));
		root.right = buildTree(Arrays.copyOfRange(inorder, inorderIndex + 1,inorderLen),Arrays.copyOfRange(postorder, inorderIndex,postorderLen - 1));
		return root;
    }
	
	public static void main(String[] args) {
		int[] inorder = {9,3,15,20,7};
		int[] postordeer = {9,15,7,20,3};
		BuildTree_106 bt = new BuildTree_106();
		TreeNode tn = bt.buildTree(inorder, postordeer);
		System.out.println(tn);
	}

}
