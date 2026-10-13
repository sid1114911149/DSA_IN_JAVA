
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstras {

    public static int[] cal_distance(int Edges[][], int V, int src) {

        int E = Edges.length;

        // Adjacency list: {neighbor, weight}
        ArrayList<ArrayList<ArrayList<Integer>>> Adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            Adj.add(new ArrayList<>());
        }

        // Build undirected weighted graph
        for (int i = 0; i < E; i++) {
            int u = Edges[i][0];
            int v = Edges[i][1];
            int w = Edges[i][2];

            Adj.get(u).add(new ArrayList<>(Arrays.asList(v, w)));
            Adj.get(v).add(new ArrayList<>(Arrays.asList(u, w)));
        }

        int[] Ans = new int[V];
        Arrays.fill(Ans, Integer.MAX_VALUE);
        Ans[src] = 0;

        // Min-priority queue: {distance, node}
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) ->
                Integer.compare(a[0], b[0]));

        pq.add(new int[]{0, src});

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();
            int dist = curr[0];
            int node = curr[1];

            // Skip outdated entries
            if (dist > Ans[node])
                continue;

            for (ArrayList<Integer> edge : Adj.get(node)) {

                int nbr = edge.get(0);
                int weight = edge.get(1);

                int distance = dist + weight;

                if (distance < Ans[nbr]) {
                    Ans[nbr] = distance;
                    pq.add(new int[]{distance, nbr});
                }
            }
        }

        return Ans;
    }

    public static void main(String Args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices and edges: ");
        int V = sc.nextInt();
        int E = sc.nextInt();

        int[][] Edges = new int[E][3];

        System.out.println("Enter edges in the format: src dest weight");

        for (int i = 0; i < E; i++) {
            Edges[i][0] = sc.nextInt();
            Edges[i][1] = sc.nextInt();
            Edges[i][2] = sc.nextInt();
        }

        System.out.print("Enter source vertex: ");
        int src = sc.nextInt();

        int[] Ans = cal_distance(Edges, V, src);

        System.out.println("Shortest distances from source " + src + ":");

        for (int i = 0; i < V; i++) {
            if (Ans[i] == Integer.MAX_VALUE) {
                System.out.println(i + " -> INF");
            } else {
                System.out.println(i + " -> " + Ans[i]);
            }
        }

        sc.close();
    }
}
