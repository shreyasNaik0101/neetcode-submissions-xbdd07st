class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1000000);
        dp[nums.length-1] = 0;
        for(int i=nums.length-2; i>=0; i--){
            int end = Math.min(nums.length-1, i + nums[i]);
            for(int j=i+1; j<=end; j++){
                dp[i] = Math.min(dp[i], dp[j] + 1);
            }     
            
        }
        return dp[0];
    }
}
