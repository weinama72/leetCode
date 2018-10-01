package laioffer;

public class binarySearch{
	public static void main(String[] args) {
		int[] nums = new int[] {1, 2, 2, 3, 4, 6, 6, 6, 13, 18};
		System.out.println(binary(nums, 6));
		System.out.println(binary(nums, 11));
	}
    public static int binary(int[] nums, int target){
        if(nums == null && nums.length == 0) return -1;
        
        int start = 0;
        int end = nums.length - 1;
        int mid;
        //1, start < end
        while(start + 1 < end){
            mid = start + (end - start) / 2;
            //mid > tar, 
            if(nums[mid] > target){
                end = mid;
                // mid < tar
            }else if(nums[mid] < target){
                start = mid;
                //mid = tar, ?????    mid >= end?
            }else{
                end = mid;
            }
        }
        if(nums[start] == target){
            return start;
        }
        if(nums[end] == target){
            return end;
        }
        return -1;
    }
}
