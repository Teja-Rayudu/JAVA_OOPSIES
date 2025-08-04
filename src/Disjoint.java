public class Disjoint {
    int[] parent;
    int[] rank;

    Disjoint(int v){
        parent = new int[v];
        rank = new int[v];
    }

    int find_parent(int v){
        if(parent[v] == v){
            return v;
        }
        return find_parent(parent[v]);
    }

    void union(int u, int v){
        int p1 = find_parent(u);
        int p2 = find_parent(v);
        if(p1 == p2){
            return;
        }
        if(rank[p1] < rank[p2]){
            parent[p1] = p2;
        }
        else if(rank[p2] < rank[p1]){
            parent[p2] = p1;
        }
        else{
            rank[p1] += rank[p2];
        }
    }


}
