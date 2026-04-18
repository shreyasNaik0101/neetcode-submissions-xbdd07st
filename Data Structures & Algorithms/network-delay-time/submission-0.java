class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
       ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

       for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
       } 

       for(int[] t : times){
            int u = t[0];
            int v = t[1];
            int time = t[2];

            adj.get(u).add(new int[]{v, time});
       }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0]-b[0];
        });

        int[] delay = new int[n+1];
        Arrays.fill(delay, (int)1e9);
        delay[k] = 0;

        
        
        minHeap.add(new int[]{0, k});

        while(!minHeap.isEmpty()){
            int[] curr = minHeap.poll();
            int t = curr[0];
            int node = curr[1];

            if(t > delay[node]) continue;

            for(int[] nei: adj.get(node)){
                int v = nei[0];
                int samay = nei[1];

                if(delay[v] > samay+t){
                    delay[v] = samay+t;
                    minHeap.add(new int[]{(samay + t), v});
                }
            }
        }
        int maxTime = 0;
        for(int i = 1; i <= n; i++){
            if(delay[i] == (int)1e9) return -1;
            maxTime = Math.max(maxTime, delay[i]);
        }

        return maxTime;
    }
}
