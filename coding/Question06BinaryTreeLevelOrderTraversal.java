
package laioffer;


// http://www.lintcode.com/zh-cn/problem/binary-tree-level-order-traversal
// 二叉树的层次遍历
// 给出一棵二叉树，返回其节点值的层次遍历（逐层从左往右访问）
//
//           3
//          / \
//          9  20
//            /  \
//           15   7
//

import entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by anduo on 17-3-14.
 */

//add        增加一个元索                     如果队列已满，则抛出一个IIIegaISlabEepeplian异常
//remove   移除并返回队列头部的元素    如果队列为空，则抛出一个NoSuchElementException异常
//element  返回队列头部的元素             如果队列为空，则抛出一个NoSuchElementException异常
//offer       添加一个元素并返回true       如果队列已满，则返回false
//poll         移除并返问队列头部的元素    如果队列为空，则返回null
//peek       返回队列头部的元素             如果队列为空，则返回null
//put         添加一个元素                      如果队列满，则阻塞
//take        移除并返回队列头部的元素     如果队列为空，则阻塞

//
//public class Question06BinaryTreeLevelOrderTraversal {
//    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
//        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
//        if (root == null) {
//            return result;
//        }
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        //
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            ArrayList<Integer> levels = new ArrayList<>();
//            //
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//            	//
//                TreeNode head = queue.poll();
//                //
//                levels.add(head.val);
//                
//                if (head.left != null) {
//                    queue.offer(head.left);
//                }
//                if (head.right != null) {
//                    queue.offer(head.right);
//                }
//            }
//            
//            result.add(levels);
//        }
//        return result;
//    }
//}


public class Question06BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        
        if(root == null) return wrapList;
        //将root传入
        queue.offer(root);
        
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            //存放当前，
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i<levelNum; i++) {
            	//访问当前root的左右并存入
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                //queue pop出当前root，并在sublist加入当前root，queue留下左右
                subList.add(queue.poll().val);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }
}