/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2022/2/23 21:54
 */

package page11;

/**
 * https://leetcode.com/problems/number-of-enclaves/
 * <p>
 * You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.
 * A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.
 * Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.
 * <p>
 * Example 1:
 * Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
 * Output: 3
 * Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.
 * <p>
 * Example 2:
 * Input: grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
 * Output: 0
 * Explanation: All 1s are either on the boundary or can reach the boundary.
 * <p>
 * Constraints:
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 500
 * grid[i][j] is either 0 or 1.
 */
public class N1020_NumberOfEnclaves {

    // 整体思路：
    // 从四边进行遍历，将四边上所有可连接的点进行dfs遍历，将找到的点都置为0（标记为可达）
    // 最后计算还剩下多少个1（多少个不可达的陆地）

    // 4ms 91.9%
    // 直接将地点置为0，减少新增的开销
    public int numEnclaves0(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        // 查看最上一行跟最下一行所有点
        for (int i = 0; i < grid[0].length; i++) {
            count(grid, 0, i);
            count(grid, grid.length - 1, i);
        }

        // 查看最左一行跟最右一行所有点
        for (int i = 1; i < grid.length - 1; i++) {
            count(grid, i, 0);
            count(grid, i, grid[0].length - 1);
        }

        int num = 0;
        for (int i = 0; i < grid.length - 1; i++) {
            for (int j = 0; j < grid[0].length - 1; j++) {
                if (grid[i][j] == 1) {
                    num++;
                }
            }
        }
        return num;
    }

    // dfs
    private void count(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return;
        }

        grid[i][j] = 0;
        count(grid, i + 1, j);
        count(grid, i - 1, j);
        count(grid, i, j + 1);
        count(grid, i, j - 1);
    }

    // 5ms 82.10%
    // 新增arrive[][]来记录可否到达的状态
    public int numEnclaves(int[][] grid) {
        boolean[][] arrive = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < arrive[0].length; i++) {
            build(arrive, grid, 0, i);
            build(arrive, grid, arrive.length - 1, i);
        }

        for (int i = 1; i < arrive.length - 1; i++) {
            build(arrive, grid, i, 0);
            build(arrive, grid, i, arrive[0].length - 1);
        }

        int num = 0;
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[0].length - 1; j++) {
                if (grid[i][j] == 1 && !arrive[i][j]) {
                    num++;
                }
            }
        }
        return num;
    }

    private void build(boolean[][] arrive, int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= arrive.length || j >= arrive[0].length) {
            return;
        }

        if (grid[i][j] == 0 || arrive[i][j]) {
            return;
        }

        arrive[i][j] = true;
        build(arrive, grid, i + 1, j);
        build(arrive, grid, i - 1, j);
        build(arrive, grid, i, j + 1);
        build(arrive, grid, i, j - 1);
    }

    public static void main(String[] args) {
        // 3
        System.out.println(new N1020_NumberOfEnclaves().numEnclaves0(
                new int[][]{{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}}
        ));

        // 0
        System.out.println(new N1020_NumberOfEnclaves().numEnclaves0(
                new int[][]{{0, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}}
        ));

        // 3
        System.out.println(new N1020_NumberOfEnclaves().numEnclaves0(
                new int[][]{
                        {0, 0, 0, 1, 1, 1, 0, 1, 0, 0},
                        {1, 1, 0, 0, 0, 1, 0, 1, 1, 1},
                        {0, 0, 0, 1, 1, 1, 0, 1, 0, 0},
                        {0, 1, 1, 0, 0, 0, 1, 0, 1, 0},
                        {0, 1, 1, 1, 1, 1, 0, 0, 1, 0},
                        {0, 0, 1, 0, 1, 1, 1, 1, 0, 1},
                        {0, 1, 1, 0, 0, 0, 1, 1, 1, 1},
                        {0, 0, 1, 0, 0, 1, 0, 1, 0, 1},
                        {1, 0, 1, 0, 1, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 1, 0, 0, 0, 1}}
        ));

        // 12
        System.out.println(new N1020_NumberOfEnclaves().numEnclaves0(
                new int[][]{
                        {1, 1, 0, 0, 1, 1, 0, 1, 0, 0},
                        {0, 0, 0, 1, 0, 0, 1, 0, 1, 0},
                        {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {1, 0, 0, 1, 0, 0, 0, 1, 1, 0},
                        {1, 0, 0, 1, 0, 1, 0, 0, 1, 1},
                        {0, 0, 0, 0, 1, 1, 0, 0, 0, 1},
                        {0, 0, 1, 0, 0, 0, 0, 0, 1, 1},
                        {1, 1, 0, 0, 1, 0, 1, 0, 0, 0},
                        {0, 0, 1, 0, 0, 1, 1, 0, 0, 0},
                        {0, 0, 1, 1, 0, 0, 1, 1, 0, 0},
                        {0, 0, 1, 1, 1, 0, 1, 1, 1, 0},
                        {1, 1, 1, 0, 0, 1, 0, 1, 1, 0},
                        {0, 0, 0, 1, 1, 0, 0, 1, 1, 1}
                }));
    }
}
