package lettercode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths_257 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<String> binaryTreePaths(TreeNode root) {
	    List<String> result = new ArrayList<String>();
		if(root != null) {
			String tempString = new String();
			dfs(root,tempString,result);
		}
		return result;
	}
	
	public void dfs(TreeNode root,String preString,List<String> result) {
		if(root.left == null && root.right == null) {
			preString += root.val;
			result.add(preString);
		}else {
			String newString = preString;
			newString += root.val + "->";
			if(root.left != null)
				dfs(root.left,newString,result);
			if(root.right != null)
				dfs(root.right,newString,result);
		}
	}

	public static void main(String[] args) {
		BinaryTreePaths_257 brp = new BinaryTreePaths_257();
		TreeNode tn = brp.new TreeNode(1);
		TreeNode tn2 = brp.new TreeNode(2);
		TreeNode tn3 = brp.new TreeNode(3);
		TreeNode tn5 = brp.new TreeNode(5);
		tn.left = tn2;
		tn.right = tn3;
		tn2.right = tn5;
		brp.binaryTreePaths(tn);

	}

}
