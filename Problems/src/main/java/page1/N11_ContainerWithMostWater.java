/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2019/12/7 19:06
 */

package page1;

public class N11_ContainerWithMostWater {

    public static void main(String[] args) {
        int[] num = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new N11_ContainerWithMostWater().maxArea(num) == 49);

        System.out.println(new N11_ContainerWithMostWater().maxArea1(num) == 49);
    }

    private int maxArea(int[] height) {
        int maxArea = 0;
        // 遍历所有情况进行比较求解
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int temp = (j - i) * minHeight(height[i], height[j]);
                if (maxArea < temp) {
                    maxArea = temp;
                }
            }
        }
        return maxArea;
    }

    private int maxArea1(int[] height) {
        int maxArea = 0, start = 0, end = height.length - 1;

        // 直到两个柱子相遇结束
        while (start < end) {
            // 判断当前组合是否取得更大面积
            int temp = (end - start) * minHeight(height[start], height[end]);
            if (temp > maxArea) {
                maxArea = temp;
            }

            // 判断应该移动的柱子
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return maxArea;
    }

    private int minHeight(int a, int b) {
        return a > b ? b : a;
    }
}
