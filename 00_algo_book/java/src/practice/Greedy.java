package practice;

import java.util.ArrayList;
import java.util.Arrays;

public class Greedy {

    public static void coinFunc(Integer price, ArrayList<Integer> coinList) {
        Integer totalCoinCount = 0;
        Integer coinNum = 0;

        ArrayList<Integer> details = new ArrayList<>();

        for (int index = 0; index < coinList.size(); index++) {
            coinNum = price / coinList.get(index);
            totalCoinCount += coinNum;
            price -= coinNum * coinList.get(index);
            details.add(coinNum);

            System.out.println("coinList = " + coinList.get(index) + "원 : " + coinNum + "개");

        }

        System.out.println("totalCoinCount = " + totalCoinCount);
    }

    public static void main(String[] args) {
        coinFunc(4720, new ArrayList<>(Arrays.asList(500, 100, 50, 1)));

    }
}
