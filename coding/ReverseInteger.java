package laioffer;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/04/19
 *     desc  :
 * </pre>
 */
public class ReverseInteger {
    public int reverse(int x) {
        long res = 0;
        // 没有初始i，结束是i =0, x/10,去掉个位，再取末位就变成取10位上的数值
        for (; x != 0; x /= 10)
        	// 个位挪到高位，十位或百位，原来10位变个位
            res = res * 10 + x % 10;
        return res > Integer.MAX_VALUE || res < Integer.MIN_VALUE ? 0 : (int) res;
        //题意是给你一个整型数，求它的逆序整型数，而且有个小坑点，
//        当它的逆序整型数溢出的话，那么就返回 0，用我们代码表示的话可以求得结果保存在 long 中，
//        最后把结果和整型的两个范围比较即可。因为倒过来有可能变大，超出范围
    }

    public static void main(String[] args) {
    	ReverseInteger solution = new ReverseInteger();
        System.out.println(solution.reverse(123));
        System.out.println(solution.reverse(-123));
        System.out.println(solution.reverse(100));
        System.out.println(solution.reverse(1000000003));
    }
}