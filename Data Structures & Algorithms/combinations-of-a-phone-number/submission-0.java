class Solution {
    List<String> res = new ArrayList<>();
    String[] map = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
    };
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return res;
        StringBuilder sb = new StringBuilder();
        backtrack(0, sb, digits);
        return res;
    }

    public void backtrack(int i, StringBuilder sb, String digits){
        if(sb.length() == digits.length()){
            res.add(sb.toString());
            return;
        }

        String str = map[digits.charAt(i) - '0'];
        for(char c : str.toCharArray()){
            sb.append(c);
            backtrack(i+1, sb, digits);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
