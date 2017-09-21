import java.util.*;
public class SwapLinkedListPairs {

	
	public static void main(String[] args) {
		int size = (int)(Math.random()*10);
		ListNode head = new ListNode((int)(Math.random()*10));
		ListNode cur = head;
		for(int i = 0; i < size; i++) {
			ListNode node = new ListNode((int)(Math.random()*10));
			cur.next = node;
			cur = node;
		}
		printList(head);
		ListNode newHead = swapPairs(head);
		printList(newHead);
	}
	
	public static void printList(ListNode head) {
		ListNode curNode = head;
		while(curNode != null) {
			System.out.print(curNode.val + " ");
			curNode = curNode.next;
		}
		System.out.println();
	}
	
	public static ListNode swapPairs(ListNode head) {
		if(head == null) return head;
        if(head.next == null) return head;
        ListNode newHead = head.next;
        
        ListNode curNode = head.next;
        ListNode prevNode = head;
        ListNode oldNode = null;
        prevNode.next = curNode.next;
        curNode.next = prevNode;
        while(true) {
            oldNode = prevNode;
            prevNode = oldNode.next;
            if(prevNode == null) return newHead;
            curNode = prevNode.next;
            if(curNode == null) return newHead;
            prevNode.next = curNode.next;
            curNode.next = prevNode;
            oldNode.next = curNode;
        }
	}

}
class ListNode {
	int val;
	ListNode next;
	public ListNode(int val) {
		this.val = val;
		this.next = null;
	}
}