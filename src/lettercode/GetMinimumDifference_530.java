package lettercode;

import java.util.List;

public class GetMinimumDifference_530 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	private int result = Integer.MAX_VALUE;
    private TreeNode preNode = null;
    public int getMinimumDifference(TreeNode root) {
        //二叉查找树中，中间节点的值一定是其左右节点值的中间数，因此最小差别一定是在中间节点与左右节点之间
        //中序遍历二叉查找树，每次比较当前节点与前一节点差值的绝对值与目前result中保存的最小值的大小，将较小的保存在result中
        getMin(root);
        return result;
    }
    
    private void getMin(TreeNode root){
        if(root == null){
            return;
        }
        getMin(root.left);
        if(preNode != null)
        {
            result = Math.min(Math.abs(root.val - preNode.val), result);
        }
        preNode = root;
        getMin(root.right);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
