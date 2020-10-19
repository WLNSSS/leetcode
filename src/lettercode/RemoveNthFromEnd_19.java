package lettercode;

public class RemoveNthFromEnd_19 {
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
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode result = head;
		if(head == null || head.next == null) {
			head = null;
			result = head;
		}else {
			if(n == dfs(head,n,null))
				result = head.next;
		}
		return result;
	}
	
	public int dfs(ListNode head,int n,ListNode pre) {
		if(head.next == null) {
			if(1 == n) {
				pre.next = head.next;
			}
			return 1;
		}else {
			int result = dfs(head.next,n,head) + 1;
			if(result == n && pre != null) {
				pre.next = head.next;
			}
			return result;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
