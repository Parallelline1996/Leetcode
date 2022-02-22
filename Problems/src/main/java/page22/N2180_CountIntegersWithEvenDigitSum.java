/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2022/2/22 23:49
 */

package page22;

/**
 * https://leetcode.com/problems/count-integers-with-even-digit-sum/
 * <p>
 * Given a positive integer num, return the number of positive integers less than or equal to num whose digit sums are even.
 * The digit sum of a positive integer is the sum of all its digits.
 * <p>
 * Example 1:
 * Input: num = 4
 * Output: 2
 * Explanation:
 * The only integers less than or equal to 4 whose digit sums are even are 2 and 4.
 * <p>
 * Example 2:
 * Input: num = 30
 * Output: 14
 * Explanation:
 * The 14 integers less than or equal to 30 whose digit sums are even are
 * 2, 4, 6, 8, 11, 13, 15, 17, 19, 20, 22, 24, 26, and 28.
 */
public class N2180_CountIntegersWithEvenDigitSum {

    public int countEven(int num) {
        int result = 0;
        for (int i = 2; i <= num; i++) {
            if (isFit0(i)) {
                result++;
            }
        }
        return result;
    }

    // 1ms 93.19%
    private boolean isFit0(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum % 2 == 0;
    }

    // 15ms
    private boolean isFit(int num) {
        String numStr = Integer.toString(num);
        int sum = 0;
        for (int i = 0; i < numStr.length(); i++) {
            sum += Integer.parseInt(numStr.substring(i, i + 1));
        }
        return sum % 2 == 0;
    }

    // 0ms 100%
    // For a num with even sum of its digits, count of Integers With Even Digit Sum less than or equal to num is num/2
    // For a num with odd sum of its digits, count of Integers With Even Digit Sum less than or equal to num is (num-1)/2
    public int countEven0(int num) {
        return isFit0(num) ? num / 2 : (num - 1) / 2;
    }

    public static void main(String[] args) {
        System.out.println(new N2180_CountIntegersWithEvenDigitSum().countEven(4));
        System.out.println(new N2180_CountIntegersWithEvenDigitSum().countEven(30));
    }
}
