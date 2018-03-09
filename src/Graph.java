import java.util.*;

public class Graph {
    int size, edges;
    LinkedList<Integer>[] vertices;
    LinkedList<Integer>[] weights;

    public Graph(int numVert){
        int size = numVert;
        vertices = new LinkedList[numVert];
        weights = new LinkedList[numVert];
        for (int i = 0; i < size; i++){
            vertices[i] = new LinkedList<>();
            weights[i] = new LinkedList<>();
        }
    }


}
