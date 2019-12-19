/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2019/12/13 23:54
 */

package page8;

import java.util.Stack;

public class N739_DailyTemperatures {

    public static void main(String[] args) {
        int[] T = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = new N739_DailyTemperatures().dailyTemperatures2(T);
        for (int i : result
                ) {
            System.out.print(i + "  ");
        }
    }

    /**
     * 用了两个队列，但实际不需要，因为通过数组可以获取值
     */
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        Stack<Integer> valueStack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            while (valueStack.size() > 0 && T[i] > valueStack.peek()) {
                valueStack.pop();
                int tempIndex = indexStack.pop();
                result[tempIndex] = i - tempIndex;
            }
            valueStack.push(T[i]);
            indexStack.push(i);
        }
        return result;
    }

    /**
     * 堆栈的解法
     */
    public int[] dailyTemperatures1(int[] T) {
        int[] result = new int[T.length];
        Stack<Integer> indexStack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            while (indexStack.size() > 0 && T[i] > T[indexStack.peek()]) {
                int tempIndex = indexStack.pop();
                result[tempIndex] = i - tempIndex;
            }
            indexStack.push(i);
        }
        return result;
    }

    public int[] dailyTemperatures2(int[] T) {
        int[] result = new int[T.length];
        for (int i = T.length - 2; i >= 0; i--) {
            if (T[i] < T[i + 1]) {
                result[i] = 1;
            } else {
                for (int j = i + 1; ; j += result[j]) {
                    if (T[i] < T[j]) {
                        result[i] = j - i;
                        break;
                    } else if (result[j] == 0){
                        result[i] = 0;
                        break;
                    }
                }
            }
        }
        return result;
    }
}
