package laioffer;

public class RemoveNthNodeFromEndOfList {

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	//1. create 2 pointers 这两个指针相差 n 个元素，
        ListNode pre = head;
        ListNode afterPreN = head;
        //2. while n-- is not equals to 0. update afterPreN
        while (n-- != 0) {
            afterPreN = afterPreN.next;
        }
        //3. afterPreN not null, 
        if (afterPreN != null) {
        	//3.1 afterPreN.next is not null, update pre and afterPreN
            while (afterPreN.next != null) {
                pre = pre.next;
                afterPreN = afterPreN.next;
            }
            //3.2 afterPreN is faster than pre, diff is n, afterPreN.next = null, delet pre.next
            // 当后面的指针扫到链表末尾的时候，自然它前面的那个指针所指向的下一个元素就是要删除的元素，即 pre.next = pre.next.next;，
            pre.next = pre.next.next;
            
        //4. afterPreN is null at first time, we should delete first element. ??????????????
        } else {
            head = head.next;
        }
        //5. return head
        return head;
    }
}

//Description
//Given a linked list, remove the n-th node from the end of list and return its head.
//
//Example:
//
//Given linked list: 1->2->3->4->5, and n = 2.
//
//After removing the second node from the end, the linked list becomes 1->2->3->5.
//Note:
//
//Given n will always be valid.
//
//Follow up:
//
//Could you do this in one pass?
//
//Tags: Linked List, Two Pointers
//
//思路
//题意是让你删除链表中的倒数第 n 个数，我的解法是利用双指针，这两个指针相差 n 个元素，
//当后面的指针扫到链表末尾的时候，自然它前面的那个指针所指向的下一个元素就是要删除的元素，即 pre.next = pre.next.next;，
//但是如果一开始后面的指针指向的为空，此时代表的意思就是要删除第一个元素，即 head = head.next;。
