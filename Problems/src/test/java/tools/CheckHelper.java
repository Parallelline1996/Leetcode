/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2023/3/19 14:34
 */

package tools;

public class CheckHelper {

    public static boolean checkObjectArrayEquals(Object[] objects1, Object[] objects2) {
        if (objects1 == null && objects2 == null) {
            return true;
        }

        if (objects1 == null || objects2 == null) {
            return false;
        }

        if (objects1.length != objects2.length) {
            return false;
        }

        for (int i = 0; i < objects1.length; i++) {
            if (!objects1[i].equals(objects2[i])) {
                return false;
            }
        }

        return true;
    }
}
