class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> res = new HashMap<>();
        for(String s : strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String newS = new String(c);
            res.putIfAbsent(newS, new ArrayList<>());
            res.get(newS).add(s);
        }
        return new ArrayList<>(res.values());
    }
}
