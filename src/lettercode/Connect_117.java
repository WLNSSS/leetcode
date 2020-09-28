package lettercode;

import java.util.LinkedList;
import java.util.Queue;

public class Connect_117 {
	
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
	};

	public Node connect(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		int layerFlag = 0;
		if(root != null) {
			queue.offer(root);
			layerFlag = 1;
		}
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			layerFlag--;
			
			if(n.left != null)
				queue.offer(n.left);
			if(n.right != null)
				queue.offer(n.right);
			if(layerFlag > 0) {
				n.next = queue.peek();
			}else {
				n.next = null;
				layerFlag = queue.size();
			}
		}
		return root;
	}

	public static void main(String[] args) {
		Connect_117 c = new Connect_117();
		Node tn1 = c.new Node(1);
		Node tn2 = c.new Node(2);
		Node tn3 = c.new Node(3);
		Node tn4 = c.new Node(4);
		Node tn5 = c.new Node(5);
		Node tn7 = c.new Node(7);
		tn1.left = tn2;
		tn1.right = tn3;
		tn2.left = tn4;
		tn2.right = tn5;
		tn3.right = tn7;
		c.connect(tn1);

	}

}
