/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/4/4 15:27
 */

package page1;

/**
 * https://leetcode.com/problems/longest-common-prefix/description/
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 *
 * Example 2:
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 * Note:
 * All given inputs are in lowercase letters a-z.
 */
public class N14_LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char a = strs[0].charAt(i);
            for (String s : strs) {
                if (s.length() < i + 1 || s.charAt(i) != a) {
                    return sb.toString();
                }
            }
            sb.append(a);
        }
        return sb.toString();
    }
}
