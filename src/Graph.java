import java.util.*;

public class Graph {
    int size, edges;
    PriorityQueue<Node>[] vertices;

    public Graph(int numVert){
        size = numVert;
        edges = 0;
        vertices = new PriorityQueue[numVert];
        for (int i = 0; i < size; i++){
            vertices[i] = new PriorityQueue<>();
        }
    }

    public void addEdge(int first, int second, int weight){
        vertices[first].add(new Node(second, weight));
        vertices[second].add(new Node(first, weight));
        edges++;
    }

    public String toString(){
        String output = "";
        for (int i = 0; i < size; i++){
            output += vertices[i] + "\n";
        }
        return output;
    }

    public class Node implements Comparable<Node>{
        int value;
        int weight;

        public Node(int v, int w){
            value = v;
            weight = w;
        }

        public int compareTo(Node other){
            return Integer.compare(this.weight, other.weight);
        }

        public String toString(){
            String output = "<" + value + "," + weight + ">";
            return output;
        }
    }
}
