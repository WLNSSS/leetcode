package lettercode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderBottom_107 {
	
    public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	}
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null) {
			return result;
		}
		Queue<TreeNode> firstList = new LinkedList<TreeNode>();
		Queue<TreeNode> secondList = new LinkedList<TreeNode>();
		firstList.offer(root);
		
		while(firstList.size() != 0 || secondList.size() != 0) {
			List<Integer> tempList = new ArrayList<Integer>();
			while(firstList.size() != 0) {
				TreeNode removeNode = firstList.remove();
				tempList.add(removeNode.val);
				if(removeNode.left != null)
					secondList.offer(removeNode.left);
				if(removeNode.right != null)
					secondList.offer(removeNode.right);
			}
			if(tempList.size() != 0)
				result.add(tempList);
			
			tempList = new ArrayList<Integer>();
			while(secondList.size() != 0) {
				TreeNode removeNode = secondList.remove();
				tempList.add(removeNode.val);
				if(removeNode.left != null)
					firstList.offer(removeNode.left);
				if(removeNode.right != null)
					firstList.offer(removeNode.right);
			}
			if(tempList.size() != 0)
				result.add(tempList);
		}
		Collections.reverse(result);
		return result;

    }

	public static void main(String[] args) {
		LevelOrderBottom_107 lob = new LevelOrderBottom_107();
		TreeNode tn3 = lob.new TreeNode(3);
		TreeNode tn9 = lob.new TreeNode(9);
		TreeNode tn20 = lob.new TreeNode(20);
		TreeNode tn15 = lob.new TreeNode(15);
		TreeNode tn7 = lob.new TreeNode(7);
		tn3.left = tn9;
		tn3.right = tn20;
		tn20.left = tn15;
		tn20.right = tn7;
		lob.levelOrderBottom(tn3);
	}

}
