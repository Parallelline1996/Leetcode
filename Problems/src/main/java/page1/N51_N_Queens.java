/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/4/25 0025 0:19
 */

package page1;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/n-queens/
 *
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement,
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 *
 * Example:
 *
 * Input: 4
 * Output: [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 */
public class N51_N_Queens {

    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }

        List<List<String>> result = new ArrayList<>();
        solveNQueens(result, new boolean[n][n], 1, n);
        return result;
    }

    /**
     * @param result save result
     * @param map record the queue`s place
     * @param n which row
     * @param total total row
     */
    private void solveNQueens(List<List<String>> result, boolean[][] map, int n, int total) {
        // 满足结束条件
        if (n > total) {
            // 在结果中添加路径
            buildMap(result, map);
            return;
        }

        for (int i = 1; i <= total; i++) {
            // turn to index
            if (placeQueen(map, n - 1, i - 1)) {
                // 从选择列表中做选择
                map[n - 1][i - 1] = true;
                solveNQueens(result, map, n + 1, total);
                // 撤销选择
                map[n - 1][i - 1] = false;
            }
        }
    }

    /**
     * @param row index
     * @param col index
     */
    private boolean placeQueen(boolean[][] map, int row, int col) {
        // check the vertical direction
        for (int i = 0; i < row; i++) {
            if (map[i][col]) {
                return false;
            }
        }

        // check the tilt left up direction
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (map[i][j]) {
                return false;
            }
        }

        // check the tilt right up direction
        for (int i = row, j = col; j < map.length && i >= 0; j++, i--) {
            if (map[i][j]) {
                return false;
            }
        }
        return true;
    }

    /**
     * build the result list by map
     */
    private void buildMap(List<List<String>> result, boolean[][] map) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j]) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            list.add(sb.toString());
            sb = new StringBuilder();
        }
        result.add(list);
    }
}
