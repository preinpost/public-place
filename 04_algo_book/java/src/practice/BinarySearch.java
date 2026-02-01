package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BinarySearch {

    public boolean searchFunc(ArrayList<Integer> dataList, Integer searchItem) {
        if (dataList.size() == 1 && searchItem == dataList.get(0)) {
            return true;
        }
        if (dataList.size() == 1 && searchItem != dataList.get(0)) {
            return false;
        }

        if (dataList.size() == 0) {
            return false;
        }

        int medium = dataList.size() / 2;

        if (searchItem == dataList.get(medium)) {
            return true;
        } else {
            if (searchItem < dataList.get(medium)) {
                return this.searchFunc(new ArrayList<Integer>(dataList.subList(0, medium)), searchItem);
            } else {
                return this.searchFunc(new ArrayList<Integer>(dataList.subList(medium, dataList.size())), searchItem);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] array = {10, 3, 11, 30, 5, 88};
        ArrayList<Integer> testData =new ArrayList<>(Arrays.asList(array));

        Collections.sort(testData);

        System.out.println("testData = " + testData);

        BinarySearch binarySearch = new BinarySearch();
        boolean b = binarySearch.searchFunc(testData, 5);
        System.out.println("b = " + b);

    }
}
