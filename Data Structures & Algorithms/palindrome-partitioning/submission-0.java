class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(res, s, new ArrayList<>(), 0);
        return res;
    }

    public boolean palin(String str){
        String og = new String(str);
        StringBuilder sb = new StringBuilder(str);
        
        return sb.reverse().toString().equals(og);
    }

    public void backtrack(List<List<String>> res, String s, ArrayList<String> curr, int start){
        if(start == s.length()){
            res.add(new ArrayList<>(curr));
        }

        for(int i=start; i<s.length(); i++){
            String sub = s.substring(start, i+1);
            if(palin(sub)){
                curr.add(sub);
                backtrack(res, s, curr, i+1);
                curr.remove(curr.size() -1);
            }
        }
    }
}
