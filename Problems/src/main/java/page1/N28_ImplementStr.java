/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/4/4 15:15
 */

package page1;

/**
 * https://leetcode.com/problems/implement-strstr/description/
 *
 * Implement strStr().
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1:
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 *
 * Example 2:
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 *
 * Clarification:
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 * For the purpose of this problem, we will return 0 when needle is an empty string.
 * This is consistent to C's strstr() and Java's indexOf().
 */
public class N28_ImplementStr {

    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }

        int index = -1;
        char[] sourceChars = haystack.toCharArray();
        char[] needleChars = needle.toCharArray();
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (check(sourceChars, i, needleChars)) {
                index = i;
                break;
            }
        }
        return index;
    }

    private boolean check(char[] source, int sStart, char[] target) {
        for (int i = 0, j = sStart; i < target.length; i++, j++) {
            if (source[j] != target[i]) {
                return false;
            }
        }
        return true;
    }
}
