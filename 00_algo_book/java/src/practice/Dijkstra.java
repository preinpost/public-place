package practice;

import java.util.*;

public class Dijkstra {

    public static class Edge implements Comparable<Edge> {
        public int distance;
        public String vertex;

        public Edge(int distance, String vertex) {
            this.distance = distance;
            this.vertex = vertex;
        }

        public String toString() {
            return "vertex: " + this.vertex + ", distance: " + this.distance;
        }

        @Override
        public int compareTo(Edge o) {
            return this.distance - o.distance;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();

        priorityQueue.add(new Edge(2, "A"));
        priorityQueue.add(new Edge(5, "B"));
        priorityQueue.offer(new Edge(1, "C"));
        priorityQueue.offer(new Edge(7, "D"));

        System.out.println("priorityQueue = " + priorityQueue);
        priorityQueue.peek();
        Edge poll = priorityQueue.poll();
        System.out.println("poll = " + poll);

        System.out.println("priorityQueue = " + priorityQueue);

        int size = priorityQueue.size();
        System.out.println("size = " + size);

        Map<String, ArrayList<Edge>> graph = new HashMap<>();
        graph.put("A", new ArrayList<>(Arrays.asList(new Edge(8, "B"), new Edge(1, "C"), new Edge(2, "D"))));
        graph.put("B", new ArrayList<>());
        graph.put("C", new ArrayList<>(Arrays.asList(new Edge(5, "B"), new Edge(2, "D"))));
        graph.put("D", new ArrayList<>(Arrays.asList(new Edge(3, "E"), new Edge(5, "F"))));
        graph.put("E", new ArrayList<>(Arrays.asList(new Edge(1, "F"))));
        graph.put("F", new ArrayList<>(Arrays.asList(new Edge(5, "A"))));
        
        for (String key : graph.keySet()) {
            System.out.println("key = " + key);
            System.out.println("graph.get(key) = " + graph.get(key));
        }

    }

}
