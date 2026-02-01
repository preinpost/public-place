package leetcode.N350;

import java.util.*;

// 350. Intersection of Two Arrays II
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int n : nums1) {
            set.add(n);
            map1.put(n, map1.getOrDefault(n, 0) + 1);
        }

        for (int n : nums2) {
            set.add(n);
            map2.put(n, map2.getOrDefault(n, 0) + 1);
        }


        for (int n : set) {
            if (!map1.containsKey(n) || !map2.containsKey(n)) continue;

            int cnt = Math.min(map1.get(n), map2.get(n));
            for (int i = 0; i < cnt; i++) {
                list.add(n);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();

    }
}