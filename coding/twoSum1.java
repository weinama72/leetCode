package laioffer;

//import java.util.HashMap;
//import java.util.Map;
//
//public class twoSum {
//	public static void main(String[] args) {
//		System.out.println("result  is ");
//		int Array[] = new int[] {2,7,11,15};
//		twoSum1(Array,9);
//		System.out.print(twoSum1(Array,9));
//		
////		// ?????? 如何打印结果????????
////		for (int i : twoSum1(Array,9)) {
////			System.out.println(i);
////		}
//	}
//	
//    public static int[] twoSum1(int[] nums, int target) {
//        if (nums == null || nums.length == 0) return null;
//
//        Map<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
//        int index1 = 0, index2 = 0;
//        
//        for (int i = 0; i < nums.length; i++) {
//            
//        	if (hashmap.containsKey(target - nums[i])) {
//                index1 = hashmap.get(target - nums[i]); 
//                System.out.println(index1);
//                index2 = i;
//               System.out.println(index2);
//                return new int[]{index1, index2};
//            } else {
//            	//put unqualified [values, index] to hashmap
//                hashmap.put(nums[i], i);
//            }
//        }
//
//        return null;
//    }
//}
//
//
//
//package com.blankj.easy._001;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/04/21
 *     desc  :
 * </pre>
 */
public class twoSum1 {
//    public int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length; ++i) {
//            for (int j = i + 1; j < nums.length; ++j) {
//                if (nums[i] + nums[j] == target) {
//                    return new int[]{i, j};
//                }
//            }
//        }
//        return null;
//    }
    //
    public int[] twoSum(int[] numbers, int target) {
    	// 1. First, we deal with the exceptional of input as always
    	if (numbers == null || numbers.length == 0) return null;
    	// 2. create result array, which will save 2 index of correct answers.
        int[] result = new int[2];
        // 3. create a helper hashmap
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        // 4. traverse input array
        for (int i = 0; i < numbers.length; i++) {
        	// 6. if for the current number, the right partner number is already stored in the hashmap,
        	// which means it has been traversed before, then we output the index of current number and partner number.
        	
            if (map.containsKey(target - numbers[i])) {
                result[1] = i;
                result[0] = map.get(target - numbers[i]);
                return result;
            } else {
            	//5. for the empty map, there is no correct answer, 
            	//put unqualified [values, index] to hashmap
            	map.put(numbers[i], i);
            	}
        }
        // 7. 
        return result;
    }

    public static void main(String[] args) {
    	twoSum1 solution = new twoSum1();
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(solution.twoSum(nums, target)));
    }
}


//
//这题不难，只需要熟悉hashtable即可。在hashtable里面，key是差，
//value是index。比如例子中的[2,7,11,15],target是9。那么在2的时候就存入7 0，
//下一位找到7的时候，之前有个差值是7，那么就返回7对应的index，0，以及当前这个7的index，就是1。

//public class Solution {
//    public int[] twoSum(int[] nums, int target) {
//        //创建一下数组，要存两个index的数组。
//        int[] result = new int[2];
//        //这里用hashtable也行，看心情。
//        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//        //扫一遍数组，一边扫一边存
//        for(int i = 0; i < nums.length; i++){
//            int cur = nums[i];
//            //这里搞出来个差值，其实差值是在没找到之后添加到map里面的。
//            int toFind = target - cur;
//            //如果发现之前需要这个差值，那就找index。
//            if(map.containsKey(cur)){
//                result[0] = map.get(cur);
//                result[1] = i;
//                return result;
//            }
//            //如果没有，就put到map里面
//            else{
//                map.put(toFind, i);
//            }
//        }
//        return result;
//    }
//}