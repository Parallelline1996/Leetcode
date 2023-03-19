/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/4/6 17:37
 */

package page3;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/isomorphic-strings/
 * <p>
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character but a character may map to itself.
 * <p>
 * Example 1:
 * Input: s = "egg", t = "add"
 * Output: true
 * <p>
 * Example 2:
 * Input: s = "foo", t = "bar"
 * Output: false
 * <p>
 * Example 3:
 * Input: s = "paper", t = "title"
 * Output: true
 */
public class N205_IsomorphicStrings {

    /**
     * 6ms
     */
    public boolean isIsomorphic(String s, String t) {
        int[] is = new int[128];
        int[] it = new int[128];
        for (int i = 0; i < s.length(); i++) {
            if (is[s.charAt(i)] != it[t.charAt(i)]) {
                return false;
            }
            is[s.charAt(i)] = it[t.charAt(i)] = i + 1;
        }
        return true;
    }

    /**
     * 5ms
     */
    public boolean isIsomorphic1(String s, String t) {
        int[] is = new int[128];
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (is[c] == 0) {
                char tc = t.charAt(i);
                if (set.contains(tc)) {
                    return false;
                }
                set.add(tc);
                is[c] = tc;
            } else if (is[c] != t.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
