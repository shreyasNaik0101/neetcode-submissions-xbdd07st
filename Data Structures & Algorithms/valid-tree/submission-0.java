class Solution {
    public boolean validTree(int n, int[][] edges) {
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

        int[] visited = new int[n];
        boolean val = dfs(0, -1, visited, adj);
        if(val == true){
            return false;
        }

        for(int i=0; i<n; i++){
            if(visited[i] == 0){
                return false;
            }
        }
        return true;
    }

    boolean dfs(int node, int parent, int[] visited, ArrayList<ArrayList<Integer>> adj){
        visited[node] = 1;

        for(int nei: adj.get(node)){
            if(visited[nei] == 0){
                if(dfs(nei, node, visited, adj)){
                    return true;
                }
            } else if(nei != parent){
                return true;
            }
        }
        return false;
    }
}
