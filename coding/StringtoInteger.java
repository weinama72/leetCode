package laioffer;

public class StringtoInteger {
	public static int myAtoi(String str) {
	    int index = 0, sign = 1, total = 0;
	    //1. Empty string
	    if(str.length() == 0) return 0;

	    //2. Remove Spaces
	    while(str.charAt(index) == ' ' && index < str.length())
	        index ++;

	    //3. Handle signs
	    if(str.charAt(index) == '+' || str.charAt(index) == '-'){
	        sign = str.charAt(index) == '+' ? 1 : -1;
	        index ++;
	    }
	    
	    //4. Convert number and avoid overflow
	    while(index < str.length()){
	    	//你看 利用ASCII 码比大小,你不用吧具体的码背出来,用差值表示数，就是那个数，比如2.计算机2存在0附近
	        int digit = str.charAt(index) - '0';
	        // 4.1 只要比0小 比9大的 都不是数字,避免了使用正则表达式
	        if(digit < 0 || digit > 9) break;

	        // check if total will be overflow after 10 times and add digit
	        // 因为后边*10，所以提前判断reverse total是否大于最大值／10，如果大于，则max
	        if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
	            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
	        // 这里更巧妙了 因为是从左到右读取 上次的值x10+本次的值 就是current值
	        //value = 10 * value + str.charAt(i) - '0';
	        total = 10 * total + digit;
	        // 
	        index ++;
	    }
	    return total * sign;
	}
	
//	trim后看是不是空
//	第一位是不是有正负 符号
//	接下去位数有没有 str.charAt(i)<'0'||str.charAt(i)>'9'
//	如果是正常数值value=10*value+str.charAt(i)-'0';
//	最后在和integer max/min value
	
//    public static int atoi(String str) {
//        str = str.trim();
//        long value = 0;
//        if (str.equals("")) {
//            return 0;
//        }
//        boolean isPositive = true;
//        for (int i = 0; i < str.length(); i++) {
//            //在第一位的状态下先处理第一位  注意这种写法 很巧妙 逻辑很清晰
//            if (i == 0 && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
//                if (str.charAt(i) == '-') {
//                    isPositive = false;
//                }
//                continue;
//            } //continue的意思是 continue下面的都不执行了 直接进行下一轮循环
//            //你看 利用ASCII 码比大小,你不用吧具体的码背出来
//            //只要比0小 比9大的 都不是数字,避免了使用正则表达式
//            //而且只有string可以用正则，char不可以直接用
//            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
//                break;
//            }
//            //这里更巧妙了 因为是从左到右读取 上次的值x10+本次的值 就是current值
//            //eg：123=  /1/1*10+2/12x10+3 =123
//            value = 10 * value + str.charAt(i) - '0';
//        }
//        if (isPositive == false) {
//            value = value * -1;
//        }
//        if (value > Integer.MAX_VALUE) {
//            return Integer.MAX_VALUE;
//        } else if (value < Integer.MIN_VALUE) {
//            return Integer.MIN_VALUE;
//        } else {
//            return (int) value;
//        }//反正已经在正常int范围内了
//
//    }

    public static void main(String[] args) {
        System.out.print(myAtoi("  -233"));
    }

}