package laioffer;

import java.util.ArrayList;
import java.util.List;

//
//}
//
//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//
//For example, given n = 3, a solution set is:
//
//[
//"((()))",
//"(()())",
//"(())()",
//"()(())",
//"()()()"
//]
//Tags: String, Backtracking
//
//思路 0
//题意是给你 n 值，让你找到所有格式正确的圆括号匹配组，题目中已经给出了 n = 3 的所有结果。遇到这种问题，第一直觉就是用到递归或者堆栈，
//我们选取递归来解决，也就是 helper 函数的功能，从参数上来看肯定很好理解了，leftRest 代表还有几个左括号可以用，rightNeed 代表还需要几个右括号才能匹配，
//初始状态当然是 rightNeed = 0, leftRest = n，递归的终止状态就是 rightNeed == 0 && leftRest == 0，也就是左右括号都已匹配完毕，然后把 str 加入到链表中即可。
//
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class GenerateParentheses {
//
//    public List<String> generateParenthesis(int n) {
//    	// 1. create a list to save result
//        List<String> list = new ArrayList<>();
//        // 2. create a helper to do backtracking
//        helper(list, "", 0, n);
//        // 3. return result
//        return list;
//    }
//    // list is result, str is input params, rightNeed is how many right parentheses do we need, leftRest  is how many right parentheses do we have
//    private void helper(List<String> list, String str, int rightNeed, int leftRest) {
//    	// 2.1 if right and left  equal to 0, 匹配完毕，means finished, add str to list and return result list.
//        if (rightNeed == 0 && leftRest == 0) {
//            list.add(str);
//            return;
//        }
//        // 2.2 If rightNeed >0,  
//        if (rightNeed > 0) helper(list, str + ")", rightNeed - 1, leftRest);
//        if (leftRest > 0) helper(list, str + "(", rightNeed + 1, leftRest - 1);
//    }
//}


//思路：向string 中插入( 和 )，每插入一个就减1。 那么如何保证这个combination 是正确的呢？
//
//插入数量不超过n
//
//可以插入 ） 的前提是 ( 的数量大于 ）
//
//所以就得到了递归的两个条件。

// left stands for the remaining number of (, right stands for the remaining number of ).
public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		// 1. create a list to save result
	    ArrayList<String> result = new ArrayList<String>();
	    // 2. create a helper to do backtracking
	    dfs(result, "", n, n);
	    // 3. return result
	    return result;
	}

	// left and right represents the remaining number of ( and ) that need to be added. 
	public void dfs(ArrayList<String> result, String s, int left, int right){
		//2.1 When left > right, there are more ")" placed than "(". Such cases are wrong and the method stops. 
	    if(left > right)
	        return;
	    // 2.2 if right and left  equal to 0, 匹配完毕，means finished, add str to list and return result list.
	    if(left==0&&right==0){
	        result.add(s);
	        return;
	    }
	    // left>0, add more (, left-1
	    if(left>0){
	        dfs(result, s+"(", left-1, right);
	    }
	    // right>0, add more ), right-1
	    if(right>0){
	        dfs(result, s+")", left, right-1);
	    }
	}
}