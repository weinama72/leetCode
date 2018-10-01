package laioffer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class threeSum {
	public static void main(String[] args) {
		System.out.println("result  is ");
		int Array[] = new int[] {6, 5, 3, 1, 8, 7, 0, -4};
		threeSum1(Array);
		System.out.println(threeSum1(Array));
		// ?????? 如何打印结果
		for (int i : Array) {
			System.out.println(i);
		}
	}
	
	//The idea is to sort an input array and then run through all indices of a possible first element of a triplet.
	//For each possible first element we make a standard bi-directional 2Sum sweep of the remaining part of the array. 
	//Also we want to skip equal elements to avoid duplicates in the answer without making a set or smth like that.

	public static List<List<Integer>> threeSum1(int[] num) {
	    Arrays.sort(num);
	    // new a null list
	    List<List<Integer>> res = new LinkedList<>(); 
	    // traverse from 0 to the third last element
	    for (int i = 0; i < num.length-2; i++) {
	    	// i = 0 or i > 0 and no duplicate elements, if duplicate, break, and next loop, 0 = 1??
	    	// -6 , -3 -1 -5 9. 第一位怎样都要进入循环找，-3 low 最小，9 最大。第二位和第一位可能重复，判断，如果不重复就进入循环找
	        if (i == 0 || (i > 0 && num[i] != num[i-1])) {
	        	// two sum for rest 2 element, result == - first element
	            int lo = i+1, hi = num.length-1, sum = 0 - num[i];
	            // while second element less than third element, 3 conditions
	            while (lo < hi) {
	            	//1. [2]+[3] = -[1]
	                if (num[lo] + num[hi] == sum) {
	                	// rest add 3 element
	                    res.add(Arrays.asList(num[i], num[lo], num[hi]));
	                    // if 111 333, we need 4. duplicate elements satisfy 4. continue to next loop, low duplicate, 
	                    // move low to right
	                    while (lo < hi && num[lo] == num[lo+1]) lo++;
	                    while (lo < hi && num[hi] == num[hi-1]) hi--;
	                    lo++; hi--;
	                    // [2]+[3] < -[1], increase lo == move lo to right, ++ , why high is largest at that time??
	                } else if (num[lo] + num[hi] < sum) lo++;
	                // [2]+[3] > -[1], decrease hi == move hi to left.
	                else hi--;
	           }
	        }
	    }
	    return res;
	}

}


