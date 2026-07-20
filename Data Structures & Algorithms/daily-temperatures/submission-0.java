class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[temperatures.length];
        int n = temperatures.length;
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && st.peek() <= temperatures[i]){
                st.pop();
            }
            if(st.isEmpty()){
                res[i] = 0;
            } else{
                res[i] = map.get(st.peek()) - i;
            }
            st.push(temperatures[i]);
            map.put(temperatures[i], i);
        }
        return res;
    }
}
