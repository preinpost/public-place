package practice;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {


    public static class Split{
        public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
            if (dataList.size() <= 1) {
                return dataList;
            }

            int pivot = dataList.get(0);

            ArrayList<Integer> leftArr = new ArrayList<>();
            ArrayList<Integer> rightArr = new ArrayList<>();

            for (int index = 1; index < dataList.size(); index++) {
                if (dataList.get(index) > pivot) {
                    rightArr.add(dataList.get(index));

                } else {
                    leftArr.add(dataList.get(index));
                }
            }

            ArrayList<Integer> mergedArr = new ArrayList<>();
            mergedArr.addAll(sort(leftArr));
            mergedArr.addAll(Arrays.asList(pivot));
            mergedArr.addAll(sort(rightArr));

            return mergedArr;
        }
    }


    public static void main(String[] args) {
        Integer[] array = {4, 2, 1, 5, 7};
        Split split = new Split();
        ArrayList<Integer> sort = split.sort(new ArrayList<Integer>(Arrays.asList(array)));
        System.out.println("sort.toString() = " + sort.toString());
    }
}
