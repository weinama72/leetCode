package laioffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import entity.TreeNode;

public class Question03BinaryTreePostorderTraversal {
	
//	Pre Order Traverse
	public List<Integer> preorderTraversal(TreeNode root) {
	    List<Integer> result = new ArrayList<>();
	    //
	    Deque<TreeNode> stack = new ArrayDeque<>();
	    //
	    TreeNode p = root;
	    while(!stack.isEmpty() || p != null) {
	    	//
	        if(p != null) {
	        	//
	            stack.push(p);
	            result.add(p.val);  // Add before going to children
	            p = p.left;
	            //
	        } else {
	            TreeNode node = stack.pop();
	            p = node.right;   
	        }
	    }
	    return result;
	}
	
//	In Order Traverse
	public List<Integer> inorderTraversal(TreeNode root) {
	    List<Integer> result = new ArrayList<>();
	    Deque<TreeNode> stack = new ArrayDeque<>();
	    TreeNode p = root;
	    while(!stack.isEmpty() || p != null) {
	        if(p != null) {
	            stack.push(p);
	            p = p.left;
	        } else {
	            TreeNode node = stack.pop();
	            result.add(node.val);  // Add after all left children
	            p = node.right;   
	        }
	    }
	    return result;
	}
	
	
//	Post Order Traverse
	public List<Integer> postorderTraversal(TreeNode root) {
	    LinkedList<Integer> result = new LinkedList<>();
	    Deque<TreeNode> stack = new ArrayDeque<>();
	    TreeNode p = root;
	    while(!stack.isEmpty() || p != null) {
	        if(p != null) {
	            stack.push(p);
	            result.addFirst(p.val);  // Reverse the process of preorder
	            p = p.right;             // Reverse the process of preorder
	        } else {
	            TreeNode node = stack.pop();
	            p = node.left;           // Reverse the process of preorder
	        }
	    }
	    return result;
	}

}



//
//import java.util.Stack;
//
//import org.junit.Before;
//import org.junit.Test;
//
///**
// * Stack(栈)继承了Vector类，底层实现是数组。 
// * 此处只介绍了Stack自己定义的方法,父类中的方法不再一一介绍。
// */
//public class TestStack {
//
//    // 定义一个栈
//    Stack<String> stack;
//
//    @Before
//    public void before() {
//        // 实例化栈变量
//        stack = new Stack<String>();
//
//        // add方法向栈中添加元素,添加成功返回true
//        stack.add("1");
//        stack.add("2");
//        stack.add("3");
//        stack.add("4");
//        stack.add("5");
//
//        // push方法向栈中添加元素,返回结果是当前添加的元素
//        stack.push("a");
//        stack.push("b");
//        stack.push("c");
//        stack.push("d");
//        stack.push("e");
//
//        // push和add都是向栈中添加元素,底层实现也是一样的,都是先将Vector扩容,再添加
//
//    }
//
//    // pop方法移除并返回栈顶元素，如果是空栈，会抛出异常：EmptyStackException
//    @Test
//    public void test1() {
//        String pop = stack.pop();
//        System.out.println(pop); // e
//        System.out.println(stack); // [1, 2, 3, 4, 5, a, b, c, d]
//    }
//
//    // peek方法获取栈顶元素，但并不移除，如果是空栈，会抛出异常：EmptyStackException
//    @Test
//    public void test2() {
//        String peek = stack.peek();
//        System.out.println(peek); // e
//        System.out.println(stack); // [1, 2, 3, 4, 5, a, b, c, d, e]
//    }
//
//    // empty方法检查栈是否是空栈
//    @Test
//    public void test3() {
//        boolean isEmpty = stack.empty();
//        System.out.println(isEmpty); // false
//    }
//
//    // search方法查看某元素在栈中的位置,计数从1开始
//    @Test
//    public void test4() {
//        int index = stack.search("1");
//        System.out.println(index); // 10
//    }
//
//}
