/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2022/2/27 21:47
 */

package page8;

/**
 * https://leetcode.com/problems/to-lower-case/
 * <p>
 * Given a string s, return the string after replacing every uppercase letter with the same lowercase letter.
 * <p>
 * Example 1:
 * Input: s = "Hello"
 * Output: "hello"
 * <p>
 * Example 2:
 * Input: s = "here"
 * Output: "here"
 * <p>
 * Example 3:
 * Input: s = "LOVELY"
 * Output: "lovely"
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 100
 * s consists of printable ASCII characters.
 */
public class N709_ToLowerCase {

    // A: 65
    // a: 97
    private String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] <= 'Z' && chars[i] >= 'A') {
                chars[i] = (char) (chars[i] + 32);
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(new N709_ToLowerCase().toLowerCase("fff"));
        System.out.println(new N709_ToLowerCase().toLowerCase("SDFIjfidD"));
        System.out.println(new N709_ToLowerCase().toLowerCase("DdffdD"));
    }
}
