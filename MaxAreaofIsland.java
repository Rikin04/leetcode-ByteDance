package ByteDance;

public class MaxAreaofIsland {
    int max = 0;
    boolean[][] booleans;
    public int maxAreaOfIsland(int[][] grid) {

        if (grid == null || grid.length == 0) return 0;

        booleans = new boolean[grid.length][grid[0].length];
        for (int x = 0; x < grid.length; x ++) {
            for (int y = 0; y < grid[x].length; y ++) {
                if (grid[x][y] == 1 && !booleans[x][y]) {
                    booleans[x][y] = true;
                    bfs(grid, x, y, 0);
                }
            }
        }

        return max;
    }

    public int bfs(int[][] grid, int x, int y, int n) {

        ++ n;
        if (max < n) max = n;

        if (x > 0 && grid[x - 1][y] == 1 && !booleans[x - 1][y]) {
            booleans[x - 1][y] = true;
            n = bfs(grid, x - 1, y, n);
        }
        if (x < grid.length - 1 && grid[x + 1][y] == 1 && !booleans[x + 1][y]) {
            booleans[x + 1][y] = true;
            n = bfs(grid, x + 1, y, n);
        }
        if (y > 0 && grid[x][y - 1] == 1 && !booleans[x][y - 1]) {
            booleans[x][y - 1] = true;
            n = bfs(grid, x, y - 1, n);
        }
        if (y < grid[0].length - 1 && grid[x][y + 1] == 1 && !booleans[x][y + 1]) {
            booleans[x][y + 1] = true;
            n = bfs(grid, x, y + 1, n);
        }
        return n;
    }

}
