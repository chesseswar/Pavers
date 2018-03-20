import java.util.*;

public class Graph {
    int size, edges;
    HashMap<Integer, Node> vertices;

    public Graph(int numVert){
        size = numVert;
        edges = 0;
        vertices = new HashMap<>();
    }

    public void addEdge(int first, int second, int weight){
        if (vertices.get(first) == null){
            vertices.put(first, new Node(first));
        }

        if (vertices.get(second) == null){
            vertices.put(second, new Node(second));
        }

        Edge edge = new Edge(vertices.get(first), vertices.get(second), weight);
        vertices.get(first).edges.add(edge);
        vertices.get(second).edges.add(edge);
    }

    public int minSpanTreeWeight(){
        int length = 0;
        HashSet<Node> visited = new HashSet<>();
        PriorityQueue<Edge> edges = new PriorityQueue<>();

        Node current = vertices.get(0);
        while (visited.size() <  vertices.size()){
            visited.add(current);

            for (Edge e : current.edges){
                edges.add(e);
            }

            Edge shortest = edges.poll();
            while (shortest != null && visited.contains(shortest.a) && visited.contains(shortest.b)){
                shortest = edges.poll();
            }

            if (shortest == null){
                break;
            }

            if (visited.contains(shortest.a)){
                current = shortest.b;
            } else {
                current = shortest.a;
            }
            length += shortest.weight;
        }

        return length;
    }

    public class Node {
        int value;
        PriorityQueue<Edge> edges;

        public Node(int v){
            value = v;
            edges = new PriorityQueue<>();
        }

        public String toString(){
            return Integer.toString(value);
        }
    }

    public class Edge implements Comparable<Edge>{
        Node a, b;
        int weight;
        public Edge(Node a, Node b, int w){
            this.a = a;
            this.b = b;
            weight = w;
        }

        public int compareTo(Edge other){
            return Integer.compare(this.weight, other.weight);
        }
    }
}
