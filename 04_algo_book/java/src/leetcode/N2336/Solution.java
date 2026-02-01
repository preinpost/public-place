package leetcode.N2336;

import java.util.TreeSet;

// 2336. Smallest Number in Infinite Set
class SmallestInfiniteSet {

    TreeSet<Integer> set = new TreeSet<>();
    int curr = 1;

    public SmallestInfiniteSet() {

    }

    public int popSmallest() {
        if (set.size() > 0) {
            if (curr > set.first()) {
                int first = set.first();
                set.remove(first);
                return first;
            }
        }
        return curr++;
    }

    public void addBack(int num) {
        if (curr > num) {
            set.add(num);
        }
    }
}