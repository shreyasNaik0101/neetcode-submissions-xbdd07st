class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] p : prerequisites){
            int u = p[0];
            int v = p[1];

            adj.get(v).add(u);
        }

        int[] indegree = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            for(int nei: adj.get(i)){
                indegree[nei]++;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        if(q.isEmpty()){
            return new int[]{};
        }

        int[] ans = new int[numCourses];
        int count=0;
        while(!q.isEmpty()){
            int node = q.poll();
            ans[count++] = node;
            for(int nei: adj.get(node)){
                indegree[nei]--;
                if(indegree[nei] == 0){
                    q.add(nei);
                }
            } 
        }
        
        if(numCourses != count){
            return new int[]{};
        }
        return ans;
    }
}
