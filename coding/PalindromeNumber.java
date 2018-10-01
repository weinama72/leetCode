package laioffer;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/04/24
 *     desc  :
 * </pre>
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
    	//negative, false
        if (x < 0) return false;
        int copyX = x, reverse = 0;
        // 
        while (copyX > 0) {
        	//1，12；12，1；121，0
        	//低位变高，高位变低
            reverse = reverse * 10 + copyX % 10;
            //x/10,去掉个位，再取末位就变成取10位上的数
            copyX /= 10;
        }
        return x == reverse;
    }

//    public boolean isPalindrome(int x) {
//        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
//        int halfReverseX = 0;
//        while (x > halfReverseX) {
//            halfReverseX = halfReverseX * 10 + x % 10;
//            x /= 10;
//        }
//        return halfReverseX == x || halfReverseX / 10 == x;
//    }

    public static void main(String[] args) {
    	PalindromeNumber solution = new PalindromeNumber();
        System.out.println(solution.isPalindrome(-1));
        System.out.println(solution.isPalindrome(10010));

        System.out.println(solution.isPalindrome(0));
        System.out.println(solution.isPalindrome(11));
        System.out.println(solution.isPalindrome(121));
        System.out.println(solution.isPalindrome(222222222));
    }
}
