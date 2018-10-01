package laioffer;

//find the contiguous连续的  subarray within an array (containing at least one number) which has the largest sum.
//
//For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
//the contiguous subarray [4,−1,2,1] has the largest sum = 6. 
//cc 原题 19.7
//因为题目要求找连续子序列 就是说这些要连续的。 
//因为这点，本题目可以一次遍历O（n）就做出来 
//当加到a[i]时候 如果当前sum小于0 就把0-i都扔掉 重新加起
//然后每次当currentSum大于maxSum的时候更新maxSum,这样 在过程当中最大的maxSub就会被保留
// 注意要考虑 只有负数的情况 所以 要先和maxsum判断 在和大于小于0判断
public class MaximumSubarray {

	public int maxSubArray(int[] A) {
		int max = Integer.MIN_VALUE;
		int currentSum = 0;
		for (int i = 0; i < A.length; i++) {
			currentSum = currentSum + A[i];
			if (currentSum > max) {
				max = currentSum;
			}
			if (currentSum < 0) {
				currentSum = 0;
			}
		
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


//
//思路 0
//题意是求数组中子数组的最大和，这种最优问题一般第一时间想到的就是动态规划，我们可以这样想，
//当部分序列和大于零的话就一直加下一个元素即可，并和当前最大值进行比较，如果出现部分序列小于零的情况，
//那肯定就是从当前元素算起。其转移方程就是 dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);，
//由于我们不需要保留 dp 状态，故可以优化空间复杂度为 1，即 dp = nums[i] + (dp > 0 ? dp : 0);。
//
//class Solution {
//    public int maxSubArray(int[] nums) {
//        int len = nums.length, dp = nums[0], max = dp;
//        for (int i = 1; i < len; ++i) {
//            dp = nums[i] + (dp > 0 ? dp : 0);
//            if (dp > max) max = dp;
//        }
//        return max;
//    }
//}
//思路 1
//题目也给了我们另一种思路，就是分治，所谓分治就是把问题分割成更小的，最后再合并即可，
//我们把 nums 一分为二先，那么就有两种情况，一种最大序列包括中间的值，一种就是不包括，也就是在左边或者右边；
//当最大序列在中间的时候那我们就把它两侧的最大和算出即可；当在两侧的话就继续分治即可。
//
//class Solution {
//    public int maxSubArray(int[] nums) {
//        return helper(nums, 0, nums.length - 1);
//    }
//
//    private int helper(int[] nums, int left, int right) {
//        if (left >= right) return nums[left];
//        int mid = (left + right) >> 1;
//        int leftAns = helper(nums, left, mid);
//        int rightAns = helper(nums, mid + 1, right);
//        int leftMax = nums[mid], rightMax = nums[mid + 1];
//        int temp = 0;
//        for (int i = mid; i >= left; --i) {
//            temp += nums[i];
//            if (temp > leftMax) leftMax = temp;
//        }
//        temp = 0;
//        for (int i = mid + 1; i <= right; ++i) {
//            temp += nums[i];
//            if (temp > rightMax) rightMax = temp;
//        }
//        return Math.max(Math.max(leftAns, rightAns), leftMax + rightMax);
//    }
//}