package Leetcode;

public class SwapNodesInPairs {

	//Definition for singly-linked list.
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}
	class Solution {
	    public ListNode swapPairs(ListNode head) {
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
	
	
	
	
}
