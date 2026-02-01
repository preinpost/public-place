package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 트리의 순회
public class B2263 {

    int[] in;
    int[] post;
    StringBuffer answer = new StringBuffer();

    public static void main(String[] args) throws IOException {
        B2263 T = new B2263();

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();

        int n = Integer.parseInt(s);
        T.in = new int[n];
        T.post = new int[n];

        for (int i = 0; i < 2; i++) {
            s = bf.readLine();
            StringTokenizer st = new StringTokenizer(s);

            int idx = 0;
            while (st.hasMoreElements()) {
                int num = Integer.parseInt(st.nextToken());

                if (i == 0) T.in[idx] = num;
                else T.post[idx] = num;

                idx += 1;
            }
        }

        T.buildTree(0, T.in.length - 1, 0, T.post.length - 1);
        System.out.println(T.answer);
    }

    void buildTree(int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd) return;
        if (postStart > postEnd) return;

        int currentRoot = post[postEnd];
        answer.append(currentRoot).append(" ");

        int mid = search(currentRoot, inStart, inEnd);
        int leftCnt = mid - inStart;

        buildTree(inStart, mid - 1, postStart, postStart + leftCnt - 1);
        buildTree(mid + 1, inEnd, postStart + leftCnt, postEnd - 1);
    }

    int search(int currentRoot, int inStart, int inEnd) {
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == currentRoot) return i;
        }
        return 0;
    }
}
