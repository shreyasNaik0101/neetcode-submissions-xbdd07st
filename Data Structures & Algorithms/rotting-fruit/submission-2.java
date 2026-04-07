class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int fresh = 0;
        int time = 0;

        for(int r=0; r<ROWS; r++){
            for(int c=0; c<COLS; c++){
                if(grid[r][c] == 1){
                    fresh++;
                }

                if(grid[r][c] == 2){
                    q.add(new int[]{r,c});
                }
            }
        }

        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while(!q.isEmpty() && fresh > 0){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                for(int[] dir : directions){
                    int row = r + dir[0];
                    int col = c + dir[1];

                    if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != 1){
                        continue;
                    } 

                    grid[row][col] = 2;
                    fresh--;
                    q.add(new int[]{row,col});
                }
            }
            time++;
        }

        return fresh == 0 ? time : -1;
    }
}
