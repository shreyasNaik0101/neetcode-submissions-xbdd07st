class Solution {
    public int minCostConnectPoints(int[][] points) {
        int N = points.length;

        HashMap<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 0; i < N; i++) {
            adj.put(i, new ArrayList<>());
        }
        for(int i=0; i<N; i++){
            int x1 = points[i][0];
            int y1 = points[i][1];
            for(int j=i+1; j<N; j++){
                int x2 = points[j][0];
                int y2 = points[j][1];

                int dist = Math.abs(x1-x2) + Math.abs(y1 - y2);

                adj.get(i).add(new int[]{dist, j});
                adj.get(j).add(new int[]{dist, i});
            }
        }

        PriorityQueue<int[]> minheap = new PriorityQueue<>((a,b) -> {
            if(a[0] != b[0]){
                return a[0] - b[0];
            }
            return a[1]-b[1];
        });
        
        HashSet<Integer> visit = new HashSet<>();
        minheap.add(new int[]{0, 0});
    
        int cost = 0;

        while(visit.size() < N){
            int[] node = minheap.poll();
            int u = node[1];
            int d = node[0];

            if(visit.contains(u)) continue;

            cost += d;
            visit.add(u);

            for(int[] nei : adj.get(u)){
                int v = nei[1];
                int nd = nei[0];

                if(!visit.contains(v)){
                    minheap.add(new int[]{nd, v});
                }
            }
        }
        return cost;
    }
}
