package baek;

public class B10171 {

    public static void main(String[] args) {
        String head = String.format("%s%5s%s", "\\", "/", "\\");
        String eye = String.format("%2s%3s%2s%s", ")", "(", "'", ")");
        String body = String.format("%s%3s%3s", "(", "/", ")");
        String leg = String.format("%2s%s%s%s%s%s", "\\", "(", "_", "_", ")", "|");
        System.out.println(head);
        System.out.println(eye);
        System.out.println(body);
        System.out.println(leg);

    }
}
