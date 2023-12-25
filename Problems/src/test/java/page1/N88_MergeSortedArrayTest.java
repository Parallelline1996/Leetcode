package page1;

import org.junit.Assert;
import org.junit.Test;
import tools.CheckHelper;

public class N88_MergeSortedArrayTest {

    private N88_MergeSortedArray handler = new N88_MergeSortedArray();

    @Test
    public void test() {
        // * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        // * Output: [1,2,2,3,5,6]
        check(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3, new int[]{1, 2, 2, 3, 5, 6});

        // * Input: nums1 = [1], m = 1, nums2 = [], n = 0
        // * Output: [1]
        check(new int[]{1}, 1, new int[]{}, 0, new int[]{1});

        // * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
        // * Output: [1]
        check(new int[]{0}, 0, new int[]{1}, 1, new int[]{1});
    }

    private void check(int[] nums1, int m, int[] nums2, int n, int[] result) {
        handler.merge(nums1, m, nums2, n);
        for (int num : nums1) {
            System.out.print(num + " ");
        }
        System.out.println();
        Assert.assertTrue(CheckHelper.checkObjectArrayEquals(result, nums1));
    }
}