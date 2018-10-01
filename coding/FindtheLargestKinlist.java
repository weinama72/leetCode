package laioffer;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class FindtheLargestKinlist {

    public static int findKLargest(int k, ArrayList<Integer> list) {
        if (k < 1 || list == null || list.size() < 1) {
            return -1;
        }
        // list存初始所有元素
        // priorityqueue 存的结果，有k个元素，k-。。。如k=4，则
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k);
        int i = 0;
        for (i = 0; i < k; i++) {
        	//加入4个元素，从list里，无论顺序，放入最小堆，都会从小到达
            heap.add(list.get(i));
        }

        while (i < list.size()) {
        	//如果list里某个元素小于最小堆的最小值，什么也不做
        	//peek():  我们可以直接返回最大节点elements??
            if (list.get(i) <= heap.peek()) {
            } else {
            	//如果7大于最小值1，pop出1，将7加入，循环
            	//每次poll()出最小的数???
                heap.poll();
                heap.add(list.get(i));
            }
            i++;

        }
        //返回heap中最小值
        return heap.peek();
    }

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(26);
        list.add(17);
        list.add(7);
        list.add(3);
        list.add(2);
        list.add(11);
        list.add(2);
        list.add(1);
        list.add(1);
        list.add(9);
        list.add(8);
        list.add(7);
        System.out.print(findKLargest(1, list));


    }
}
