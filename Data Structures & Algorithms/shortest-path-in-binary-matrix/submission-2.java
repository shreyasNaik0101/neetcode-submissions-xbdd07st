class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        if(grid[0][0] == 1 || grid[ROWS-1][COLS-1] == 1) return -1;
        
        int[][] directions = {
            {-1,-1}, {-1,0}, {-1,1},
            {0, -1},         {0, 1},
            {1, -1}, {1,0},  {1, 1}
        };

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0,0,1});
        grid[0][0] = 1;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int d = curr[2];

            if(r == ROWS-1 && c == COLS-1 ) return d;

            for(int[] dir : directions){
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr >= 0 && nc >= 0 && nr < ROWS && nc < COLS && grid[nr][nc] == 0){
                    grid[nr][nc]=1;
                    q.add(new int[]{nr, nc, d + 1});
                }
            }
        }
        return -1;
    }
}