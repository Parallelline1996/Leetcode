/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/4/24 0024 22:09
 */

package page2;

/**
 * https://leetcode.com/problems/surrounded-regions/
 *
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * Example:
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 *
 * After running your function, the board should be:
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 * Explanation:
 *
 * Surrounded regions shouldn’t be on the border,
 * which means that any 'O' on the border of the board are not flipped to 'X'.
 * Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
 * Two cells are connected if they are adjacent cells connected horizontally or vertically.
 */
public class N130_SurroundedRegions {

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        // 用于标记 O 是否被包围，true 代表不被包围，即可以保留
        boolean[][] check = new boolean[board.length][board[0].length];

        // 对四条边上的字符进行遍历
        for (int i = 0; i < board[0].length; i++) {
            helper(board, check, 0, i);
            helper(board, check, board.length - 1, i);
        }
        for (int i = 1; i < board.length - 1; i++) {
            helper(board, check, i, 0);
            helper(board, check, i, board[0].length - 1);
        }

        // 遍历所有字符，将所有没有被标记的 O，转为 X
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' && !check[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void helper(char[][] board, boolean[][] check, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == 'X' || check[i][j]) {
            return;
        }
        check[i][j] = true;
        helper(board, check, i + 1, j);
        helper(board, check, i - 1, j);
        helper(board, check, i, j + 1);
        helper(board, check, i, j - 1);
    }
}
