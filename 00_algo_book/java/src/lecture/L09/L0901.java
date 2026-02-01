package lecture.L09;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class L0901 {

    static class Person {
        int height;
        int weight;

        public Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }
    }

    public void solution(int n, ArrayList<Person> arr) {
        arr.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.height - o2.height;
            }
        });

        int answer = n;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (arr.get(i).weight < arr.get(j).weight) {
                    answer--;
                    break;
                }
            }
        }

        System.out.println(answer);

    }

    public static void main(String[] args) {

        L0901 T = new L0901();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        ArrayList<Person> personArrayList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            personArrayList.add(new Person(in.nextInt(), in.nextInt()));
        }

        T.solution(n, personArrayList);
    }
}
