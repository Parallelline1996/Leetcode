/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/4/25 0025 11:22
 */

package page1;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/n-queens-ii/description/
 *
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 *
 * Example:
 *
 * Input: 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
 * [
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
 */
public class N52_N_QueensII {

    private int number = 0;

    public int totalNQueens(int n) {
        if (n <= 1) {
            return n;
        }
        solveNQueens(new boolean[n][n], 1, n);
        return number;
    }

    /**
     * @param map record the queue`s place
     * @param n which row
     * @param total total row
     */
    private void solveNQueens(boolean[][] map, int n, int total) {
        if (n > total) {
            number++;
            return;
        }

        for (int i = 1; i <= total; i++) {
            // turn to index
            if (placeQueen(map, n - 1, i - 1)) {
                map[n - 1][i - 1] = true;
                solveNQueens(map, n + 1, total);
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
}
