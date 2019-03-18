package ByteDance;

public class TrappingRainWater {

    public int trap(int[] height) {
        if (height.length == 0) return 0;

        int sum = 0;
        int maxIndex = 0;
        for (int i = 1; i < height.length; i ++) {
            if (height[i] > height[maxIndex])
                maxIndex = i;
        }
        int front = maxIndex;

        while (front > 0) {
            int index = 0;
            for (int i = 0;i < front; i ++) {
                if (height[i] > height[index])
                    index = i;
            }
            int s = 0;
            for (int i = index + 1; i <= front - 1; i ++)
                s += height[i];
            sum += height[index] * (front - index - 1) - s;
            front = index;
        }

        int behind = maxIndex;
        while (behind < height.length - 1) {
            int index = height.length - 1;
            for (int i = height.length - 1; i > behind; i --){
                if (height[i] > height[index])
                    index = i;
            }
            int s = 0;
            for (int i = behind + 1; i <= index - 1; i ++)
                s += height[i];
            sum += height[index] * (index - behind - 1) - s;
            behind = index;
        }
        return sum;
    }

}
