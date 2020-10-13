package lettercode;

public class SwapPairs_24 {

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode swapPairs(ListNode head) {
		ListNode root = head;
		if(root == null)
			return root;
		if(root.next != null)
			root = root.next;
		ListNode pre = null;
		while(head != null) {
			if(head.next != null) {
				ListNode next = head.next;
				head.next = head.next.next;
				next.next = head;
				if(pre != null)
					pre.next = next;
			}
			pre = head;
			head = head.next;
		}
		return root;
	}

	public static void main(String[] args) {
		SwapPairs_24 sp = new SwapPairs_24();
		ListNode ln1 = sp.new ListNode(1);
		ListNode ln2 = sp.new ListNode(2);
		ListNode ln3 = sp.new ListNode(3);
//		ListNode ln4 = sp.new ListNode(4);
		ln1.next = ln2;
		ln2.next = ln3;
//		ln3.next = ln4;
		sp.swapPairs(ln1);

	}

}
