package lettercode;

import lettercode.AddTwoNumbers_2.ListNode;

public class ReorderList_143 {
	ListNode root;
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
	public void reorderList(ListNode head) {
		root = head;
		
	}
	public void dfs(ListNode head) {
	}

}
