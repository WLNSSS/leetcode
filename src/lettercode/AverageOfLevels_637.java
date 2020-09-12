package lettercode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import lettercode.LevelOrderBottom_107.TreeNode;

public class AverageOfLevels_637 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}
		Queue<TreeNode> firstList = new LinkedList<TreeNode>();
		Queue<TreeNode> secondList = new LinkedList<TreeNode>();
		firstList.offer(root);

		while (firstList.size() != 0 || secondList.size() != 0) {
			List<Integer> tempList = new ArrayList<Integer>();
			while (firstList.size() != 0) {
				TreeNode removeNode = firstList.remove();
				tempList.add(removeNode.val);
				if (removeNode.left != null)
					secondList.offer(removeNode.left);
				if (removeNode.right != null)
					secondList.offer(removeNode.right);
			}
			if (tempList.size() != 0)
				result.add(tempList);

			tempList = new ArrayList<Integer>();
			while (secondList.size() != 0) {
				TreeNode removeNode = secondList.remove();
				tempList.add(removeNode.val);
				if (removeNode.left != null)
					firstList.offer(removeNode.left);
				if (removeNode.right != null)
					firstList.offer(removeNode.right);
			}
			if (tempList.size() != 0)
				result.add(tempList);
		}
//		Collections.reverse(result);
		return result;

	}

	public List<Double> averageOfLevels(TreeNode root) {
		List<List<Integer>> lists = levelOrderBottom(root);
		List<Double> result = new ArrayList<Double>();
		for(List<Integer> list : lists) {
			Long sum = (long) 0;
			for(Integer num : list) {
				sum += num;
			}
			result.add(((double)sum) / list.size());
		}
		return result;
	}
	
	public static void main(String[] args) {
		AverageOfLevels_637 lob = new AverageOfLevels_637();
		TreeNode tn1 = lob.new TreeNode(2147483647);
		TreeNode tn2 = lob.new TreeNode(2147483647);
		TreeNode tn3 = lob.new TreeNode(2147483647);
		tn1.left = tn2;
		tn1.right = tn3;
		lob.averageOfLevels(tn1);
	}

}
