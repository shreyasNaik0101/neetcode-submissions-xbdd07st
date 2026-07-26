class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int l=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            return b[0] - a[0];
        });
        int[] res = new int[nums.length-k+1];
        for(int r=0; r<nums.length; r++){
            pq.add(new int[]{nums[r], r});
            if(r-l+1 == k){
                while(pq.peek()[1] < l){
                    pq.poll();
                }
                res[l] = pq.peek()[0];
                l++;
            }
        }
        return res;
    }
}