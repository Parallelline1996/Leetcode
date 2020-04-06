/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/4/6 16:42
 */

package page2;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/
 *
 * Given an input string, reverse the string word by word.
 *
 * Example 1:
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 *
 * Example 2:
 * Input: "  hello world!  "
 * Output: "world! hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 *
 * Example 3:
 * Input: "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 * Note:
 *     A word is defined as a sequence of non-space characters.
 *     Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 *     You need to reduce multiple spaces between two words to a single space in the reversed string.
 */
public class N151_ReverseWordsinaString {

    public String reverseWords(String s) {
        // trim：先除去开头跟结尾的空格
        String[] strings = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            // 用长度除去各个为空的结果
            if (strings[i].length() > 0) {
                // 由于上面已经除去了结尾的空格，因此最后一个一定为非空
                sb.append(strings[i]).append(i == 0? "": " ");
            }
        }
        return sb.toString();
    }

    public String reverseWords1(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        int begin = -1;
        ArrayList<String> lists = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (begin == -1 && s.charAt(i) != ' ') {
                begin = i;
            } else if (begin != -1 && s.charAt(i) == ' ') {
                lists.add(s.substring(begin, i));
                begin = -1;
            }
        }

        if (begin != -1) {
            lists.add(s.substring(begin));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < lists.size(); i++) {
            sb.append(lists.get(lists.size() - i));
            sb.append(" ");
        }
        if (lists.size() > 0) {
            sb.append(lists.get(0));
        }
        return sb.toString();
    }
}
