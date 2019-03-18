package ByteDance;

import java.util.*;

public class ThreeSum {

    ArrayList<List<Integer>> arrayList = new ArrayList<List<Integer>>();

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return arrayList;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i ++)
            twoSum(nums, i + 1, -nums[i]);


        return arrayList;
    }

    public void twoSum(int[] nums, int x, int target) {
        int[] newNums = new int[nums.length - x - 1];

        for(int i = 0; i < newNums.length; i ++)
            newNums[i] = target - nums[i + x];
        int iter = 1;
        int i = 0;
        while (i < newNums.length) {
            if (newNums[i] < nums[i + x]) break;
            if (i + x == nums.length - iter) break;
            if (newNums[i] == nums[nums.length - iter]) {
                ArrayList<Integer> arrayList1 = new ArrayList<Integer>();
                arrayList1.add(-target);
                arrayList1.add(nums[i + x]);
                arrayList1.add(newNums[i]);
                if (!arrayList.contains(arrayList1))
                    arrayList.add((List<Integer>)arrayList1.clone());
                ++ i;
                ++ iter;
            }
            else if (newNums[i] > nums[nums.length - iter]) {
                ++ i;
            }
            else {
                ++ iter;
            }

        }

    }
}

