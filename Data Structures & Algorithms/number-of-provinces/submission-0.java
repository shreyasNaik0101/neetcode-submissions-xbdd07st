class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int res = 0;

        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(i, isConnected, visited, n);
                res++;
            }
        }

        return res;
    }

    void dfs(int node, int[][] isConnected, boolean[] visited, int n){
        visited[node] = true;
        for(int neighbour = 0; neighbour < n; neighbour++){
            if(isConnected[node][neighbour] == 1 && !visited[neighbour]){
                dfs(neighbour, isConnected, visited, n);
            }
        }
    }
}