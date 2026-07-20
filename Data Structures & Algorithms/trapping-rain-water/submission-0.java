class Solution {
    public int trap(int[] height) {
        int[] preMax = new int[height.length];
        int[] postMax = new int[height.length];

        preMax[0] = height[0];
        postMax[height.length-1] = height[height.length-1];

        for(int i=1; i<height.length; i++){
            preMax[i] = Math.max(preMax[i-1], height[i]);
        }  

        for(int i=height.length-2; i>=0; i--){
            postMax[i] = Math.max(postMax[i+1], height[i]);
        }

        int res = 0;
        for(int i=0; i<height.length; i++){
            res += Math.min(preMax[i], postMax[i]) - height[i];
        }
        return res;
    }
}
