class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        int open=0;
        int closed=0;
        backtrack(res, n, open, closed, new StringBuilder(""));
        return res;
    }

    public void backtrack(List<String> res, int n, int open, int closed, StringBuilder curr){
        if(open==closed && open==n){
            res.add(new String(curr));
        }

        if(open < n){
            curr.append('(');
            backtrack(res, n, open+1, closed, curr);
            curr.deleteCharAt(curr.length()-1);
        }

        if(open > closed){
            curr.append(')');
            backtrack(res, n, open, closed+1, curr);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}
