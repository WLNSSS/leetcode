package lettercode;

import java.util.ArrayList;
import java.util.List;


public class PostorderTraversal_145 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if(root != null)
			solution(root, result);
		return result;
    }
	public void solution(TreeNode root,List<Integer> result) {
		if(root.left != null)
			solution(root.left,result);
		if(root.right != null)
			solution(root.right,result);
		result.add(root.val);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
