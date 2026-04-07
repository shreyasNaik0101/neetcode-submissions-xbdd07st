class Solution {
    int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    int perimeter = 0;
    public int islandPerimeter(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        for(int r=0; r<grid.length; r++){
            for(int c=0; c<grid[0].length; c++){
                if(grid[r][c] == 1){
                    dfs(grid, r, c);
                }
            }
        }
        return perimeter;
    }

    void dfs(int[][] grid, int r, int c){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0){
            perimeter++;
            return;
        }

        if(grid[r][c] == -1){
            return;
        }

        grid[r][c] = -1;
        
        for(int[] dir : directions){
            dfs(grid, r+dir[0], c+dir[1]);
        }
    }
}