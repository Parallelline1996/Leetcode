/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/3/22 15:50
 */

package page2;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 *
 * Example:
 * Input: "aab"
 * Output:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
public class N131_PalindromePartitioning {

    public static void main(String[] args) {
        List<List<String>> lists = new N131_PalindromePartitioning().partition("aab");
        for (List<String> list : lists
             ) {
            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }

         lists = new N131_PalindromePartitioning().partition("efe");
        for (List<String> list : lists
        ) {
            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> output = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return output;
        }
        helper(s.toCharArray(), 0, new ArrayList<>(), output);
        return output;
    }

    private void helper(char[] chars, int index, List<String> list, List<List<String>> output) {
        if (index == chars.length) {
            output.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < chars.length; i++) {
            if (!palindrome(chars, index, i)) {
                continue;
            }

            list.add(new String(chars, index, i - index + 1));
            helper(chars, i + 1, list, output);
            list.remove(list.size() - 1);
        }
    }

    private boolean palindrome(char[] chars, int start, int end) {
        if (start == end) {
            return true;
        }

        while (start < end) {
            if (chars[start++] != chars[end--]) {
                return false;
            }
        }
        return true;
    }
}
