package lecture.L09;

import java.util.*;

public class L0903 {

    static class Person {
        int time;
        char state;

        public Person(int time, char state) {
            this.time = time;
            this.state = state;
        }
    }

    public void solution(int n, List<Person> arr) {

        arr.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.time == o2.time) return o1.state - o2.state;
                return o1.time - o2.time;
            }
        });

        int answer = 0;
        int cnt = 0;
        for (Person person : arr) {
            if (person.state == 'e') {
                cnt--;
            } else {
                cnt++;
            }

            answer = Math.max(answer, cnt);
        }

        System.out.println(answer);

    }

    public static void main(String[] args) {

        L0903 T = new L0903();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        List<Person> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(new Person(in.nextInt(), 's'));
            arr.add(new Person(in.nextInt(), 'e'));
        }

        T.solution(n, arr);
    }
}
