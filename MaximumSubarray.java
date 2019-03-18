package ByteDance;


public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        return maxSubArray(nums, 0, nums.length - 1);
    }

    public int maxSubArray(int[] nums, int x, int y) {
        if (x > y) return Integer.MIN_VALUE / 2;
        if (x == y)
            return nums[x];

        int center = x + (y - x) / 2;

        int leftMaxSum = maxSubArray(nums, x, center - 1);
        int rightMaxSum = maxSubArray(nums, center + 1, y);

        int leftMax = Integer.MIN_VALUE / 2, leftSum = 0;
        for (int i = center - 1; i >= x; i --) {
            leftSum += nums[i];
            leftMax = Math.max(leftSum, leftMax);
        }

        int rightMax = Integer.MIN_VALUE / 2, rightSum = 0;
        for (int i = center + 1; i <= y; i ++) {
            rightSum += nums[i];
            rightMax = Math.max(rightSum, rightMax);
        }

        int sum = nums[center];
        sum = Math.max(sum, sum + leftMax);
        sum = Math.max(sum, sum + rightMax);

        int tmp = leftMaxSum >= rightMaxSum? leftMaxSum:rightMaxSum;
        return sum >= tmp? sum:tmp;


    }

}



