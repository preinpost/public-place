package baek;


import java.io.BufferedReader;
import java.io.InputStreamReader;

// 나머지
public class B10430 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        String s = input();
        String[] arr = s.split(" ");
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);
        int c = Integer.parseInt(arr[2]);

        StringBuffer sb = new StringBuffer();
        sb.append((a + b) % c).append("\n");
        sb.append(((a % c) + (b % c)) % c).append("\n");
        sb.append((a * b) % c).append("\n");
        sb.append((a % c) * (b % c) % c).append("\n");

        System.out.println(sb);
    }

    static private String input() {

        try {
            return bf.readLine();
        } catch (Exception ignored) {
            return "";
        }
    }
}
