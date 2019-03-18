package ByteDance;

import java.util.*;

public class FriendCircles {
    public int findCircleNum(int[][] M) {
        int[] Circles = new int[M.length];
        for (int i = 0; i < Circles.length; i ++)
            Circles[i] = i + 1;
        Set<Integer> set = new HashSet<Integer>();
        for (int x = 0; x < M.length; x ++) {
            for (int y = 0; y < M[x].length; y ++) {
                if (M[x][y] == 1) {
                    if (Circles[x] <= Circles[y]) {
                        for (int i = 0; i < Circles.length; i ++)
                            if (Circles[y] == Circles[i])
                                Circles[i] = Circles[x];
                    }
                    else if (Circles[x] > Circles[y]) {
                        for (int i = 0; i < Circles.length; i ++)
                            if (Circles[x] == Circles[i])
                                Circles[i] = Circles[y];
                    }
                }
            }
        }
        for (int i = 0; i < Circles.length; i ++)
            set.add(Circles[i]);
        return set.size();
    }
}

