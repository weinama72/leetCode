package laioffer;

import entity.ListNode;
// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8
//Explanation: 342 + 465 = 807.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

/**
 * leetcode 2 -> https://leetcode.com/problems/add-two-numbers
 * 扩展:https://leetcode.com/problems/add-two-numbers-ii/
 */
//
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	// 1. To make the code simpler as always, we create a dummy node which next point to head of result linked list
        ListNode dummy = new ListNode(0);// 哨兵节点，用来做返回值的头结点使用。
        // Also we need a pointer goes with traversal
        ListNode tail = dummy; // 用一个tail指针来操作dummy的下一个节点
        // ins
        int sum = 0; // instantiate summation of 2 linked list(each node). 
        // 2. traverse both linked list at the same time, 
        while (l1 != null || l2 != null) {
        	// 3. calculate the sum result of each digit. 
        	// 3.1 Calculate carry, if the result is 1, it means the carry should be 1
            sum /= 10; // 每次进来之后都取上次sum的十位,第一次0的十位还是0.这是为了进位所做。
            // then calculate l1 add l2. if the value of first linked list is not none, then add value of l1
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }// if the value of second linked list is not none, then add value of l2
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            //2+5， 4+6 --》0， 1+3 +4 =8 ，结果值为sum的个位，tail往后移一位
            
            // 4. put value of each digit to the node, link the node.
            tail.next = new ListNode(sum % 10);// 尾插新节点，新节点的值为sum的个位数，十位进一
            // update the pointer, 7算完该算0了，要不然0会覆盖7在某一个node上
            tail = tail.next;
        }
        // 最后，l1,l2都遍历完都为null,且最后发现sum>10,小于20,要进1位,new 新节点，接在最后
        if (sum / 10 == 1) {
        	//another exception is: final carry equals 1, deal with it.
            tail.next = new ListNode(1);
        }
        // result is dummy.next 本身是空
        return dummy.next;
    }
}
