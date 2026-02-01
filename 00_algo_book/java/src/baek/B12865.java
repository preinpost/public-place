package baek;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B12865 {

    static class Pack {
        int weight;
        int value;

        public Pack(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    static int[] dy;

    public static void main(String[] args) {

        B12865 b12865 = new B12865();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();

        dy = new int[k+1];

        List<Pack> packs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();

            packs.add(new Pack(a, b));
        }

        b12865.solution(packs, k);
        System.out.println(dy[k]);
    }

    public void solution(List<Pack> packs, int k) {

        for (Pack pack : packs) {
            for (int i = k; i >= 0; i--) {
                if (i-pack.weight < 0) continue;
                dy[i] = Math.max(dy[i], dy[i-pack.weight] + pack.value);
            }
        }
    }
}
