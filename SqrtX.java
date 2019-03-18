package ByteDance;

public class SqrtX {

    public int mySqrt(int x) {
        if (x == 0) return 0;

        int low = 1, high = x, i = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid == x / mid) {
                i = mid;
                break;
            }
            else if (mid < x / mid) {
                i = mid;
                low = mid + 1;
            }
            else
                high = mid - 1;
        }

        return i;
    }

}
