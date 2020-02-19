/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/2/19 23:03
 */

package page1;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 *
 * Given a string containing digits from 2-9 inclusive,
 * return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 *
 * Example:
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class N17_LetterCombinationsOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return list;
        }
        letterCombinations(digits, new char[digits.length()], list);
        return list;
    }

    private void letterCombinations(String digits, char[] chars, List<String> list) {
        if (digits.length() == 0) {
            list.add(new String(chars));
            return;
        }
        char[] values = change(digits.substring(0, 1));
        for (char a : values
             ) {
            chars[chars.length - digits.length()] = a;
            letterCombinations(digits.substring(1), chars, list);
        }

    }

    private char[] change(String s) {
        switch (s) {
            case "2":
                return new char[]{'a', 'b', 'c'};
            case "3":
                return new char[]{'d', 'e', 'f'};
            case "4":
                return new char[]{'g', 'h', 'i'};
            case "5":
                return new char[]{'j', 'k', 'l'};
            case "6":
                return new char[]{'m', 'n', 'o'};
            case "7":
                return new char[]{'p', 'q', 'r', 's'};
            case "8":
                return new char[]{'t', 'u', 'v'};
            default:
                return new char[]{'w', 'x', 'y', 'z'};
        }
    }
}
