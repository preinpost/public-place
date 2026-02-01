package toss2022;

public class C_X {

    /**
     * 탐험 시작 전 요구체력
     * 탐험 마쳤을 때 사용 체력
     *
     * 하루에 한 번씩 탐험할 수 있는 던전을 최대한 많이 탐험해야함
     */

    int cnt = 0;

    class Pair implements Comparable<Pair> {
        int requestHp;
        int costHp;

        public Pair(int requestHp, int costHp) {
            this.requestHp = requestHp;
            this.costHp = costHp;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.costHp == o.costHp) return this.costHp - o.costHp;

            return o.requestHp - this.requestHp;
        }
    }

    public static void main(String[] args) {
        C_X c = new C_X();

        int k = 80;
        int [][] dungeons = new int[][] {{80, 20}, {50, 40}, {30, 10}};

        int result = c.solution(k, dungeons);
        System.out.println("result = " + result);
    }

    public int solution(int k, int[][] dungeons) {
        recursive(k, 0, 0, dungeons);
        return cnt;
    }

    public void recursive(int k, int answer, int idx, int[][] dungeons) {
        if (idx == dungeons.length) return;
        if (k < dungeons[idx][0]) return;

        recursive(k - dungeons[idx][1], answer, idx+1, dungeons); // 탐험했을 때,
        cnt = Math.max(cnt, answer);
        recursive(k, answer, idx+1, dungeons); // 탐험 안했을 때,
        cnt = Math.max(cnt, answer);
    }


}
