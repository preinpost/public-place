package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B1991 {

    List<List<Integer>> treeNodeList = new ArrayList<>();
    static StringBuffer preorder = new StringBuffer();
    static StringBuffer inorder = new StringBuffer();
    static StringBuffer postorder = new StringBuffer();

    public static void main(String[] args) throws IOException {

        B1991 b1991 = new B1991();
        b1991.input();
        b1991.traversal(0);
        System.out.println(preorder);
        System.out.println(inorder);
        System.out.println(postorder);
    }

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            treeNodeList.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = st.nextToken().charAt(0) - 65; // A가 0
            List<Integer> current = treeNodeList.get(a);

            String b = st.nextToken();
            if (!b.equals(".")) {
                current.add(b.charAt(0) - 65);
            } else current.add(null);
            String c = st.nextToken();
            if (!c.equals(".")) {
                current.add(c.charAt(0) - 65);
            } else current.add(null);
        }
    }
    public void traversal(Integer current) {
        if (current == null) return;
        preorder.append((char) (current+65));
        List<Integer> currentChildren = treeNodeList.get(current);

        traversal(currentChildren.get(0));
        inorder.append((char) (current+65));
        traversal(currentChildren.get(1));

        postorder.append((char) (current+65));
    }
}
