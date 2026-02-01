package practice;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {

    public ArrayList<Integer> splitFunc(ArrayList<Integer> dataList) {
        if (dataList.size() <= 1) {
            return dataList;
        }

        int medium = dataList.size() / 2;

        ArrayList<Integer> leftArr = new ArrayList<>();
        ArrayList<Integer> rightArr = new ArrayList<>();

        leftArr = splitFunc(new ArrayList<>(dataList.subList(0, medium))); // 0 부터 medium - 1 인덱스 번호 까지 해당 배열 아이템을 서브 배열로 추출
        rightArr = splitFunc(new ArrayList<>(dataList.subList(medium, dataList.size())));

        // 4, 1, 2, 3, 5, 7, 32, 9, 22, 55, 99

        System.out.println("leftArr = " + leftArr);
        System.out.println("rightArr = " + rightArr);
        System.out.println("==================");

        return mergeFunc(leftArr, rightArr);
    }

    public ArrayList<Integer> mergeFunc(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {
        ArrayList<Integer> mergedList = new ArrayList<>();
        int leftPoint = 0;
        int rightPoint = 0;

        // CASE1 : left/right 둘 다 있을 때
        while (leftList.size() > leftPoint && rightList.size() > rightPoint) {
            if (leftList.get(leftPoint) > rightList.get(rightPoint)) {
                mergedList.add(rightList.get(rightPoint));
                rightPoint += 1;
            } else {
                mergedList.add(leftList.get(leftPoint));
                leftPoint += 1;
            }
        }

        // CASE2 : right 데이터가 없을 때
        while (leftList.size() > leftPoint) {
            mergedList.add(leftList.get(leftPoint));
            leftPoint += 1;
        }

        // CASE3 : left 데이터가 없을 때
        while (rightList.size() > rightPoint) {
            mergedList.add(rightList.get(rightPoint));
            rightPoint += 1;
        }

        return mergedList;
    }



    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        ArrayList<Integer> integers = mergeSort.splitFunc(new ArrayList<>(Arrays.asList(4, 1, 2, 3, 5, 7, 32, 9, 22, 55, 99)));
        System.out.println("integers = " + integers.toString());
    }

}
