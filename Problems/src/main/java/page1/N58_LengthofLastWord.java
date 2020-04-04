/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/4/4 15:35
 */

package page1;

/**
 * https://leetcode.com/problems/length-of-last-word/description/
 * <p>
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word (last word means the last appearing word if we loop from left to right) in the string.
 * If the last word does not exist, return 0.
 * <p>
 * Note: A word is defined as a maximal substring consisting of non-space characters only.
 * <p>
 * Example:
 * Input: "Hello World"
 * Output: 5
 */
public class N58_LengthofLastWord {

    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        String[] strings = s.split(" ");
        return strings.length == 0 ? 0 : strings[strings.length - 1].length();
    }
}
