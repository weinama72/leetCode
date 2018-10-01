package laioffer;

public class SwapNodesInPairs {
	
    public ListNode swapPairs(ListNode head) {
    	//1. exceptional
        if (head == null || head.next == null) return head;
        //2. swap current 2 nodes, then swap rest 2 nodes
        // 4-2-3-1-null, head=4,node=2
        //最里层，head=3,node=1,node.next=null
        ListNode node = head.next;
        //3 -- > swapPairs(null) , if head = null, return null. 
        head.next = swapPairs(node.next);
        // 1-->3
        node.next = head;
        // node = 1, 1-3-null, return 1
        return node;
        // outside, head = 4, node = 2, head.next = swapPairs(1);1-3-null
        // 4 --> 1
        // 2 --> 4
        // 2-4-1-3-null
    }
    
//    题意是让你交换链表中相邻的两个节点，最终返回交换后链表的头，限定你空间复杂度为 O(1)。
//    我们可以用递归来算出子集合的结果，递归的终点就是指针指到链表末少于两个元素时，
//    如果不是终点，那么我们就对其两节点进行交换，这里我们需要一个临时节点来作为交换桥梁，就不多说了。
    
    
    
//    另一种实现方式就是用循环来实现了，两两交换节点，
//    也需要一个临时节点来作为交换桥梁，
//    直到当前指针指到链表末少于两个元素时停止，代码很简单，如下所示。

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public ListNode swapPairs2(ListNode head) {
    	// 4231, prehead = 0 =cur
        ListNode preHead = new ListNode(0), cur = preHead;
        //0 --> 4
        preHead.next = head;
        //
        while (cur.next != null && cur.next.next != null) {
        	// temp = 2 ; 1
            ListNode temp = cur.next.next;
            // 4 --> 3 ; 3--null
            cur.next.next = temp.next;
            //2-->4;1--3
            temp.next = cur.next;
            //0 --> 2;4--1
            cur.next = temp;
            // cur = 4; 3 ,指针连移动2位
            cur = cur.next.next; // 0-->2-->4-->3 --1; 0--2--4--1--3--null
        }
        // 2
        return preHead.next;
    }

}

//Example: 
//
//Given 1->2->3->4, you should return the list as 2->1->4->3.
//Note:
//
//Your algorithm should use only constant extra space.
//You may not modify the values in the list's nodes, only nodes itself may be changed.
//Tags: Linked List
//
//思路 0
//题意是让你交换链表中相邻的两个节点，最终返回交换后链表的头，限定你空间复杂度为 O(1)。
//我们可以用递归来算出子集合的结果，递归的终点就是指针指到链表末少于两个元素时，如果不是终点，
//那么我们就对其两节点进行交换，这里我们需要一个临时节点来作为交换桥梁，就不多说了。

