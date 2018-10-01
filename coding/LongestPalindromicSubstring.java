package laioffer;

//
//如果利用暴力法遍历所有字串是否回文的情况这道题肯定是 Time Limit Exceeded 的，
//那么我们是否可以把之前遍历的结果利用上呢，那么动态规划的想法就呼之欲出了，
//我们定义 dp[i][j] 的意思为字符串区间 [i, j] 是否为回文串，那么我们分三种情况：
//
//当 i == j 时，那么毫无疑问 dp[i][j] = true；
//
//当 i + 1 == j 时，那么 dp[i][j] 的值取决于 s[i] == s[j]；
//
//当 i + 1 < j 时，那么 dp[i][j] 的值取决于 dp[i + 1][j - 1] && s[i] == s[j]。
//
//根据以上的动态转移方程，我们的问题即可迎刃而解，时间复杂度的话显而易见，也是 O(n^2)。

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
    	//1. 
        int len = s.length();
        if (len <= 1) return s;
        int st = 0, end = 0;
        // create char helper
        char[] chars = s.toCharArray();
        // ???????
        boolean[][] dp = new boolean[len][len];
        //
        for (int i = 0; i < len; i++) {
        	//1. one element of string, 
            dp[i][i] = true;
            //
            for (int j = 0; j < i; j++) {
            	//2. if we got 2 elements of string, decide whether the 2 values are equal. equal true
                if (j + 1 == i) {
                    dp[j][i] = chars[j] == chars[i];
                    //3. if we got n elements, [i]==[j], and all inside elements are palindromic, true
                } else {
                    dp[j][i] = dp[j + 1][i - 1] && chars[j] == chars[i];
                }
                //4. ??????
                if (dp[j][i] && i - j > end - st) {
                    st = j;
                    end = i;
                }
            }
        }
        //
        return s.substring(st, end + 1);
    }
}