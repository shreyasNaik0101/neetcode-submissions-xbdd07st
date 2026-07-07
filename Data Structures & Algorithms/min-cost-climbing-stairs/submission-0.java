class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        int[] dp = new int[cost.length+1];
        int n = dp.length;
        dp[n-1] = 0;
        dp[n-2] = cost[cost.length-1];
        

        for(int i=n-3; i>=0; i--){
            dp[i] = Math.min(dp[i+1] + cost[i], dp[i+2] + cost[i]);
        }

        return Math.min(dp[0], dp[1]);
    }
}
