class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = piles[0];
        int ans = -1;
        for(int i=1; i<n; i++){
            max = Math.max(max, piles[i]);
        }

        int l = 1;
        int r = max;

        while(l <= r){
            long sum = 0;
            int mid = l + (r-l)/2;
            for(int i=0; i<n; i++){
                sum = sum + (piles[i] + mid - 1)/mid;
                
            }
            if(sum <= h){
                    ans = mid;
                    r = mid -1;
                } else{
                    l = mid + 1;
                }
        }
        return ans;
    }
}
