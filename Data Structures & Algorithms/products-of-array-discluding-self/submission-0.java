class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] preprod = new int[n];
        int[] postprod = new int[n];

        preprod[0] = 1;
        postprod[n-1] = 1;

        for(int i=1; i<n; i++){
            preprod[i] = preprod[i-1]*nums[i-1]; 
        }

        for(int j=n-2; j>=0; j--){
            postprod[j] = postprod[j+1]*nums[j+1];
        }

        int[] ans = new int[n];
        for(int k=0; k<n; k++){
            ans[k] = preprod[k]*postprod[k];
        }
        return ans;
    }
}  
