package laioffer;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/04/25
 *     desc  :
 * </pre>
 */
public class romanToInteger {
    public int romanToInt(String s) {
    	//1. exceptional
    	if (s == null || s.length() == 0)
    		return -1;
    	//2. hash map as helper 
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int len = s.length();
        // 3. sum is result, get character at last place. 
        int sum = map.get(s.charAt(len - 1));
        // 4. Traversal. 第一次倒数第二位和倒数第一位比，然后倒数第三和倒数第二比，直到。。。
        for (int i = len - 2; i >= 0; --i) {
        	//4.1 当前一位比后一位int小，
            if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
            	// 4.2 sum 减去前一位, sum minus value at index i
                sum -= map.get(s.charAt(i));
            } else {
            	//sum加前一位, sum plus value at index i
                sum += map.get(s.charAt(i));
            }
        }
        // 5. return result
        return sum;
    }

    public static void main(String[] args) {
    	romanToInteger solution = new romanToInteger();
        System.out.println(solution.romanToInt("DCXXI"));// 621
        System.out.println(solution.romanToInt("CCCXLVIII"));// 348
    }
}

//Symbol       Value
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000

// Input: "MCMXCIV"
//Output: 1994
//Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
//Input is guaranteed to be within the range from 1 to 3999.
//public int romanToInt(String s) {
//    int sum=0;
//   if(s.indexOf("IV")!=-1){sum-=2;}
//   if(s.indexOf("IX")!=-1){sum-=2;}
//   if(s.indexOf("XL")!=-1){sum-=20;}
//   if(s.indexOf("XC")!=-1){sum-=20;}
//   if(s.indexOf("CD")!=-1){sum-=200;}
//   if(s.indexOf("CM")!=-1){sum-=200;}
//   
//   char c[]=s.toCharArray();
//   int count=0;
//   
//  for(;count<=s.length()-1;count++){
//      if(c[count]=='M') sum+=1000;
//      if(c[count]=='D') sum+=500;
//      if(c[count]=='C') sum+=100;
//      if(c[count]=='L') sum+=50;
//      if(c[count]=='X') sum+=10;
//      if(c[count]=='V') sum+=5;
//      if(c[count]=='I') sum+=1;
//      
//  }
//  
//  return sum;
//   
//}

//public int romanToInt(String s) {
//    int nums[]=new int[s.length()];
//    for(int i=0;i<s.length();i++){
//        switch (s.charAt(i)){
//            case 'M':
//                nums[i]=1000;
//                break;
//            case 'D':
//                nums[i]=500;
//                break;
//            case 'C':
//                nums[i]=100;
//                break;
//            case 'L':
//                nums[i]=50;
//                break;
//            case 'X' :
//                nums[i]=10;
//                break;
//            case 'V':
//                nums[i]=5;
//                break;
//            case 'I':
//                nums[i]=1;
//                break;
//        }
//    }
//    int sum=0;
//    for(int i=0;i<nums.length-1;i++){
//        if(nums[i]<nums[i+1])
//            sum-=nums[i];
//        else
//            sum+=nums[i];
//    }
//    return sum+nums[nums.length-1];
//}

