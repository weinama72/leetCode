package laioffer;

public class MergeSort {
    public static void main(String[] args) {
        int unsortedArray[] = new int[] {6, 5, 3, 1, 8, 7, 2, 4};
        mergeSort(unsortedArray);
        System.out.println("After sort: ");
        for (int item : unsortedArray) {
            System.out.println(item + " ");
        }
    }
    private static void mergeSort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int low, int high) {
        if(high <= low) return; // if high is smaller, means done
        int mid = low + (high - low) / 2;
        sort(array, low, mid); // divide array into 2 parts, iterate itself to get sorted array, means single element
        sort(array, mid+1, high);
        merge(array, low, mid, high); // merge sorted array
        
        for (int item : array) {
        	System.out.println(item + " ");
        }
        System.out.println();
    }

    private static void merge(int[] array, int low, int mid, int high) {
        int[] helper = new int[array.length];
        for(int k = low; k <= high; k++) {
            helper[k] = array[k]; // copy array
        }
        int i = low, j = mid + 1;
        for(int k = low; k <= high; k++) {
        	// k means current location
            if (i > mid) {
            	//no item in left part, left is sorted, 说明前边全遍历完了，sorted done, 只有后边需要放入，且是sorted
            	//copy left to array
                array[k] = helper[j];
                j++;
            }
            else if (j > high) {
            	// right is sorted, copy ???
                array[k] = helper[i];
                i++;
            }
            else if (helper[i] > helper[j]) {
            	//i位元素值大于j位， 在右边存入更小的元素
                array[k] = helper[j];
                j++;
            }
            else {
            	//在左边存入更小的元素
                array[k] = helper[i];
                i++;
            }
        }
    }
}
