package laioffer;

//题意是判断括号匹配是否正确，很明显，我们可以用栈来解决这个问题，
//当出现左括号的时候入栈，当遇到右括号时，判断栈顶的左括号是否何其匹配，
//不匹配的话直接返回 false 即可，最终判断是否空栈即可，
//这里我们可以用数组模拟栈的操作使其操作更快，
//有个细节注意下 top = 1;，从而省去了之后判空的操作和 top - 1 导致数组越界的错误。

public class ValidParentheses {
    public boolean isValid(String s) {
    	// 1. create a stack. char type 从1开始用，而非0 所以加一
        char[] stack = new char[s.length() + 1];
        int top = 1;
        // 2. 要把string 类型变成chararray才能打散遍历
        for (char c : s.toCharArray()) {
        	
        	// 3. if start location  is ( [ {, top++  stack[1]=( or [ or {
            if (c == '(' || c == '[' || c == '{') {
            	//stack[top] = c; top ++; ? top ++ --> top = top + 1
                stack[top++] = c; 
                
                //3.1 if stack[2]= ), stack[1] not equal to (, false
            } else if (c == ')' && stack[--top] != '(') {
                return false;
            } else if (c == ']' && stack[--top] != '[') {
                return false;
            } else if (c == '}' && stack[--top] != '{') {
                return false;
            }
        }
        //  decide whether top == 1 , means return to start, return true 配上了,何种情况
        return top == 1;
    }
}
