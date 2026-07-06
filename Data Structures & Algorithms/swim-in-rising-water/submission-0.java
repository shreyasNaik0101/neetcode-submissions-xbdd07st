class Solution {
    public int swimInWater(int[][] grid) {
        int N = grid.length;
        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1, 0}};
        boolean[][] vis = new boolean[N][N];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            return a[0] - b[0];
        });

        pq.add(new int[]{grid[0][0], 0, 0});
        vis[0][0] = true;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int w = curr[0];
            int r = curr[1];
            int c = curr[2];
            if(r == N-1 && c == N-1){
                return w;
            }
            for(int[] dir : directions){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(nr >= 0 && nc >=0 && nr < N && nc < N && !vis[nr][nc]){
                    vis[nr][nc] =true;
                    pq.add(new int[]{Math.max(w, grid[nr][nc]), nr, nc});
                }
            } 
        }
        return N*N;
    }
}
