class Solution {
    int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    boolean edge;
    public void solve(char[][] board) {
        int ROWS = board.length;
        int COLS = board[0].length;

        for(int r=0; r<ROWS; r++){
            for(int c=0; c<COLS; c++){
                edge = false;
                if(board[r][c] == 'O'){
                    dfs(board, r, c);
                }
            }
        }
    }

    void dfs(char[][] board, int r, int c){
        if(r <= 0 || c <= 0 || r >= board.length-1 || c >= board[0].length-1 ){
            edge = true;
            return;
        }

        if(board[r][c] == 'X'){
            return;
        }

        board[r][c] = 'X';
        for(int[] dir: directions){
            dfs(board, r+dir[0], c+dir[1]);
            if(edge){
                break;
            }
        }
    }
}
