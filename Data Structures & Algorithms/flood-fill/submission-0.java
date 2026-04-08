class Solution {
    int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    int img;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        img = image[sr][sc];
        if(color == img){
            return image;
        }
        dfs(image, sr, sc, color);
        return image;
    }

    void dfs(int[][] image, int sr, int sc, int color){
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != img){
            return;
        } 

        image[sr][sc] = color;
        for(int[] dir: directions){
            dfs(image, sr+dir[0], sc+dir[1], color);
        }
    }
}