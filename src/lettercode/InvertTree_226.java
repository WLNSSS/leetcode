package lettercode;

public class InvertTree_226 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public TreeNode invertTree(TreeNode root) {
		if(root == null)
			return null;
		TreeNode tn = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(tn);
		return root;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
