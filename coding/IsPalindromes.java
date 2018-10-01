package laioffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IsPalindromes {
	public boolean isPalindrome(String s) {
		//把string 变成char数组，trim去掉回车空格制表符，小写并charArray
		char[] cs = s.trim().toLowerCase().toCharArray();
		//arraylist，helper
		List<Integer> csI = new ArrayList<Integer>();
		//遍历char，存letter或digit
		for (char c : cs) {
			//如果char是letter或者digit，加入list，不是的没存。
			if (Character.isLetterOrDigit(c))
				//因为是list，所以要存差值，差值是int，char的话可以存c，因为a最小，所以用大的减小的，不会有负数，没必要
				csI.add(c - 'a');
			}
		//设定2个指针，最后一位index就是size-1
		int start = 0;
		int end = csI.size() -1 ;
		//
		while (start < end) {
			//头和尾只要相等就继续下一位继续比较，不相等就false
			if (csI.get(start) != csI.get(end)) {
				return false;
				}
			//
			start++;
		    end--;
		    }
		//
		return true;
		}
	
//	public boolean isPalindrome(String s) {
//		s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
//	 
//		int len = s.length();
//		if (len < 2)
//			return true;
//	 
//		Stack<Character> stack = new Stack<Character>();
//	 
//		int index = 0;
//		while (index < len / 2) {
//			stack.push(s.charAt(index));
//			index++;
//		}
//	 
//		if (len % 2 == 1)
//			index++;
//	 
//		while (index < len) {
//			if (stack.empty())
//				return false;
//	 
//			char temp = stack.pop();
//			if (s.charAt(index) != temp)
//				return false;
//			else
//				index++;
//		}
//	 
//		return true;
//	}
    public static void main(String[] args) {
    	IsPalindromes solution = new IsPalindromes();
        System.out.println(solution.isPalindrome("-1"));
        System.out.println(solution.isPalindrome("10010"));

        System.out.println(solution.isPalindrome("0"));
//        System.out.println(solution.isPalindrome(11));
        System.out.println(solution.isPalindrome("1231"));
//        System.out.println(solution.isPalindrome(222222222));
    }
	
}
