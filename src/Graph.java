import java.util.*;

public class Graph {
    static class Edge implements Comparable<Edge> {
        int src, dest, weight;
        public Edge(int src, int dest, int weight){
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    int vertices;
    List<Edge> edges;

    Graph(int vertices){
        this.vertices = vertices;
        edges = new ArrayList<>();
    }

    void addEdge(int src, int dest, int weight){
        edges.add(new Edge(src, dest, weight));
    }

    void kruskal(){
        Collections.sort(edges);
        ArrayList<Edge> result = new ArrayList<>();
        Disjoint ds = new Disjoint(vertices);

        for(Edge e: edges){
            int x = ds.find_parent(e.src);
            int y = ds.find_parent(e.dest);
            if(x != y){
                result.add(e);
                ds.union(x,y);
            }
        }

        for(Edge e: result){
            System.out.println(e.src + " " + e.dest + " "+ e.weight);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        Graph graph = new Graph(vertices);
        int edges = sc.nextInt();
        for(int i = 0; i < edges; i++){
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int weight = sc.nextInt();
            graph.addEdge(src, dest, weight);
        }
        graph.kruskal();
    }


}
