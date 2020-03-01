/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2019/12/18 23:00
 */

package page7;

/**
 * https://leetcode.com/problems/palindromic-substrings/
 *
 * Given a string, your task is to count how many palindromic substrings in this string.
 * The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
 *
 * Example 1:
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 *
 * Example 2:
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 *
 * Note:
 *
 *     The input string length won't exceed 1000.
 */
public class N647_PalindromicSubstrings {

    public static void main(String[] args) {
        System.out.println(new N647_PalindromicSubstrings().countSubstrings("abbbba"));
        System.out.println(new N647_PalindromicSubstrings().countSubstrings("aaa"));
        System.out.println(new N647_PalindromicSubstrings().countSubstrings("abc"));
        System.out.println(new N647_PalindromicSubstrings().countSubstrings("a"));

        System.out.println(new N647_PalindromicSubstrings().countSubstrings1("abbbba"));
        System.out.println(new N647_PalindromicSubstrings().countSubstrings1("aaa"));
        System.out.println(new N647_PalindromicSubstrings().countSubstrings1("abc"));
        System.out.println(new N647_PalindromicSubstrings().countSubstrings1("a"));
    }

    public int countSubstrings(String s) {
        int num = 0;
        char[] a = s.toCharArray();
        // 注意，这里需根据子串长度的奇偶分两种情况
        for (int i = 0; i < s.length(); i++) {
            num += count(a, i, i);
            num += count(a, i, i + 1);
        }
        return num;
    }

    private int count(char[] a, int left, int right) {
        int num = 0;
        // 当某个子串是回文子串时，向左右两侧扩展，直至不再是回文子串或超过数据越界
        while (left >= 0 && right < a.length && a[left] == a[right]) {
            num++;
            left--;
            right++;
        }
        return num;
    }

    public int countSubstrings1(String s) {
        if (s == null) {
            return 0;
        }
        int num = 0;
        // dp[i][j]为true代表：以下标i为起点，下标j为终点的子串为回文子串
        boolean dp[][] = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && ((j - i <= 2) || (dp[i + 1][j - 1]))) {
                    dp[i][j] = true;
                    num++;
                }
            }
        }
        return num;
    }
    //dp[i,j] means whether substring (i,j) of s is a palindrome
}
