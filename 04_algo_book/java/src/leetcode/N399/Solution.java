package leetcode.N399;

import java.util.*;

public class Solution {

    static class Edge {
        String v1;
        String v2;
        double cost;

        public Edge(String v1, String v2, double cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public boolean equals(Object obj) {
            Edge eg = (Edge) obj;

            return this.v1.equals(eg.v1) && this.v2.equals(eg.v2) && this.cost == eg.cost;
        }
    }

    /*
        Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
        Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
        Explanation:
        Given: a / b = 2.0, b / c = 3.0
        queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
        return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
     */


    /*
        계산 가능한 경우
            1. 분모가 같은 root를 가졌을 때
            2. 분모가 분자와 같을 때
     */

    /*
        equations와 values 관계방식
            자식 -> 부모 = 곱하기
            부모 -> 자식 = 곱한 후 역수
     */

    Map<String, List<Edge>> graph = new HashMap<>();
    Map<String, String> disjoint = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] answer = new double[queries.size()];

        for (int i = 0; i < equations.size(); i++) {
            List<String> eq = equations.get(i);
            String v1 = eq.get(0);
            String v2 = eq.get(1);
            double cost = values[i];

            Edge edge = new Edge(v1, v2, cost);
            Edge edgeReverse = new Edge(v2, v1, 1 / cost);
            // 분모가 root가 된다.
            union(v1, v2);
            List<Edge> arr1 = graph.getOrDefault(v1, new ArrayList<>());
            List<Edge> arr2 = graph.getOrDefault(v2, new ArrayList<>());
            graph.put(v1, arr1);
            graph.put(v2, arr2);
            arr1.add(edge);
            arr2.add(edgeReverse);
        }

        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);

            String a = query.get(0);
            String b = query.get(1);

            if (!graph.containsKey(a) || !graph.containsKey(b)) {
                answer[i] = -1.0;
                continue;
            }

            if (!find(a).equals(find(b))) {
                answer[i] = -1.0;
                continue;
            } else if (a.equals(b)) {
                answer[i] = 1.0;
                continue;
            }

            for (Edge edge : graph.get(a)) {
                if (edge.v2.equals(b)) {
                    answer[i] = edge.cost;
                    break;
                }

                double result = dfs(edge, b, edge.cost);
                if (result != edge.cost) {
                    answer[i] = result;
                    break;
                }
            }


        }

        
        return answer;
    }

    public double dfs(Edge edge, String target, double cost) {
        if (edge.v1.equals(target) || edge.v2.equals(target)) {
            return cost;
        }

        for (Edge edgeV2 : graph.get(edge.v2)) {
            if (edgeV2.v2.equals(edge.v1)) continue;
            cost = cost * edgeV2.cost;
            return dfs(edgeV2, target, cost);
        }

        return 0.0;
    }

    public String find(String x) {
        if (!disjoint.containsKey(x))
            return x;

        else {
            String result = find(disjoint.get(x));
            disjoint.put(x, result);

            return result;
        }
    }

    public void union(String x, String y) {

        if (x.equals(y)) return;

        disjoint.put(x, y);
    }


    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
//        equations.add(Arrays.asList("a", "b"));
//        equations.add(Arrays.asList("b", "c"));

//        equations.add(Arrays.asList("a", "b"));
//        equations.add(Arrays.asList("b", "c"));
//        equations.add(Arrays.asList("bc", "cd"));

//        equations.add(Arrays.asList("a", "e"));
//        equations.add(Arrays.asList("b", "e"));

        equations.add(Arrays.asList("x1", "x2"));
        equations.add(Arrays.asList("x2", "x3"));
        equations.add(Arrays.asList("x3", "x4"));
        equations.add(Arrays.asList("x4", "x5"));





//        double[] values = new double[] {2.0, 3.0};
//        double[] values = new double[] {1.5, 2.5, 5.0};
//        double[] values = new double[] {4.0, 3.0};
        double[] values = new double[] {3.0, 4.0, 5.0, 6.0};

        List<List<String>> queries = new ArrayList<>();
//        queries.add(Arrays.asList("a", "c"));
//        queries.add(Arrays.asList("b", "a"));
//        queries.add(Arrays.asList("a", "e"));
//        queries.add(Arrays.asList("a", "a"));
//        queries.add(Arrays.asList("x", "x"));

//        queries.add(Arrays.asList("a", "c"));
//        queries.add(Arrays.asList("c", "b"));
//        queries.add(Arrays.asList("bc", "cd"));
//        queries.add(Arrays.asList("cd", "bc"));

//        queries.add(Arrays.asList("a", "b"));
//        queries.add(Arrays.asList("e", "e"));
//        queries.add(Arrays.asList("x", "x"));



        queries.add(Arrays.asList("x1", "x5"));
        queries.add(Arrays.asList("x5", "x2"));
        queries.add(Arrays.asList("x2", "x4"));
        queries.add(Arrays.asList("x2", "x2"));
        queries.add(Arrays.asList("x2", "x9"));
        queries.add(Arrays.asList("x9", "x9"));



        Solution sol = new Solution();

        sol.calcEquation(equations, values, queries);


    }
}
