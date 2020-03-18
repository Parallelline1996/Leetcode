/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/3/16 22:25
 */

package page1;

/**
 * https://leetcode.com/problems/word-search/
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 *
 * Example:
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 *
 * Constraints:
 *     board and word consists only of lowercase and uppercase English letters.
 *     1 <= board.length <= 200
 *     1 <= board[i].length <= 200
 *     1 <= word.length <= 10^3
 */
public class N79_WordSearch {

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
            return false;
        }

        // Do not repeat definition in loop
        boolean[][] booleans = new boolean[board.length][board[0].length];
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (helper(i, j, booleans, board, words, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean helper(int i, int j, boolean[][] use, char[][] board, char[] word, int index) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || use[i][j] || board[i][j] != word[index]) {
            return false;
        }

        if (index == word.length - 1) {
            return true;
        }

        use[i][j] = true;
        boolean result = helper(i - 1, j, use, board, word, index + 1) ||
                helper(i + 1, j, use, board, word, index + 1) ||
                helper(i, j - 1, use, board, word, index + 1) ||
                helper(i, j + 1, use, board, word, index + 1);
        use[i][j] = false;
        return result;
    }
}
