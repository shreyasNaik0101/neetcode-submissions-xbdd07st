class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] f: flights){
            int u = f[0];
            int v = f[1];
            int cost = f[2];

            adj.get(u).add(new int[]{v, cost});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, (int)1e9);
        Queue<int[]> q = new ArrayDeque<>();
        dist[src] = 0;
        q.add(new int[]{0, src, 0});

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int s = curr[0];
            int node = curr[1];
            int price = curr[2];

            if(s > k){
                continue;
            }

            for(int[] nei: adj.get(node)){
                int neig = nei[0];
                int paise = nei[1];

                if(dist[neig] > paise+price){
                    dist[neig] = paise+price;
                    q.add(new int[]{s+1, neig, paise+price});
                }
            }
        }
        return dist[dst] == (int)1e9 ? -1 : dist[dst];
    }
}
