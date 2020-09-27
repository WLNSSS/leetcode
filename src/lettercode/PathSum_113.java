package lettercode;

import java.util.ArrayList;
import java.util.List;

import lettercode.BinaryTreePaths_257.TreeNode;

public class PathSum_113 {
	List<List<Integer>> results = new ArrayList<List<Integer>>();
	int fistRootVal = 0;
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	}
	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		if(root != null) {
			List<Integer> result  = new ArrayList<Integer>();
			result.add(root.val);
			int resultSum = root.val;
			fistRootVal = root.val;
			dfs(root,sum,result,resultSum);
		}
		return results;
    }
	
	public boolean dfs(TreeNode root, int sum,List<Integer> result,int resultSum) {
		if(root.left == null && root.right == null && (resultSum) != sum)
			return false;
		if(root.left == null && root.right == null && (resultSum) == sum) {
			results.add(new ArrayList<Integer>(result));
//			result.clear();
//			result.add(fistRootVal);
//			resultSum = fistRootVal;
			return true;
		}
		if(root.left != null) {
			result.add(root.left.val);
			resultSum += root.left.val;
//			if(!) {
			dfs(root.left,sum,result,resultSum);
				result.remove(result.size() - 1);
				resultSum -= root.left.val;
//			}
		}
		if(root.right != null) {
			result.add(root.right.val);
			resultSum += root.right.val;
//			if(!) {
			dfs(root.right,sum,result,resultSum);
				result.remove(result.size() - 1);
				resultSum -= root.right.val;
//			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		PathSum_113 brp = new PathSum_113();
//		TreeNode tn5 = brp.new TreeNode(5);
//		TreeNode tn4 = brp.new TreeNode(4);
//		TreeNode tn8 = brp.new TreeNode(8);
//		TreeNode tn11 = brp.new TreeNode(11);
//		TreeNode tn13 = brp.new TreeNode(13);
//		TreeNode tn41 = brp.new TreeNode(4);
//		TreeNode tn7 = brp.new TreeNode(7);
//		TreeNode tn2 = brp.new TreeNode(2);
//		TreeNode tn51 = brp.new TreeNode(5);
//		TreeNode tn1 = brp.new TreeNode(1);
//		tn5.left = tn4;
//		tn5.right = tn8;
//		tn4.left = tn11;
//		tn8.left = tn13;
//		tn8.right = tn41;
//		tn11.left = tn7;
//		tn11.right = tn2;
//		tn41.left = tn51;
//		tn41.right = tn1;
		
//		TreeNode tn5 = brp.new TreeNode(5);
//		TreeNode tn4 = brp.new TreeNode(4);
//		TreeNode tn8 = brp.new TreeNode(8);
//		TreeNode tn11 = brp.new TreeNode(11);
//		TreeNode tn13 = brp.new TreeNode(13);
//		TreeNode tn41 = brp.new TreeNode(4);
//		TreeNode tn7 = brp.new TreeNode(7);
//		TreeNode tn2 = brp.new TreeNode(2);
//		TreeNode tn1 = brp.new TreeNode(1);
//		tn5.left = tn4;
//		tn5.right = tn8;
//		tn4.left = tn11;
//		tn8.left = tn13;
//		tn8.right = tn41;
//		tn11.left = tn7;
//		tn11.right = tn2;
//		tn41.right = tn1;
		
		TreeNode tn2 = brp.new TreeNode(-2);
		TreeNode tn3 = brp.new TreeNode(-3);
		tn2.right = tn3;
		brp.pathSum(tn2, -5);
	}

}
