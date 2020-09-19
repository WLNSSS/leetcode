package lettercode;

public class SumOfLeftLeaves_404 {

	private int sum;
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public int sumOfLeftLeaves(TreeNode root) {
		dfs(root);
		return sum;
    }
	
	public void dfs(TreeNode root) {
		if(root == null)
			return;
		if(root.left != null) {
			if(root.left.left == null && root.left.right == null)
				sum += root.left.val;
			dfs(root.left);
		}
		if(root.right != null)
			dfs(root.right);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
