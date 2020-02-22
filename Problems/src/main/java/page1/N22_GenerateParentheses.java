/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/2/22 11:26
 */

package page1;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class N22_GenerateParentheses {

    public static void main(String[] args) {
        List<String> list = new N22_GenerateParentheses().generateParenthesis(3);
        for (String s : list
             ) {
            System.out.println(s);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generateParenthesis(1, 0, n, "(", list);
        return list;
    }

    private void generateParenthesis(int numLeft, int numRight, int n, String s, List<String> lists) {
        if (numLeft < numRight || numLeft > n) {
            return;
        }

        if (numLeft == numRight && numLeft == n) {
            lists.add(s);
            return;
        }

        generateParenthesis(numLeft + 1, numRight, n, s + "(", lists);
        generateParenthesis(numLeft, numRight + 1, n, s + ")", lists);
    }
}
