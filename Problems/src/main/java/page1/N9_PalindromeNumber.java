/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2022/6/28 22:43
 */

package page1;


/**
 * https://leetcode.com/problems/palindrome-number/
 *
 * Given an integer x, return true if x is palindrome integer.
 * <p>
 * An integer is a palindrome when it reads the same backward as forward.
 * <p>
 * For example, 121 is a palindrome while 123 is not.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * Example 2:
 * <p>
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 * <p>
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * -231 <= x <= 231 - 1
 */
public class N9_PalindromeNumber {

    // 15ms
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        if (x < 10) {
            return true;
        }

        String s = Integer.toString(x);
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    // 9ms 98.42%
    public boolean isPalindrome1(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        if (x < 10) {
            return true;
        }

        int num = 0;
        while (x > num) {
            num = num * 10 + x % 10;
            x = x / 10;
        }
        return x == num || x == num / 10;
    }

    public static void main(String[] args) {
        System.out.println(new N9_PalindromeNumber().isPalindrome(10001));
        System.out.println(new N9_PalindromeNumber().isPalindrome1(10));
        System.out.println(new N9_PalindromeNumber().isPalindrome1(10001));
        System.out.println(new N9_PalindromeNumber().isPalindrome1(10007));
    }
}
