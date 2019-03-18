package ByteDance;

import java.util.Arrays;
public class KthLargestElementInanArray {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
