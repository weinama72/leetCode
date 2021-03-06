package laioffer;

public class Q12IntToRoman {
    public String intToRoman(int num) {
    	//1. create string array to store all combination in each digit, M --thousand, C hundred, X tens, 
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        // 2. calculate number in each digit, make it as index, find corresponding Roman character. 
        // 1994 % 1000, get 994, 994/100, get 9 
        return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
    }
}
//Example 5:
//
//Input: 1994
//Output: "MCMXCIV"
//Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
//Tags: Math, String
//
//思路
//题意是整型数转罗马数字，范围从 1 到 3999，查看下百度百科的罗马数字介绍如下：
//
//相同的数字连写，所表示的数等于这些数字相加得到的数，如 Ⅲ=3；
//
//小的数字在大的数字的右边，所表示的数等于这些数字相加得到的数，如 Ⅷ=8、Ⅻ=12；
//
//小的数字（限于 Ⅰ、X 和 C）在大的数字的左边，所表示的数等于大数减小数得到的数，如 Ⅳ=4、Ⅸ=9。
//
//那么我们可以把整数的每一位分离出来，让其每一位都用相应的罗马数字位表示，最终拼接完成。
//比如 621 我们可以分离百、十、个分别为 6、2、1，那么 600 对应的罗马数字是 DC，20 
//对应的罗马数字是 XX，1 对应的罗马数字是 I，所以最终答案便是 DCXXI。
