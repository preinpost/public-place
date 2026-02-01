package practice;

import java.util.Arrays;
import java.util.Comparator;

public class Greedy_02 {

    public static class GreedyAlgorith {
        public void knapsackFunc(Integer[][] objectList, double capacity) {
            double totalValue = 0.0;
            double faction = 0.0;

            Arrays.sort(objectList, new Comparator<Integer[]>() {
                @Override
                public int compare(Integer[] o1, Integer[] o2) {
                    return (o2[1] / o2[0]) - (o1[1] / o1[0]);
                }
            });

            for (int index = 0; index < objectList.length; index++) {
                if (capacity - (double) objectList[index][0] > 0) {
                    capacity -= (double) objectList[index][0];
                    totalValue += (double) objectList[index][1];
                    System.out.println("무게 = " + objectList[index][0] + "가치 = " + objectList[index][1]);
                } else {
                    System.out.println("capacity = " + capacity);
                    faction = capacity / (double) objectList[index][0];
                    totalValue += (double) objectList[index][1] * faction;
                    System.out.println("무게 = " + objectList[index][0] + "가치 = " + objectList[index][1] + "비율 = " + faction);
                    break;
                }
            }

            System.out.println("totalValue = " + totalValue);
        }
    }





    public static class Edge implements Comparable<Edge> {
        public Integer distance;
        public String vertex;

        public Edge(Integer distance, String vertex) {
            this.distance = distance;
            this.vertex = vertex;
        }

        @Override
        public int compareTo(Edge e) {
            return this.distance - e.distance;
        }
    }


    public static void main(String[] args) {

        Integer[][] objectList = { {10, 10}, {15, 12}, {20, 10}, {25, 8}, {30, 5} };

        Integer[] iArray = new Integer[]{1, 10, 4, 3, 2};
        Arrays.sort(iArray);
        System.out.println("iArray = " + Arrays.asList(iArray));


        Edge edge1 = new Edge(12, "A");
        Edge edge2 = new Edge(11, "A");
        Edge edge3 = new Edge(19, "A");

        Edge[] edges = new Edge[] {edge1, edge2, edge3};
        Arrays.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o2.distance - o1.distance;
            }
        });

        for (int index = 0 ; index < edges.length ; index++) {
            System.out.println("edges = " + edges[index].distance);
        }

        GreedyAlgorith greedyAlgorith = new GreedyAlgorith();
        greedyAlgorith.knapsackFunc(objectList, 30.0);


    }
}
