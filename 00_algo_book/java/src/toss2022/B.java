package toss2022;

import java.util.stream.IntStream;

public class B {

    /**
     *  적당히 어려운 문제 : 상위 25% 이내의 난이도를 가진 문제 중 가장 쉬운 문제
     *
     */

    public static void main(String[] args) {
        B b = new B();

        int[] levels = new int[] {2147483645, 2147483646, 2147483647};
        int result = b.solution(levels);
        System.out.println("result = " + result);

    }

    public int solution(int[] levels) {
        if (levels.length == 1) return levels[0];
        if (levels.length < 4) return -1;

        int[] sortedArray = IntStream.of(levels).sorted().toArray();
        int cutLine = (int) (levels.length * 0.25);



        return sortedArray[levels.length - cutLine];
    }
}
