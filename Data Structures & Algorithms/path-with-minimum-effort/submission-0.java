class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] eff = new int[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(eff[i], (int)1e9);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if(a[0] == b[0]){
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });

        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        pq.add(new int[]{0,0,0});
        eff[0][0] = 0;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int d = curr[0];
            int r = curr[1];
            int c = curr[2];

            if(r == n-1 && c == m-1){
                return d;
            }

            for(int[] dir : directions){
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr >=0 && nc >= 0 && nr < n && nc < m){
                    int effort = Math.max(Math.abs(heights[r][c] - heights[nr][nc]), d);
                    if(effort < eff[nr][nc]){
                        eff[nr][nc] = effort;
                        pq.add(new int[]{effort, nr, nc});
                    }
                }
            }
        }
        return -1;
    }
}