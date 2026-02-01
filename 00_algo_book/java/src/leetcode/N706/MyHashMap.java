package leetcode.N706;

import java.util.Arrays;

public class MyHashMap {

    private int[] store =  new int[10];
    public MyHashMap() {
        Arrays.fill(store, -1);
    }

    public void put(int key, int value) {
        if (store.length < key) {
            int[] tmp = new int[key+5];
            System.arraycopy(store, 0, tmp, 0, store.length);
            System.arraycopy(tmp, 0, store, 0, tmp.length);
        }

        store[key] = value;
    }

    public int get(int key) {
        return store[key];
    }

    public void remove(int key) {
        store[key] = -1;
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1); // The map is now [[1,1]]
        myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
        myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
        myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
        myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
        myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
        myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]
        System.out.println();
    }
}
