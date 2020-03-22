/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/3/22 14:43
 */

package page8;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.
 * Return a list of all possible strings we could create.
 * <p>
 * Examples:
 * Input: S = "a1b2"
 * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 * <p>
 * Input: S = "3z4"
 * Output: ["3z4", "3Z4"]
 * <p>
 * Input: S = "12345"
 * Output: ["12345"]
 * <p>
 * Note:
 * <p>
 * S will be a string with length between 1 and 12.
 * S will consist only of letters or digits.
 */
public class N784_LetterCasePermutation {

    public static void main(String[] args) {
        List<String> lists = new N784_LetterCasePermutation().letterCasePermutation("a1b2");
        for (String list : lists) {
            System.out.println(list);
        }
    }

    public List<String> letterCasePermutation1(String S) {
        List<String> output = new ArrayList<>();
        if (S == null || S.length() == 0) {
            return output;
        }
        helper(S.toCharArray(), 0, output);
        return output;
    }

    private void helper(char[] chars, int index, List<String> lists) {
        if (index == chars.length) {
            lists.add(new String(chars));
            return;
        }

        if (Character.isLetter(chars[index])) {
            chars[index] = Character.toLowerCase(chars[index]);
            helper(chars, index + 1, lists);
            chars[index] = Character.toUpperCase(chars[index]);
        }
        helper(chars, index + 1, lists);
    }

    /**
     * too complex
     */
    public List<String> letterCasePermutation(String S) {
        List<String> output = new ArrayList<>();
        if (S == null || S.length() == 0) {
            return output;
        }
        helper(S.toCharArray(), 0, new StringBuilder(), output);
        return output;
    }

    private void helper(char[] chars, int index, StringBuilder sb, List<String> lists) {
        if (index == chars.length) {
            lists.add(sb.toString());
            return;
        }

        if (chars[index] <= '9' && chars[index] >= '0') {
            sb.append(chars[index]);
            helper(chars, index + 1, sb, lists);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            if (chars[index] >= 'a') {
                chars[index] = (char) (chars[index] - 'a' + 'A');
            }
            sb.append((char) (chars[index] + 'a' - 'A'));
            helper(chars, index + 1, sb, lists);
            sb.deleteCharAt(sb.length() - 1);

            sb.append(chars[index]);
            helper(chars, index + 1, sb, lists);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
