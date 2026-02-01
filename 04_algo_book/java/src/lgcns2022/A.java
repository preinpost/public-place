package lgcns2022;

public class A {

    public static void main(String[] args) {
        A T = new A();

        int[] marbles = new int[]{1, 2, 3, 4, 4};
        T.solution(marbles);

    }

    public int[] solution(int[] marbles) {
        int[] answer = {};

        for (int i = 2; i <= marbles.length; i++) {
            permutation(0, new int[i], marbles, new int[i], i);
        }




        return answer;
    }

    public void permutation(int depth, int[] candid, int[] arr, int[] check, int cnt) {
        if (depth == cnt) {
            // 후보평가
            int half = cnt / 2;

            if (candid.length % 2 == 0) {
                int left1 = add(0, half, candid);
                int right1 = add(half, candid.length, candid);

                if (left1 != right1) return;

                int left2 = add(0, half, candid);
                int right2 = add(half, candid.length, candid);

                if (left2 != right2) return;

                for (int i : candid) {
                    System.out.print(i);
                }
            } else {
                int left = add(0, half, candid);
                int right = add(half + 1, candid.length, candid);

                if (left != right) return;

                for (int i : candid) {
                    System.out.print(i);
                }
            }
            System.out.println();



            return;
        }

        for (int i = 0; i < cnt; i++) {
            if (check[i] == 1) continue;

            check[i] = 1;
            candid[depth] = arr[i];
            permutation(depth + 1, candid, arr, check, cnt);
            check[i] = 0;
        }
    }

    public int add(int s, int e, int[] arr) {
        int cnt = 0;
        for (int i = s; i < e; i++) {
            cnt += arr[i];
        }
        return cnt;
    }
}
