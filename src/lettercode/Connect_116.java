package lettercode;

public class Connect_116 {
	class Node {
	    public int val;
	    public Node left;
	    public Node right;
	    public Node next;

	    public Node() {}
	    
	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, Node _left, Node _right, Node _next) {
	        val = _val;
	        left = _left;
	        right = _right;
	        next = _next;
	    }
	}
	
	public Node connect(Node root) {
		Node result = root;
		if(root != null)
			firstOrder(root,null);
		return result;
    }
	
	public void firstOrder(Node root,Node parent) {
		root.next = findNext(root,parent);
		if(root.left != null) {
			firstOrder(root.left, root);
		}
		if(root.right != null) {
			firstOrder(root.right, root);
		}
	}
	
	public Node findNext(Node root,Node parent) {
		Node result = null;
		if(parent == null)
			return result;
		if(parent.left == root && parent.right != null) {
			result = parent.right;
			return result;
		}
		if(parent.left != root && parent.right != root) {
			if(parent.left != null) {
				result = parent.left;
				return result;
			}else if(parent.right != null) {
				result = parent.right;
				return result;
			}
		}
		if(parent.next != null) {
			result = findNext(root,parent.next);
		}
		return result;
	}

	public static void main(String[] args) {
		Connect_116 c = new Connect_116();
		Node n1 = c.new Node(1);
		Node n2 = c.new Node(2);
		Node n3 = c.new Node(3);
		n1.left = n2;
		n1.right = n3;
		c.connect(n1);

	}

}
