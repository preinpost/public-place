package programmers.kakao.blind2022;

public class K진수에서소수개수구하기 {

    public static void main(String[] args) {

        K진수에서소수개수구하기 T = new K진수에서소수개수구하기();

        int n, k;
        n = 437674;
        k = 3;

        System.out.println(T.solution(n, k));
    }

    public int solution(int n, int k) {
        int answer = 0;

        StringBuilder sb = new StringBuilder();

        while (n >= k) {
            int mod = n % k;
            sb.append(mod);
            n = n / k;
        }

        sb.append(n);

        String convertedString = sb.reverse().toString();

        String[] split = convertedString.split("0");
        for (String s : split) {
            if (s.equals("") || s.equals("1")) continue;

            if (isPrime(s)) answer++;
        }



        return answer;
    }

    public boolean isPrime(String s) {
        long parsed = Long.parseLong(s);

        for (int i = 2; i <= Math.sqrt(parsed); i++) {
            if (parsed % i == 0) return false;
        }
        return true;
    }
}
