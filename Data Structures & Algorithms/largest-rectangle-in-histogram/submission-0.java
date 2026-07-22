class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> st = new Stack<>();
        int maxArea = 0;
        for(int i=0; i<heights.length; i++){
            int start = i;
            while(!st.isEmpty() && st.peek()[1] > heights[i]){
                int[] top = st.pop();
                int ind = top[0];
                int height = top[1];
                maxArea = Math.max(maxArea, (i-ind)*height);
                start = ind;
            }
            st.push(new int[]{start, heights[i]});
        }

        while(!st.isEmpty()){
            int[] temp = st.pop();
            int h = temp[1];
            int i = temp[0];

            maxArea = Math.max(maxArea, (heights.length-i)*h);
        }
        return maxArea;
    }
}
