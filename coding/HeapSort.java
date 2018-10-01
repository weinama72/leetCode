package laioffer;

import java.util.*;

public class HeapSort {
    // sign = 1 ==> min-heap, sign = -1 ==> max-heap
    private void siftDown(int[] nums, int k, int size, int sign) {
        int half = (size >>> 1);
        while (k < half) {
            int index = k;
            // left leaf node search
            int l = (k << 1) + 1;
            if (l < size && (sign * nums[l]) < (sign * nums[index])) {
                index = l;
            }
            // right leaf node search
            int r = l + 1;
            if (r < size && (sign * nums[r]) < (sign * nums[index])) {
                index = r;
            }
            // already heapify
            if (k == index) break;
            // keep the root node the smallest/largest
            int temp = nums[k];
            nums[k] = nums[index];
            nums[index] = temp;
            // adjust next index
            k = index;
        }
    }

    private void heapify(int[] nums, int size, int sign) {
        for (int i = size / 2; i >= 0; i--) {
            siftDown(nums, i, size, sign);
        }
    }

    private void minHeap(int[] nums, int size) {
        heapify(nums, size, 1);
    }

    private void maxHeap(int[] nums, int size) {
        heapify(nums, size, -1);
    }

    public void sort(int[] nums, boolean ascending) {
        if (ascending) {
            // build max heap
            maxHeap(nums, nums.length);
            // heap sort
            for (int i = nums.length - 1; i >= 0; i--) {
                int temp = nums[0];
                nums[0] = nums[i];
                nums[i] = temp;
                // reconstruct max heap
                maxHeap(nums, i);
            }
        } else {
            // build min heap
            minHeap(nums, nums.length);
            // heap sort
            for (int i = nums.length - 1; i >= 0; i--) {
                int temp = nums[0];
                nums[0] = nums[i];
                nums[i] = temp;
                // reconstruct min heap
                minHeap(nums, i);
            }
        }
    }

    public static void main(String[] args) {
        int[] A = new int[]{19, 1, 10, 14, 16, 4, 4, 7, 9, 3, 2, 8, 5, 11};
        HeapSort heapsort = new HeapSort();
        heapsort.sort(A, true);
        for (int i : A) {
            System.out.println(i);
        }
    }
}

//从代码中可以发现堆排最费时间的地方在于构建二叉堆的过程。
//
//上述构建大根堆和小根堆都是自底向上的方法，建堆过程时间复杂度为 O(2N)O(2N), 
//堆化过程(可结合图形分析，最多需要调整的层数为最大深度)时间复杂度为 \log ilogi, 
//故堆排过程中总的时间复杂度为 O(N \log N)O(NlogN).
//
//先看看建堆的过程，画图分析(比如以8个节点为例)可知在最坏情况下，每次都需要调整之前已经成为堆的节点，
//那么就意味着有二分之一的节点向下比较了一次，四分之一的节点向下比较了两次，八分之一的节点比较了三次...
//等差等比数列求和，具体过程可参考下面的链接。