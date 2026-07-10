class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character, Integer> countS = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            countS.put(s.charAt(i), countS.getOrDefault(s.charAt(i), 0) + 1);
        }

        for(int j = 0; j<t.length(); j++){
            char ch = t.charAt(j);
            if(countS.containsKey(ch)){
                countS.put(ch, countS.get(ch) - 1);
                if(countS.get(ch) == 0) countS.remove(ch);
            }

        }

        if(countS.size() == 0) return true;
        return false;
    }
}
