/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2023/3/25 10:53
 */

package page5;

import org.junit.Test;

import static org.junit.Assert.*;

public class N409_LongestPalindromeTest {

    // * Example 1:
    // * Input: s = "abccccdd"
    // * Output: 7

    // * Example 2:
    // * Input: s = "a"
    // * Output: 1

    private N409_LongestPalindrome handler = new N409_LongestPalindrome();


    @Test
    public void testExample() {
        assertEquals(7, handler.longestPalindrome("abccccdd"));
        assertEquals(1, handler.longestPalindrome("1"));
        assertEquals(1, handler.longestPalindrome("Aa"));
        assertEquals(6, handler.longestPalindrome("aabbcc"));
        assertEquals(7, handler.longestPalindrome("aabbccc"));
        assertEquals(7, handler.longestPalindrome("aabbcdc"));
    }
}