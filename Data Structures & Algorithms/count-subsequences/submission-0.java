class Solution {
    int[][] memo;
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        memo = new int[m+1][n+1];
        for(int i=0; i<=m; i++){
            Arrays.fill(memo[i], -1);
        }
        
        return dfs(s,t,0,0);
    }

    public int dfs(String s, String t, int i, int j){
        if (j == t.length()) return 1;
        if (i == s.length()) return 0;

        if(memo[i][j] != -1){
            return memo[i][j];
        }

        int res = dfs(s,t, i+1, j);
        if(s.charAt(i) == t.charAt(j)){
            res+= dfs(s,t, i+1, j+1);
        }
        memo[i][j] = res;
        return res;
    }
}
