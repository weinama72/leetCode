package laioffer;

//题目的标签有双指针，是否就可以想到首尾各放一指针，然后根据条件来收缩。
//首先计算一次首尾构成的最大面积，然后分析下该移动哪个指针，如果移动大的那个指针的话，那样只会减小面积，所以我们要移动小的那个指针，
//小的那个指针移动到哪呢？当然是移动到大于之前的值的地方，否则面积不都比之前小么，然后继续更新最大值即可，

//题意是给你 a1, a2, ..., an 这 n 个数，代表 (i, ai) 坐标，让你从中找两个点与 x 轴围成的容器可以容纳最多的水。
//
//不明白的话可以看数据为 1 8 6 2 5 4 8 3 7 所示的图。


public class Q11ContainerWithMostWater {
    public int maxArea(int[] height) {
    	// 1. l :left position in x axis, r: right position in x axis.
        int l = 0, r = height.length - 1;
        // 2. max is result area, h : height
        int max = 0, h = 0;
        // 3. traversal while left < right,
        while (l < r) {
        	// 3.1 calculate area with 首尾组成，get value in array with smaller height
            h = Math.min(height[l], height[r]);
            max = Math.max(max, (r - l) * h);
            // 3.2 while left has smaller height, move l to center, means move to right
            while (height[l] <= h && l < r) ++l;
            // 3.3 while right has smaller height, move l to center, means move to left
            while (height[r] <= h && l < r) --r;
        }
        return max;
    }
}
