package lettercode;

import java.util.LinkedList;
import java.util.Queue;

public class BalanceTree110 {

	 public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	 
	
	public boolean isBalanced(TreeNode root) {
		if(root == null) {
			return true;
		}
		return findLayer(root) == -1 ? false : true;
		
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int findLayer(TreeNode root) {
		if (root == null) return 0;
        int left = findLayer(root.left);
        if(left == -1) return -1;
        int right = findLayer(root.right);
        if(right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
	}
}
