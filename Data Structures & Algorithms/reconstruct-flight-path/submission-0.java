class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {

        Collections.sort(tickets, new Comparator<List<String>>(){
            public int compare(List<String> a, List<String> b){
                if(!a.get(0).equals(b.get(0))){
                    return a.get(0).compareTo(b.get(0));
                }
                return a.get(1).compareTo(b.get(1));
            }
        
        });

        HashMap<String, List<String>> adj = new HashMap<>();
        for(List<String> ticket : tickets){
            String from = ticket.get(0);
            String to = ticket.get(1);
            adj.putIfAbsent(from, new ArrayList<>());
            adj.get(from).add(to);
        }

        List<String> result = new ArrayList<>();
        dfs("JFK", adj, result);
        return result;
    }

    public void dfs(String node, HashMap<String, List<String>> adj, List<String> result){
        List<String> destination = adj.get(node);
        while(destination != null && !destination.isEmpty()){
            String nextAirport = destination.remove(0);
            dfs(nextAirport, adj, result); 
        }
        result.add(0, node);
    }
}
