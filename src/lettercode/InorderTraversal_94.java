package lettercode;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal_94 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if(root != null)
			solution(root, result);
		return result;
    }
	public void solution(TreeNode root,List<Integer> result) {
		if(root.left != null)
			solution(root.left,result);
		result.add(root.val);
		if(root.right != null)
			solution(root.right,result);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
