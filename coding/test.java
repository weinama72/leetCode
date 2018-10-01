package laioffer;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		
		ListNode l2 = new ListNode(3);
		l2.next = new ListNode(5);
		
		
		Merge2List s = new Merge2List();
		ListNode res = s.mergeTwoLists(l1, l2);
		
		while(res != null) {
			System.out.println(res.val);
			res =res.next;
		}

	}

}
