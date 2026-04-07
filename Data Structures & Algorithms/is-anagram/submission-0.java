class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> countS = new HashMap<>();
        HashMap<Character, Integer> countT = new HashMap<>();

        if(s.length() != t.length()){
            return false;
        }

        for(int i=0; i<s.length(); i++){
            countS.put(s.charAt(i), countS.getOrDefault(s.charAt(i), 0)+1);
            countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i), 0)+1);
        }

        return countS.equals(countT);
    }
}
