/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/3/28 20:43
 */

package page3;

/**
 * https://leetcode.com/problems/bulls-and-cows/
 * <p>
 * You are playing the following Bulls and Cows game with your friend:
 * You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess,
 * you provide a hint that indicates how many digits in said guess match your secret number exactly
 * in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows").
 * Your friend will use successive guesses and hints to eventually derive the secret number.
 * Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows.
 * <p>
 * Please note that both secret number and friend's guess may contain duplicate digits.
 * <p>
 * Example 1:
 * Input: secret = "1807", guess = "7810"
 * Output: "1A3B"
 * Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
 * <p>
 * Example 2:
 * Input: secret = "1123", guess = "0111"
 * Output: "1A1B"
 * <p>
 * Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.
 * Note: You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.
 */
public class N299_BullsAndCows {

    public String getHint(String secret, String guess) {
        int[] counter = new int[10];

        int bulls = 0, cows = 0;
        for (int i = 0; i < secret.length(); i++) {

            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                counter[secret.charAt(i) - '0']++;
            }
        }

        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) != guess.charAt(i) && counter[guess.charAt(i) - '0'] > 0) {
                counter[guess.charAt(i) - '0']--;
                cows++;
            }
        }

        // StringBuilder faster than String.format
        StringBuilder sb = new StringBuilder();
        sb.append(bulls);
        sb.append("A");
        sb.append(cows);
        sb.append("B");

        return sb.toString();

    }

    /**
     * 9ms 22.14%
     */
    public String getHint1(String secret, String guess) {
        if (secret == null || guess == null || secret.length() != guess.length()) {
            return "0A0B";
        }

        char[] secretChars = secret.toCharArray();
        char[] guessChars = guess.toCharArray();
        int numAa = 0, numBb = 0;

        int[] secretNum = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secretChars[i] == guessChars[i]) {
                numAa++;
            } else {
                secretNum[secretChars[i] - '0']++;
            }
        }

        for (int i = 0; i < guess.length(); i++) {
            if (secretChars[i] != guessChars[i] && secretNum[guessChars[i] - '0'] > 0) {
                secretNum[guessChars[i] - '0']--;
                numBb++;
            }
        }

        // String.format too slow
        return String.format("%dA%dB", numAa, numBb);
    }
}
