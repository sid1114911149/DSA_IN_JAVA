import java.util.*;
import java.util.LinkedList;
public class Graphs {

    class Pair implements Comparable<Pair> {
        int first;
        int second;

        Pair(int f, int s) {
            first = f;
            second = s;
        }

        public int compareTo(Pair o) {
            return this.second - o.second;
        }
    }

    public int check(boolean[] visited, int V) {
        for (int i = 0; i < V; i++) {
            if (!visited[i]) return i;
        }
        return -1;
    }

    public void DFS(int[][] Edges, int V) {
        ArrayList<Integer>[] Adj = new ArrayList[V];
        for (int i = 0; i < V; i++) Adj[i] = new ArrayList<>();

        for (int[] e : Edges) {
            Adj[e[0]].add(e[1]);
            Adj[e[1]].add(e[0]);
        }

        boolean[] visited = new boolean[V];
        Stack<Integer> st = new Stack<>();
        int k = check(visited, V);

        while (k != -1) {
            st.push(k);
            visited[k] = true;

            while (!st.isEmpty()) {
                int u = st.peek();
                boolean pushed = false;

                for (int v : Adj[u]) {
                    if (!visited[v]) {
                        st.push(v);
                        visited[v] = true;
                        pushed = true;
                        break;
                    }
                }

                if (!pushed) {
                    System.out.print(st.pop() + " ");
                }
            }
            k = check(visited, V);
        }
        System.out.println();
    }

    public void BFS(int[][] Edges, int V) {
        ArrayList<Integer>[] Adj = new ArrayList[V];
        for (int i = 0; i < V; i++) Adj[i] = new ArrayList<>();

        for (int[] e : Edges) {
            Adj[e[0]].add(e[1]);
            Adj[e[1]].add(e[0]);
        }

        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        int k = check(visited, V);

        while (k != -1) {
            q.offer(k);
            visited[k] = true;

            while (!q.isEmpty()) {
                int u = q.poll();
                System.out.print(u + " ");
                for (int v : Adj[u]) {
                    if (!visited[v]) {
                        visited[v] = true;
                        q.offer(v);
                    }
                }
            }
            k = check(visited, V);
        }
        System.out.println();
    }

    public int Dijkstras(int[][] Edges, int V, int src, int dest) {
        ArrayList<Pair>[] Adj = new ArrayList[V];
        for (int i = 0; i < V; i++) Adj[i] = new ArrayList<>();

        for (int[] e : Edges) {
            Adj[e[0]].add(new Pair(e[1], e[2]));
            Adj[e[1]].add(new Pair(e[0], e[2]));
        }

        int[] dist = new int[V];
        boolean[] visited = new boolean[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int u = cur.first;
            if (visited[u]) continue;
            visited[u] = true;

            for (Pair p : Adj[u]) {
                int v = p.first;
                int w = p.second;
                if (!visited[v] && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }
        return dist[dest];
    }

    public int BellmanFord(int[][] Edges, int V, int src, int dest) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 1; i < V; i++) {
            for (int[] e : Edges) {
                if (dist[e[0]] != Integer.MAX_VALUE &&
                    dist[e[0]] + e[2] < dist[e[1]]) {
                    dist[e[1]] = dist[e[0]] + e[2];
                }
            }
        }
        return dist[dest];
    }

    public int FloydWarshall(int[][] Edges, int V, int src, int dest) {
        int[][] dist = new int[V][V];
        for (int i = 0; i < V; i++)
            Arrays.fill(dist[i], 1000000);

        for (int i = 0; i < V; i++) dist[i][i] = 0;

        for (int[] e : Edges) {
            dist[e[0]][e[1]] = e[2];
            dist[e[1]][e[0]] = e[2];
        }

        for (int k = 0; k < V; k++)
            for (int i = 0; i < V; i++)
                for (int j = 0; j < V; j++)
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);

        return dist[src][dest];
    }

    public int Prims(int[][] Edges, int V) {
        ArrayList<Pair>[] Adj = new ArrayList[V];
        for (int i = 0; i < V; i++) Adj[i] = new ArrayList<>();

        for (int[] e : Edges) {
            Adj[e[0]].add(new Pair(e[1], e[2]));
            Adj[e[1]].add(new Pair(e[0], e[2]));
        }

        boolean[] visited = new boolean[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        int cost = 0;

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int u = cur.first;
            int w = cur.second;

            if (visited[u]) continue;
            visited[u] = true;
            cost += w;

            for (Pair p : Adj[u]) {
                if (!visited[p.first]) {
                    pq.add(new Pair(p.first, p.second));
                }
            }
        }
        return cost;
    }

    int find(int[] parent, int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent, parent[x]);
    }

    void union(int[] parent, int[] rank, int x, int y) {
        int px = find(parent, x);
        int py = find(parent, y);

        if (px == py) return;
        if (rank[px] < rank[py]) parent[px] = py;
        else if (rank[px] > rank[py]) parent[py] = px;
        else {
            parent[py] = px;
            rank[px]++;
        }
    }

    public int Kruskals(int[][] Edges, int V) {
        Arrays.sort(Edges, Comparator.comparingInt(a -> a[2]));
        int[] parent = new int[V];
        int[] rank = new int[V];

        for (int i = 0; i < V; i++) parent[i] = i;

        int cost = 0;
        for (int[] e : Edges) {
            if (find(parent, e[0]) != find(parent, e[1])) {
                cost += e[2];
                union(parent, rank, e[0], e[1]);
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        int[][] Edges = new int[E][3];
        for (int i = 0; i < E; i++) {
            Edges[i][0] = sc.nextInt();
            Edges[i][1] = sc.nextInt();
            Edges[i][2] = sc.nextInt();
        }

        Graphs g = new Graphs();
        g.DFS(Edges, V);
        g.BFS(Edges, V);

        System.out.println(g.Dijkstras(Edges, V, 0, V - 1));
        System.out.println(g.BellmanFord(Edges, V, 0, V - 1));
        System.out.println(g.FloydWarshall(Edges, V, 0, V - 1));
        System.out.println(g.Prims(Edges, V));
        System.out.println(g.Kruskals(Edges, V));

        sc.close();
    }
}
