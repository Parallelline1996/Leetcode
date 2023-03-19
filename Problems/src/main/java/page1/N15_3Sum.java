/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2022/3/3 23:25
 */

package page1;

import java.util.*;

public class N15_3Sum {

    public List<List<Integer>> threeSum0(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
        }
        Collections.sort(list);
        Integer[] integers = new Integer[nums.length];
        list.toArray(integers);

        if (integers[0] > 0 || integers[nums.length - 1] < 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> rspList = new ArrayList<>();
        for (int i = 0, j = integers.length - 1; i < j + 1; ) {
            int target = -integers[i] - integers[j];
            if (target < 0) {
                for (int k = i + 1; k < j; k++) {
                    if (integers[k] == target) {
                        List<Integer> rsp = new ArrayList<>();
                        rsp.add(integers[i]);
                        rsp.add(integers[k]);
                        rsp.add(integers[j]);
                        rspList.add(rsp);
                        break;
                    }

                    if (integers[k] > target) {
                        break;
                    }
                }
            } else {
                for (int k = j - 1; k > i; k--) {
                    if (integers[k] == target) {
                        List<Integer> rsp = new ArrayList<>();
                        rsp.add(integers[i]);
                        rsp.add(integers[k]);
                        rsp.add(integers[j]);
                        rspList.add(rsp);
                        break;
                    }

                    if (integers[k] < target) {
                        break;
                    }
                }
            }
        }
        return rspList;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
        }
        Collections.sort(list);
        Integer[] integers = new Integer[nums.length];
        list.toArray(integers);

        if (integers[0] > 0 || integers[nums.length - 1] < 0) {
            return new ArrayList<>();
        }

        Set<String> resultSet = new HashSet<>();
        List<List<Integer>> rspList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (integers[i] > 0) {
                break;
            }
            for (int j = i + 1; j < list.size(); j++) {
                for (int h = list.size() - 1; h > j; h--) {
                    if (integers[h] < 0) {
                        break;
                    }
                    if (integers[i] + integers[j] + integers[h] == 0) {
                        String rspStr = integers[i] + "" + integers[j] + "" + integers[h];
                        if (!resultSet.contains(rspStr)) {
                            List<Integer> rsp = new ArrayList<>();
                            rsp.add(integers[i]);
                            rsp.add(integers[j]);
                            rsp.add(integers[h]);
                            rspList.add(rsp);
                            resultSet.add(rspStr);
                        }
                    }
                }
            }
        }
        return rspList;
    }

    private int[] twoSum(Integer[] nums, int start, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = start; i < nums.length; i++) {
            int remainValue = target - nums[i];
            if (map.containsKey(remainValue)) {
                return new int[]{remainValue, nums[i]};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new N15_3Sum().threeSum0(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
