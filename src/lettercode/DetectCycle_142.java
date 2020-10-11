package lettercode;

public class DetectCycle_142 {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public ListNode detectCycle(ListNode head) {
        ListNode highSpeedPoint = head;
        ListNode lowSpeedPoint = head;
        while(true){
        	if(lowSpeedPoint.next != null && highSpeedPoint.next.next != null) {
        		lowSpeedPoint = lowSpeedPoint.next;
        		highSpeedPoint = highSpeedPoint.next.next;
        	}else {
        		return null;
        	}
        	if(highSpeedPoint == lowSpeedPoint && highSpeedPoint != head) {
        		return highSpeedPoint;
        	}
        }
    }
	public static void main(String[] args) {
		DetectCycle_142 dc = new DetectCycle_142();
		ListNode ln1 = dc.new ListNode(3);
		ListNode ln2 = dc.new ListNode(2);
		ListNode ln3 = dc.new ListNode(0);
		ListNode ln4 = dc.new ListNode(-4);
		ln1.next = ln2;
		ln2.next = ln3;
		ln3.next = ln4;
		ln4.next = ln1;
		dc.detectCycle(ln1);
	}

}
