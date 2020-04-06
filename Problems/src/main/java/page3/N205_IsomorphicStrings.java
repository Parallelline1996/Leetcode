/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/4/6 17:37
 */

package page3;

/**
 * https://leetcode.com/problems/isomorphic-strings/
 *
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character but a character may map to itself.
 *
 * Example 1:
 * Input: s = "egg", t = "add"
 * Output: true
 *
 * Example 2:
 * Input: s = "foo", t = "bar"
 * Output: false
 *
 * Example 3:
 * Input: s = "paper", t = "title"
 * Output: true
 */
public class N205_IsomorphicStrings {

    /**
     * 4ms
     */
    public boolean isIsomorphic(String s, String t) {
        int[] is = new int[256];
        int[] it = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (is[s.charAt(i)] != it[t.charAt(i)]) {
                return false;
            }
            is[s.charAt(i)] = it[t.charAt(i)] = i + 1;
        }
        return true;
    }
}
