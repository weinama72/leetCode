package laioffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LetterCombinationsOfaPhoneNumber {
	// 0. string array 
    private static String[] map = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
    	//1. exceptional
        if (digits.length() == 0) return Collections.emptyList();
        //2. result list
        List<String> list = new ArrayList<>();
        //3. create helper for backtracking
        helper(list, digits, "");
        //4. return result list
        return list;
    }

    private void helper(List<String> list, String digits, String ans) {
    	// 3.1 if equals, return right answer, ans is 中间结果比如ab  digits=23
        if (ans.length() == digits.length()) {
            list.add(ans);
            return;
        }
        // 3.2 if not equals, calculate map[i], ans = a, len =1, 23, 第一位是3，第0位是2，map[3-2]位
        // map[1]才是,def 对应的3
        for (char c : map[digits.charAt(ans.length()) - '2'].toCharArray()) {
        	//ab + 后一位中的某一元素c
            helper(list, digits, ans + c);
        }
    }
}

//题意是给你按键，让你组合出所有不同结果，首先想到的肯定是回溯了，对每个按键的所有情况进行回溯，回溯的终点就是结果字符串长度和按键长度相同。
//
//```java
//class Solution {
