package DSA.GRAPHS;

import java.util.ArrayList;
import java.util.Scanner;

public class SCC { // strongly connected components
    static ArrayList<ArrayList<Integer>> buildGraph(int vertices, int[][] edges){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < vertices; i++){
            adj.add(new ArrayList<>());
        }
        //ADDING THE EDGES
        for (int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        return adj;
    }

    static ArrayList<ArrayList<Integer>> getComponents(ArrayList<ArrayList<Integer>> adj){
        boolean[] vis = new boolean[adj.size()];
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        for (int i = 0; i < vis.length; i++) {
            if(!vis[i]){
                ArrayList<Integer> component = new ArrayList<>();
                dfs(i, adj, vis, component);
                res.add(component);
            }
        }
        return res;
    }

    private static void dfs(int i, ArrayList<ArrayList<Integer>> adj, boolean[] vis, ArrayList<Integer> component) {
        vis[i] = true;
        component.add(i);
        for(int neighbour : adj.get(i)){
            if(!vis[neighbour]) dfs(neighbour, adj, vis, component);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        int[][] edges = new int[e][2];
        for (int i = 0; i < e; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }

        ArrayList<ArrayList<Integer>> graph = buildGraph(n, edges);
        ArrayList<ArrayList<Integer>> components = getComponents(graph);

        System.out.println(components.size() - 1);
    }
}
