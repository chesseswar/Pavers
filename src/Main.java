import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        int numCase = in.nextInt();
        for (int i = 0; i < numCase; i++){
            int price = in.nextInt();
            int buildings = in.nextInt();
            int streets = in.nextInt();
            Graph graph = new Graph(buildings);
            HashMap<Integer, Integer> streetCodes = new HashMap<>();
            int index = 0;
            for (int j = 0; j < streets; j++){
                int first = in.nextInt();
                int second = in.nextInt();
                int weight = in.nextInt();
                if (!streetCodes.containsKey(first)){
                    streetCodes.put(first, index);
                    index++;
                }

                if (!streetCodes.containsKey(second)){
                    streetCodes.put(second, index);
                    index++;
                }

                graph.addEdge(streetCodes.get(first), streetCodes.get(second), weight);
            }
            System.out.println(graph.minSpanTreeWeight());
        }
    }
}
