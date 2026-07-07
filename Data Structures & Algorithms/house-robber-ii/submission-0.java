class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int a1[] = new int[nums.length-1];
        for(int i=0; i<a1.length; i++){
            a1[i] = nums[i];
        }

        int a2[] = new int[nums.length-1];
        for(int i=0; i<a2.length; i++){
            a2[i] = nums[i+1];
        }

        return Math.max(houseRobber(a1), houseRobber(a2));
    }

    public int houseRobber(int[] arr){
        int n = arr.length;
        if(n==1) return arr[0];

        int[] dp = new int[n];
        dp[n-1] = arr[n-1];
        dp[n-2] = Math.max(arr[n-1], arr[n-2]);

        for(int i= n-3; i>=0; i--){
            dp[i] = Math.max(arr[i] + dp[i+2], dp[i+1]);
        }
        return dp[0];
    }
}
