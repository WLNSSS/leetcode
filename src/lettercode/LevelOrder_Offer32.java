package lettercode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder_Offer32 {
	public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
	}
	 
	public int[] levelOrder(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		if(root != null) {
			q.offer(root);
			while(!q.isEmpty()) {
				TreeNode tn = q.poll();
				result.add(tn.val);
				if(tn.left != null)
					q.offer(tn.left);
				if(tn.right != null)
					q.offer(tn.right);
			}
		}
		return result.stream().mapToInt(Integer::valueOf).toArray();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
