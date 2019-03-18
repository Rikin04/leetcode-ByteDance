package ByteDance;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) {
            if (nums[0] == target) return 0;
            else return -1;
        }
        if (nums[nums.length - 1] > nums[0])
            return Search(nums, 0, nums.length - 1, target);
        int maxIndex = 0;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid < nums.length - 1 && nums[mid + 1] < nums[mid]) {
                maxIndex = mid;
                break;
            }
            if (nums[mid] >= nums[0]) {
                low = mid + 1;
            }
            else if (nums[mid] < nums[0]) {
                high = mid - 1;
            }
        }
        int index = -1;
        if (nums[maxIndex] >= target) {
            if (target >= nums[0]) {
                index = Search(nums, 0, maxIndex, target);
            }
            else {
                index = Search(nums, maxIndex + 1, nums.length - 1, target);
            }
        }
        return index;
    }

    public int Search(int[] num, int x, int y, int target) {
        int x1 = x, y1 = y;
        while (x1 <= y1) {
            int mid = x1 + (y1 - x1) / 2;
            if (num[mid] == target) return mid;
            else if (num[mid] < target)
                x1 = mid + 1;
            else
                y1 = mid - 1;
        }
        return -1;
    }

}
