package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Kruskal {

    public static class Edge implements Comparable<Edge> {
        // 간선에 대한 정보 = Edge 객체
        public int weight;
        public String nodeV;
        public String nodeU; // 그 다음에 연결된 노드

        public Edge(int weight, String nodeV, String nodeU) {
            this.weight = weight;
            this.nodeV = nodeV;
            this.nodeU = nodeU;
        }

        public String toString() {
            return "(" + this.weight + ", " + this.nodeV + ", " + this.nodeU + ")";
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static HashMap<String, String> parent = new HashMap<>(); // 부모노드 정보를 가지고 있는 HashMap
    static HashMap<String, Integer> rank = new HashMap<>(); // rank 정보를 가지고 있는 HashMap

    static public String find(String node) {
        // path compression 기법
        if (parent.get(node) != node) {
            parent.put(node, find(parent.get(node)));
        }
        return parent.get(node);
    }

    static public void union(String nodeV, String nodeU) {
        String root1 = find(nodeV);
        String root2 = find(nodeU);

        // union-by-rank 기법
        if (rank.get(root1) > rank.get(root2)) {
            parent.put(root2, root1); // root2의 부모노드를 root1로 설정
        } else {
            parent.put(root1, root2); // root1의 부모노드를 root2로 설정
            if (rank.get(root1) == rank.get(root2)) {
                rank.put(root2, rank.get(root2) + 1);
            }
        }
    }

    // 초기화
    static public void makeSet(String node) {
        parent.put(node, node);
        rank.put(node, 0);
    }
                                                // 노드의 정보와 간선의 정보
    static public ArrayList<Edge> kruskalFunc(ArrayList<String> vetices, ArrayList<Edge> edges) {
        ArrayList<Edge> mst = new ArrayList<>();
        Edge currentEdge;

        // 1. 초기화
        for (int index = 0; index < vetices.size() ; index++) {
            makeSet(vetices.get(index));
        }

        // 2. 간선 weight 기반, sorting
        Collections.sort(edges);

        for (int index = 0 ; index < edges.size() ; index++) {
            currentEdge = edges.get(index);
            if (find(currentEdge.nodeV) != find(currentEdge.nodeU)) {
                union(currentEdge.nodeV, currentEdge.nodeU);
                mst.add(currentEdge);
            }
        }

        return mst;
    }


    public static void main(String[] args) {
        ArrayList<String> vetices = new ArrayList<String>(Arrays.asList("A", "B", "C", "D", "E", "F", "G"));
        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge(7, "A", "B"));
        edges.add(new Edge(5, "A", "D"));
        edges.add(new Edge(7, "B", "A"));
        edges.add(new Edge(8, "B", "C"));
        edges.add(new Edge(9, "B", "D"));
        edges.add(new Edge(7, "B", "E"));
        edges.add(new Edge(8, "C", "B"));
        edges.add(new Edge(5, "C", "E"));
        edges.add(new Edge(5, "D", "A"));
        edges.add(new Edge(9, "D", "B"));
        edges.add(new Edge(7, "D", "E"));
        edges.add(new Edge(6, "D", "F"));
        edges.add(new Edge(7, "E", "B"));
        edges.add(new Edge(5, "E", "C"));
        edges.add(new Edge(7, "E", "D"));
        edges.add(new Edge(8, "E", "F"));
        edges.add(new Edge(9, "E", "G"));
        edges.add(new Edge(6, "F", "D"));
        edges.add(new Edge(8, "F", "E"));
        edges.add(new Edge(11, "F", "G"));
        edges.add(new Edge(9, "G", "E"));
        edges.add(new Edge(11, "G", "F"));

        ArrayList<Edge> mst = kruskalFunc(vetices, edges);
        System.out.println("mst = " + mst);

    }
}
