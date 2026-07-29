class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(0,0,nums, target);
    }

    public int dfs(int i, int total, int[] nums, int target){
        if(i == nums.length){
            return total == target? 1 : 0;
        }

        return dfs(i+1, total+nums[i], nums, target) + dfs(i+1, total-nums[i], nums, target);
    }
}
