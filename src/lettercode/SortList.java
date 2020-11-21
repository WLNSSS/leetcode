package lettercode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortList {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public ListNode sortList(ListNode head) {
		List<Integer> list = new ArrayList<Integer>();
		ListNode temp = head;
		while(temp != null) {
			list.add(temp.val);
		}
		Collections.sort(list);
		ListNode curNode = new ListNode(list.get(0));
		head = temp = curNode;
		for(int i = 1;i < list.size();i++) {
			ListNode curCirNode = new ListNode(list.get(i));
			temp.next = curCirNode;
			temp = curCirNode;
		}
		return head;
    }

}
