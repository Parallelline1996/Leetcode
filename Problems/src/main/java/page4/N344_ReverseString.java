/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/3/10 22:04
 */

package page4;

/**
 * https://leetcode.com/problems/reverse-string/
 *
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * You may assume all the characters consist of printable ascii characters.
 *
 * Example 1:
 * Input: ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 *
 * Example 2:
 * Input: ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 */
public class N344_ReverseString {

    public static void main(String[] args) {
        char[] s = new char[]{'h','e','l','l','o'};
        new N344_ReverseString().reverseString(s);
        System.out.println(new String(s));

        s = new char[]{'H','a','n','n','a', 'h'};
        new N344_ReverseString().reverseString(s);
        System.out.println(new String(s));
    }

    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = temp;
        }
    }
}
