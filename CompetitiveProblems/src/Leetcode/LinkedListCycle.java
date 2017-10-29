package Leetcode;

public class LinkedListCycle {
	
	class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) {
			 val = x;
			 next = null;
		 }
	}

	public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null) {
            slow = slow.next;
            if(fast.next == null) fast = null;
            else fast = fast.next.next;
                
            if (fast == null && slow == null) return false;
            if (fast == slow) return true;
        }
        return false;
    }

}
