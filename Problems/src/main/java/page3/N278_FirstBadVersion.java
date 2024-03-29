/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2023/3/25 16:19
 */

package page3;

import tools.VersionControl;

/**
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version,all the versions after a bad version are also bad.
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * You are given an API bool isBadVersion(version) which returns whether version is bad.
 * Implement a function to find the first bad version. You should minimize the number of calls to the API.
 * <p>
 * <p>
 * Example 1:
 * Input: n = 5, bad = 4
 * Output: 4
 * Explanation:
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * Then 4 is the first bad version.
 * <p>
 * Example 2:
 * Input: n = 1, bad = 1
 * Output: 1
 * <p>
 * Constraints:
 * 1 <= bad <= n <= 231 - 1
 */
public class N278_FirstBadVersion extends VersionControl {

    public int firstBadVersion(int n) {
        if (isBadVersion(1)) {
            return 1;
        }

        int left = 1, right = n;
        while (right - left > 1) {
            int middle = left + (right - left) / 2;
            if (isBadVersion(middle)) {
                if (!isBadVersion(middle - 1)) {
                    return middle;
                }

                right = middle - 1;
            } else {
                left = middle;
            }
        }
        return right;
    }

    public int firstBadVersion1(int n) {
        int l = 1;
        int r = n;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (isBadVersion(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
