package lettercode;

public class ConvertBST_538 {
	int num = 0;

	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
		}
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            //����������
            convertBST(root.right);
            //��������
            root.val = root.val + num;
            num = root.val;
            //����������
            convertBST(root.left);
            return root;
        }
        return null;
    }
}
