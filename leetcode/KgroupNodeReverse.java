package leetcode;


public class KgroupNodeReverse {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1->2->3->4->5
		ListNode head = new ListNode(1);
		ListNode node = new ListNode(2);
		head.next = node;
		
		ListNode nextNode = new ListNode(3);
		
		node.next = nextNode;
		node = node.next;
		nextNode = new ListNode(4);
		
		node.next = nextNode;
		node = node.next;
		nextNode = new ListNode(5);
		
		node.next = nextNode;
		node = node.next;
		nextNode = new ListNode(6);
		
		node.next = nextNode;
		node = node.next;
		nextNode = new ListNode(7);
		
		node.next = nextNode;
		node = node.next;
		nextNode = new ListNode(8);
		
		node.next = nextNode;
		node = node.next;
		nextNode = new ListNode(9);
		
		node.next = nextNode;
		node = node.next;
		
		display(head);
		reverseKGroup(head, 3);
		display(head);
		
	}

	public static ListNode preNode(int k, ListNode preNode, Boolean isHead) {
		ListNode miniHead, topNode;
		ListNode currPtr, tempNode1, tempNode2, lastNode;
		
		topNode = preNode;
		lastNode = preNode.next;
		currPtr = preNode.next;
		while(true) {
			//test for k elements
			for(int i=0;i<k-1;i++){
				if(currPtr != null && currPtr.next !=null){
	            	tempNode1 = currPtr.next; // the node to be moved
	            	tempNode2 = currPtr.next.next;
	            	
	            	//swap
	            	currPtr.next = tempNode2;
	            	tempNode1.next = currPtr;
	            	
	            	//append back to orig list
	                topNode.next = tempNode1;
	               
	            	//reset ptrs
	                //currPtr = tempNode2;
	                
	                //ready for next swap
	                //topNode = topNode.next;
	                
	            }else {
	            	return preNode;
	            }
	        }
			
			topNode = currPtr;
			currPtr = currPtr.next;
			tempNode1 = tempNode2 = null;
			display(preNode);
		}
		
		
		//return preNode;
	}
	
	public static ListNode[] moveHeadToTop(ListNode head, ListNode prev) {
		
		System.out.println("inner- in:");
		System.out.println("Head and Prev are: "+head.val+" "+prev.val);
		
		if(head == null || prev ==null || prev.next == null){
			System.out.println("prev.next is null??");
			return null;
		}
		ListNode curr = prev.next;
		prev.next = prev.next.next;
		curr.next = head;
		head = curr;
		
		ListNode[] l = new ListNode[2];
		l[0] = head; l[1]=prev;
		
		System.out.println("inner- out :");
		System.out.println("Head and Prev are: "+head.val+" "+prev.val);
		display(head);
		
		return l;

	}
	
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(k<=1) return head;
        if(head == null || head.next == null) return head;
        
        ListNode n = head;
        for(int i=0;i<k-1;i++){
        	ListNode[] ret = moveHeadToTop(head, n);
        	if(ret == null) return head;
        	head = ret[0];
        	n = ret[1];
        }
        
        display(head);
        System.out.println("CurrPtr is "+n.val);
        
        ListNode prevTail = n;
        ListNode smallHead = n.next;
        n = n.next;
        end:
        while(true) {
        	display(head);
	        System.out.println("CurrPtr is "+n.val);
        	for(int i=0;i<k-1;i++){
	        	ListNode[] ret = moveHeadToTop(smallHead, n);
	        	if(ret == null) return head;
	        	
	        	smallHead = ret[0];
	        	n= ret[1];
	        	prevTail.next = smallHead;
	        	display(head);
	        }
        	smallHead = n.next;
        	n = n.next;
        	prevTail = n;
	        
	        //n=n;
        }
        
        
//        if(n!=null && n.next != null) {
//        	n = preNode(k, n, false);
//        }else {
//        	return head;
//        }
        
        
        //return head;
    }
    
    public static void display(ListNode node) {
    	
    	while(node != null) {
    		System.out.print("->"+node.val);
    		node = node.next;
    	}
    	System.out.println();
    }
    
}

