package laioffer;





//题意是用一个新链表来合并两个已排序的链表，那我们只需要从头开始比较已排序的两个链表，
//新链表指针每次指向值小的节点，依次比较下去，最后，当其中一个链表到达了末尾，
//我们只需要把新链表指针指向另一个没有到末尾的链表此时的指针即可。
// listNode contains value and address for next element. 

// * Definition for singly-linked list.
//public class ListNode {
//      int val;
//      ListNode next;
//      ListNode(int x) { val = x; }
//  }

class Merge2List {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	
    	// 1. create a dummy root for coding, return head.next in the end as result, // head = 0
        ListNode head = new ListNode(0);
        
        // 2. create helper node temp??? point to head. 
        // temp and head point to same value and address, it is same. 
        // if temp was changed, then head will be changed??
        ListNode temp = head;
        
        // 3. l1, l2 is not null
        while (l1 != null && l2 != null) {
        	//3.1 l1 val is samller, 
            if (l1.val < l2.val) {
            	// temp = l1
                temp.next = l1;
                // l1 move to next element
                l1 = l1.next;
                
            // else l2 smaller or equal to l1 
            } else {
                temp.next = l2;
                // l2 move to next
                l2 = l2.next;
            }
            // 3.3 update temp node. temp move to next element
            temp = temp.next;
        }
        // 4. There are null values in list.
        // li is not null? true, temp.next=l1, otherwise temp.next=l2
        temp.next = l1 != null ? l1 : l2;
        // 从 head.nxt 即 1 开始返回链表
        return head.next;
    }
}




//
//
//
//import entity.ListNode;
//
////Merge two sorted linked lists and return it as a new list.
////The new list should be made by splicing together the nodes of the first two lists.
////把2个sort好的linkedlist合并成一个sort好的linkedlist  类似 mergesort
//public class Merge2SortedList {
//
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if (l1 == null && l2 == null) {
//            return null;
//        }
//        if (l1 == null && l2 != null) {
//            return l2;
//        }
//        if (l1 != null && l2 == null) {
//            return l1;
//        }
//        // 这个root 是dummy head 为了方便编程，是空的，最后 返回的是head.next
//        ListNode head = new ListNode(0); // root 到最后会变成指向linkedlist倒数第二个节点
//        ListNode root = head;
//        while (l1 != null && l2 != null) {
//            //不要忘了 都是先建好 root.next = 你要的东西 然后再把 root.next设为root 下次实际上等于是说root。next。next=。。。。
//            if (l1.val <= l2.val) {
//                root.next = new ListNode(l1.val);
//                root = root.next;
//                l1 = l1.next;
//            } else {
//                root.next = new ListNode(l2.val);
//                root = root.next;
//                l2 = l2.next;
//            }
//
//        }
//        if (l1 == null) {
//            if (l2 != null) {
//                root.next = l2;
//            }
//        } else if (l2 == null) {
//            if (l1 != null) {
//                root.next = l1;
//            }
//        }
//
//        return head.next;
//    }
//
//    public static void main(String[] args) {
//        ListNode root1 = new ListNode(2);
//
//        ListNode root2 = new ListNode(1);
//        System.out.print((new Merge2SortedList().mergeTwoLists(root1, root2)).val);
//    }
//
//}
//