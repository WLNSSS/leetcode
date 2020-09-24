package lettercode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindMode_501 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public int[] findMode(TreeNode root) {
		Map<Integer, Integer> result = new HashMap<Integer, Integer>();
		if(root != null) {
			solution(root, result);
		}
		List<Integer> finalResult = new ArrayList<Integer>();
		int max = 0;
		for(Map.Entry<Integer,Integer> entry: result.entrySet()) {
			if(entry.getValue() > max) {
				finalResult.clear();
				finalResult.add(entry.getKey());
				max = entry.getValue();
			}else if(entry.getValue() == max) {
				finalResult.add(entry.getKey());
			}
		}
		return finalResult.stream().mapToInt(Integer::valueOf).toArray();
    }
	public void solution(TreeNode root,Map<Integer, Integer> result) {
		if(root.left != null)
			solution(root.left,result);
		if(root.right != null)
			solution(root.right,result);
		if(result.containsKey(root.val)){
			result.put(root.val, result.get(root.val) + 1);
		}else {
			result.put(root.val, 1);
		}
	}
	public static void main(String[] args) {
		FindMode_501 fm = new FindMode_501();
		TreeNode tn = fm.new TreeNode(2147483647);
		fm.findMode(tn);
	}

}
