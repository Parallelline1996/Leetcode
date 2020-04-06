/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/4/6 17:25
 */

package page4;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.
 *
 * Example 1:
 * Input: "hello"
 * Output: "holle"
 *
 * Example 2:
 * Input: "leetcode"
 * Output: "leotcede"
 *
 * Note:
 * The vowels does not include the letter "y".
 */
public class N345_ReverseVowelsofaString {

    public String reverseVowels(String s) {
        int l = 0, r = s.length() - 1;
        char[] chars = s.toCharArray();
        while (l < r) {
            while (!isVowel(chars[l]) && l < r) {
                l++;
            }

            while (!isVowel(chars[r]) && l < r) {
                r--;
            }

            if (l < r) {
                exchange(chars, l++, r--);
            }
        }
        return new String(chars);
    }

    private void exchange(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    private boolean isVowel(char c) {
        return c == 'A' || c == 'a' || c == 'E' || c == 'e' ||
                c == 'I' || c == 'i' || c == 'O' || c == 'o' ||
                c == 'U' || c == 'u';
    }
}
