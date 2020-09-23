package lettercode;

public class MergeTrees {

	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	}
	
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if(t1 == null) {
			return t2;
		}
		if(t2 == null) {
			return t1; 
		}
		TreeNode tn = new TreeNode(t1.val + t2.val);
		tn.left = mergeTrees(t1.left,t2.left);
		tn.right = mergeTrees(t1.right, t2.right);
		return tn;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
