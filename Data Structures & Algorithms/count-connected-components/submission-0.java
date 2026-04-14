class Solution {
    int count = 0;
    public int countComponents(int n, int[][] edges) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] e: edges){
            int u = e[0];
            int v = e[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++){
            if(!visited[i]){
                count++;
                dfs(i, adj, visited);
            }
        }
        return count;
    }

    void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited){
        visited[node] = true;

        for(int nei: adj.get(node)){
            if(!visited[nei]){
                dfs(nei, adj, visited);
            }
        }
    }
}
