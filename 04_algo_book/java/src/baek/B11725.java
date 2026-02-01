package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B11725 {

    /*
        출력조건 : 첫째 줄부터 N-1개의 줄에 각 노드의 부모 노드 번호를 2번 노드부터 순서대로 출력한다.

        7
        1 6     1이랑 6 연결
        6 3     6이랑 3 연결
        3 5     3이랑 5 연결
        4 1     4랑 1 연결
        2 4     2랑 4 연결
        4


        4 - 2
        6 - 3
        1 - 4
        3 - 5
        1 - 6
        4 - 7

        연결리스트로 입력 받고
        1이랑 연결된 노드 찾고 (6, 4) -> 찾은 index 에 지금연결된 노드 기록하고 -> queue에 다음 찾을 값 넣는다
        찾은 노드들과 연결된 노드 찾고 (3, 2, 7) -> 찾은 index에 지금 연결된 노드 기록하고 -> queue에 다음 찾을 값 넣는다 (5)
        또 찾은노드들과 연결된 노드 찾기 (5)


     */

    static int[] answer;

    public static void main(String[] args) throws IOException {
        B11725 b11725 = new B11725();

        List<ArrayList<Integer>> arr = b11725.input();

        b11725.solution(arr);

        for (int i = 2; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }

    public void solution(List<ArrayList<Integer>> arr) {

        Queue<Integer> Q = new LinkedList<>();

        Q.add(1);

        while (!Q.isEmpty()) {

            Integer poll = Q.poll();

            ArrayList<Integer> children = arr.get(poll);

            for (Integer child : children) {
                if (answer[child] != 0) continue;

                answer[child] = poll;
                Q.add(child);
            }
        }
    }

    public List<ArrayList<Integer>> input() throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<ArrayList<Integer>> arr = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        answer = new int[n+1];

        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < n-1; i++) {

            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            arr.get(b).add(a);

        }

        return arr;
    }
}
