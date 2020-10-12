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
        //����������У��м�ڵ��ֵһ���������ҽڵ�ֵ���м����������С���һ�������м�ڵ������ҽڵ�֮��
        //������������������ÿ�αȽϵ�ǰ�ڵ���ǰһ�ڵ��ֵ�ľ���ֵ��Ŀǰresult�б������Сֵ�Ĵ�С������С�ı�����result��
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
