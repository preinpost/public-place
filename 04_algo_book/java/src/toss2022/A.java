package toss2022;

public class A {

    /**
     * 멋쟁이 숫자 : 연속으로 3번 나와야함
     * 가장 큰 수만 리턴하되
     * 000이면 => 0이턴
     * 존재하지 않으면 -1
     */

    public static void main(String[] args) {
        A a = new A();

        String s = "123";

        int result = a.solution(s);
        System.out.println("result = " + result);
    }

    public int solution(String s) {
        int cnt = 1;
        int answer = Integer.MIN_VALUE;

        int p1 = 0;
        int p2 = 1;


        while (p1 <= p2) {
            if (p2 >= s.length()) break;

            if (s.charAt(p1) == s.charAt(p2)) {
                cnt++;
                p2++;
            } else {
                cnt = 1;
                p1 = p2;
                p2++;
            }

            if (cnt == 3) {
                cnt = 1;
                answer = Math.max(answer, Integer.parseInt(s.substring(p1, p2)));
                p1 = p2;
                p2++;
            }
        }

        if (answer == Integer.MIN_VALUE) answer = -1;

        return answer;
    }
}
