package leetcode;

public class NthNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[] = {1,2,3,4,5};
		
		ListNode node = new ListNode(5), head;
		for(int i=a.length-1;i>=0;i--) {
			ListNode n = new ListNode(a[i]);
			n.next = node;
			node = n;
		}
		head = node;
		display(head);
				
		//removeNthFromEnd(, 2)

	}
	
	public static void display(ListNode head) {
		ListNode node = head;
		while(node.next != null) {
			System.out.print("->"+node.val);
			node = node.next;
		}
	}
	public static ListNode removeNthFromEnd(ListNode head, int n) {
        
        int k = n+1;
        
        ListNode leadNode = head, preK = head;
        
        while(k>0){
            if(leadNode.next == null) return null;
            leadNode = leadNode.next;
        }
        while(leadNode.next != null){
            leadNode = leadNode.next;
            preK = preK.next;
        }
        
        preK = preK.next.next;
        
        return head;
    }

	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	 
}

/**
 * Definition for singly-linked list.
 */

    