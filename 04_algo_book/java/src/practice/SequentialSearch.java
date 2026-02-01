package practice;

import java.util.ArrayList;

public class SequentialSearch {

    public int searchFunc(ArrayList<Integer> dataList, Integer searchItem) {
        for (int index = 0; index < dataList.size(); index++) {
            if (dataList.get(index) == searchItem) {
                return index;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        ArrayList<Integer> testData = new ArrayList<>();
        for(int i = 0;i< 100; i++) {
            testData.add((int)(Math.random() * 100));
        }

        System.out.println("testData = " + testData);

        SequentialSearch sequentialSearch = new SequentialSearch();
        int i = sequentialSearch.searchFunc(testData, 33);
        System.out.println("i = " + i);
    }


}
