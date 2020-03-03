/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/3/3 22:16
 */

package page5;

import java.util.*;

/**
 * https://leetcode.com/problems/sort-characters-by-frequency/
 * <p>
 * Given a string, sort it in decreasing order based on the frequency of characters.
 * <p>
 * Example 1:
 * Input:
 * "tree"
 * Output:
 * "eert"
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * <p>
 * Example 2:
 * Input:
 * "cccaaa"
 * Output:
 * "cccaaa"
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * <p>
 * Example 3:
 * Input:
 * "Aabb"
 * Output:
 * "bbAa"
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 */
public class N451_SortCharactersByFrequency {

    public static void main(String[] args) {
        System.out.println(new N451_SortCharactersByFrequency().frequencySort("tree"));
        System.out.println(new N451_SortCharactersByFrequency().frequencySort("cccaaa"));
        System.out.println(new N451_SortCharactersByFrequency().frequencySort("Aabb"));
    }

    public String frequencySort(String s) {
        int[] chars = new int[256];
        for (char c : s.toCharArray()
        ) {
            chars[c]++;
        }

        ArrayList<Pair> list = new ArrayList<>();
        for (char c = 0; c < 256; c++) {
            if (chars[c] != 0) {
                list.add(new Pair(c, chars[c]));
            }
        }
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for (Pair pair : list
        ) {
            for (int i = 0; i < pair.num; i++) {
                sb.append(pair.c);
            }
        }
        return sb.toString();
    }

    private class Pair implements Comparable<Pair> {

        public char c;
        public int num;

        public Pair(char c, int num) {
            this.c = c;
            this.num = num;
        }

        @Override
        public int compareTo(Pair another) {
            return another.num - this.num;
        }
    }

    /**
     * 18ms
     */
    public String frequencySort1(String s) {
        Map<Character, Integer> map = new HashMap<>(s.length());
        for (char a : s.toCharArray()
        ) {
            if (map.containsKey(a)) {
                map.put(a, map.get(a) + 1);
            } else {
                map.put(a, 1);
            }
        }

        TreeMap<Integer, String> treeMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (Map.Entry<Character, Integer> m : map.entrySet()
        ) {
            if (treeMap.containsKey(m.getValue())) {
                StringBuilder sb = new StringBuilder();
                sb.append(treeMap.get(m.getValue()));
                for (int i = 0; i < m.getValue(); i++) {
                    sb.append(m.getKey());
                }
                treeMap.put(m.getValue(), sb.toString());
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < m.getValue(); i++) {
                    sb.append(m.getKey());
                }
                treeMap.put(m.getValue(), sb.toString());
            }
        }

        Set<Map.Entry<Integer, String>> set = treeMap.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator = set.iterator();
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            sb.append(entry.getValue());
        }
        return sb.toString();
    }
}
