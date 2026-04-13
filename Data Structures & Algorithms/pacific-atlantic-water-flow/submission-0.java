class Solution {
    int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    boolean pacific, atlantic;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length;
        int COLS = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();

        for(int r=0; r<ROWS; r++){
            for(int c=0; c<COLS; c++){
                pacific = false;
                atlantic = false;
                dfs(heights, r, c, Integer.MAX_VALUE);

                if(pacific && atlantic){
                    res.add(Arrays.asList(r, c));
                }
            }
        }
        return res;
    }

    void dfs(int[][] heights, int r, int c, int prev){
        if(r < 0 || c < 0){
            pacific = true;
            return;
        }

        if(r >= heights.length || c >= heights[0].length){
            atlantic = true;
            return;
        }

        if(heights[r][c] > prev){
            return;
        }
        int curr = heights[r][c];
        heights[r][c] = Integer.MAX_VALUE;
        for(int[] dir : directions){
            dfs(heights, r+dir[0], c+dir[1], curr);
            if(pacific && atlantic){
                break;
            }
        }
        heights[r][c] = curr;
    }
}
