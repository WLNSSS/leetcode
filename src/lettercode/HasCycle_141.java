package lettercode;

public class HasCycle_141 {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public boolean hasCycle(ListNode head) {
		if(head == null || head.next == null) 
			return false;
		if(head.next == head)
			return true;
		ListNode headNext = head.next;
		head.next = head;
		return hasCycle(headNext);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
