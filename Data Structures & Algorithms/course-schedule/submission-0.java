class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] p : prerequisites){
            adj.get(p[1]).add(p[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];
        for(int i=0; i<numCourses; i++){
            if(!visited[i]){
                if(dfs(i, visited, path, adj)){
                    return false;
                }
            }
        }
        return true;
    }

    boolean dfs(int start, boolean[] visited, boolean[] path, ArrayList<ArrayList<Integer>> adj){
        visited[start] = true;
        path[start] = true;

        for(int nei : adj.get(start)){
            if(!visited[nei]){
                if(dfs(nei, visited, path, adj)){
                    return true;
                }
            } else if(path[nei]){
                return true;
            }
        }
        path[start] = false;
        return false;
    }
}
