class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(int i=0; i<s1.length(); i++){
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
        }
        int l=0;
        for(int r=0; r<s2.length(); r++){
            map2.put(s2.charAt(r), map2.getOrDefault(s2.charAt(r), 0) + 1);
            if(r-l+1>s1.length()){
                if(map2.get(s2.charAt(l)) == 1){
                    map2.remove(s2.charAt(l));
                } else{
                    map2.put(s2.charAt(l), map2.get(s2.charAt(l)) - 1);
                }
                l++;
            }
            if(map1.equals(map2)) return true;
        }
        return false;
    }
}
