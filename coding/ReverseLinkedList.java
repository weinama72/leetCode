package laioffer;


//Reverse a singly linked list.
//
//Example:
//
//Input: 1->2->3->4->5->NULL
//Output: 5->4->3->2->1->NULL
//Follow up:
//
//A linked list can be reversed either iteratively or recursively. Could you implement both?

public class ReverseLinkedList {

	public ListNode reverseList1(ListNode head) {
	    /* recursive solution */
	    return reverseListInt(head, null);
	}

	private ListNode reverseListInt(ListNode head, ListNode newHead) {
		// 1. exceptional, null
	    if (head == null)
	        return newHead;
	    // 2. update next and head.next
	    ListNode next = head.next;
	    head.next = newHead;
	    // 3. return  ??????????
	    return reverseListInt(next, head);
	}
	
	////////
	public ListNode reverseList2(ListNode head) {
    /* iterative solution */
	// 1. create newHead
    ListNode newHead = null;
    //2. head not null
    while (head != null) {
    	// 3. update 
        ListNode next = head.next;
        head.next = newHead;
        // 4. 
        newHead = head;
        head = next;
    	}
    // 5. return new head
    return newHead;
	}
//////////////////
	public ListNode reverseList(ListNode pHead){
		ListNode pReversedHead = null; //反转过后的单链表存储头结点
		ListNode pNode = pHead; //定义pNode指向pHead;
		ListNode pPrev = null; //定义存储前一个结点
		while(pNode != null){
			ListNode pNext = pNode.next; //定义pNext指向pNode的下一个结点
			if(pNext==null){ //如果pNode的下一个结点为空，则pNode即为结果
				pReversedHead = pNode;
			}
			pNode.next = pPrev; //修改pNode的指针域指向pPrev
			pPrev = pNode; //将pNode结点复制给pPrev
			pNode = pNext; //将pNode的下一个结点复制给pNode
		}
		return pReversedHead;
	}
	
	public ListNode reverseList3(ListNode pHead){
		if(pHead==null || pHead.next == null){ //如果没有结点或者只有一个结点直接返回pHead
			return pHead;
		}
		ListNode pNext = pHead.next; //保存当前结点的下一结点
		pHead.next = null; //打断当前结点的指针域
		ListNode reverseHead = reverseList3(pNext); //递归结束时reverseHead一定是新链表的头结点
		pNext.next = pHead; //修改指针域
		return reverseHead;
	}
	
}

//
//public ListNode reverseList(ListNode head) {
//    if(head==null||head.next==null)
//        return head;
// 
//    ListNode p1 = head;
//    ListNode p2 = p1.next;
// 
//    head.next = null;
//    while(p1!=null&& p2!=null){
//        ListNode t = p2.next;
//        p2.next = p1;
//        p1 = p2;
//        p2 = t;
//    }
// 
//    return p1;
//}
//Java Solution 2 - Recursive
//
//public ListNode reverseList(ListNode head) {
//    if(head==null || head.next == null)
//        return head;
// 
//    //get second node    
//    ListNode second = head.next;
//    //set first's next to be null
//    head.next = null;
// 
//    ListNode rest = reverseList(second);
//    second.next = head;
// 
//    return rest;
//}