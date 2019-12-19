/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2019/12/19 23:12
 */

package page1;

public class N5_LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome_("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome_("cbbd"));
        System.out.println(longestPalindrome_("ccc"));

        System.out.println(new N5_LongestPalindromicSubstring().longestPalindromeUseDp("babad"));
        System.out.println(new N5_LongestPalindromicSubstring().longestPalindromeUseDp("cbbd"));
        System.out.println(new N5_LongestPalindromicSubstring().longestPalindromeUseDp("ccc"));
        System.out.println(new N5_LongestPalindromicSubstring().longestPalindromeUseDp(""));


//        System.out.println(new N5_LongestPalindromicSubstring().longestPalindrome1("babad"));
//        System.out.println(new N5_LongestPalindromicSubstring().longestPalindrome1("babad"));
//        System.out.println(new N5_LongestPalindromicSubstring().longestPalindrome1("cbbd"));
//        System.out.println(new N5_LongestPalindromicSubstring().longestPalindrome1("cbbd"));
//        System.out.println(new N5_LongestPalindromicSubstring().longestPalindrome1("ccc"));
//        System.out.println(new N5_LongestPalindromicSubstring().longestPalindrome1("cccc"));
    }

    /**
     * 动态规划做法
     */
    public String longestPalindromeUseDp(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        char[] a = s.toCharArray();
        int left = 0, right = 0, maxLength = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (a[i] == a[j] && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (j - i > maxLength) {
                        maxLength = j - i;
                        left = i;
                        right = j;
                    }
                }
            }
        }
        return s.substring(left, right + 1);
    }


    private static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        int left = 0, right = 0;
        String oddString = "", evenString = "";
        // 如果回文字串为奇数
        for (int i = 0; i < s.length(); i++) {
            left = i - 1;
            right = i + 1;
            while (check(left, right, s)) {
                left--;
                right++;
            }
            if (oddString.length() < (right - i - 1) * 2 + 1) {
                oddString = s.substring(left + 1, right);
            }
        }

        // 如果回文字串为偶数
        for (int i = 0; i < s.length() - 1; i++) {
            if (!check(i, i + 1, s)) {
                continue;
            }
            left = i - 1;
            right = i + 2;
            while (check(left, right, s)) {
                left--;
                right++;
            }
            if (evenString.length() < (right - i - 1) * 2) {
                evenString = s.substring(left + 1, right);
            }
        }
        return oddString.length() > evenString.length() ? oddString : evenString;
    }

    private static boolean check(int i, int j, String s) {
        return i >= 0 && j < s.length() && s.substring(i, i + 1).equals(s.substring(j, j + 1));
    }

    private static boolean check_(int i, int j, String s) {
        if (i < 0 || j >= s.length()) {
            return false;
        }
        StringBuilder sb = new StringBuilder(s.substring(i, j + 1));
        String temp = sb.reverse().toString();
        return temp.equals(s.substring(i, j + 1));
    }

    // 稍快的解法
    // 节省代码量，可以将判断的部分提成方法，然后传值是偶数的中间值为 “”即可
    private static String longestPalindrome_(String s) {
        if (s == null || s.length() == 0) return "";
        int left = 0, right = 0;
        String oddString = "", evenString = "";
        // 如果回文字串为奇数
        for (int i = 0; i < s.length(); i++) {
            left = i - oddString.length() / 2;
            right = i + oddString.length() / 2;
            // 判断以当前节点为中心，以当前最长长度为长度的字串是否为回文序列
            // 若不是，则无需再对该点进行判断
            if (!check_(left, right, s)) {
                continue;
            }
            while (check(left, right, s)) {
                left--;
                right++;
            }
            if (oddString.length() < (right - i - 1) * 2 + 1) {
                oddString = s.substring(left + 1, right);
            }
        }

        // 如果回文字串为偶数
        for (int i = 0; i < s.length() - 1; i++) {
            if (!check(i, i + 1, s)) {
                continue;
            }
            left = i - evenString.length() / 2;
            right = i + evenString.length() / 2 + 1;
            if (!check_(left, right, s)) {
                continue;
            }
            while (check(left, right, s)) {
                left--;
                right++;
            }
            if (evenString.length() < (right - i - 1) * 2) {
                evenString = s.substring(left + 1, right);
            }
        }
        return oddString.length() > evenString.length() ? oddString : evenString;
    }
}
