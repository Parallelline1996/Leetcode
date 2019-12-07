/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2019/12/7 21:04
 */

package page1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Given an array of strings, group anagrams together.

 Example:

 Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Output:
 [
 ["ate","eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]

 Note:

 All inputs will be in lowercase.
 The order of your output does not matter.


 */
public class N49_GroupAnagrams {

    public static void main(String[] args) {
        String[] input = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> output = new N49_GroupAnagrams().groupAnagrams2(input);
        for (List<String> list : output
                ) {
            for (String s : list
                    ) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    // 9ms
    private List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> maps = new HashMap<>();
        for (String s : strs
                ) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String temp = new String(chars);
            if (!maps.containsKey(temp)) {
                List<String> list = new ArrayList<>();
                list.add(s);
                maps.put(temp, list);
            } else {
                List<String> list = maps.get(temp);
                list.add(s);
            }
        }
        List<List<String>> lists = new ArrayList<>();
        for (String s : maps.keySet()
                ) {
            lists.add(maps.get(s));
        }
        return lists;
    }

    // 7ms O(N*K*logK)
    private List<List<String>> groupAnagrams1(String[] strs) {
        // 用于进行分类
        HashMap<String, List<String>> maps = new HashMap<>();
        // 用于存放结果
        List<List<String>> output = new ArrayList<>();

        // 遍历每个元素
        for (String s : strs
                ) {
            // 将每个字符串的元素进行排序，排序的结果作为分类的Key
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String temp = new String(chars);

            // 根据Key进行分类
            if (!maps.containsKey(temp)) {
                List<String> list = new ArrayList<>();
                list.add(s);
                maps.put(temp, list);
                output.add(list);
            } else {
                maps.get(temp).add(s);
            }
        }
        return output;
    }

    // 5ms O(N*K)
    private List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<String, List<String>> maps = new HashMap<>();
        List<List<String>> output = new ArrayList<>();
        for (String s : strs
                ) {
            // 该Key值与上面的思路的获取方式不同
            String temp = getString(s);
            if (!maps.containsKey(temp)) {
                List<String> list = new ArrayList<>();
                list.add(s);
                maps.put(temp, list);
                output.add(list);
            } else {
                maps.get(temp).add(s);
            }
        }
        return output;
    }

    // 计算字符串中各个字母出现的次数作为Key值
    private String getString(String s) {
        char[] count = new char[26];
        for (char a : s.toCharArray()
             ) {
            count[a - 'a']++;
        }
        return new String(count);
    }
}
