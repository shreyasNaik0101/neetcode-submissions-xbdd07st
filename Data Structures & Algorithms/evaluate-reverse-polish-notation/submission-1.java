class Solution {
    public int evalRPN(String[] tokens) {
        int result = 0;
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<tokens.length; i++){
            String ch = tokens[i];
            if(ch.equals("+") || ch.equals("*") || ch.equals("/") || ch.equals("-")){
                int op1 = (st.pop());
                int op2 = (st.pop());

                switch(ch){
                    case "+" :
                        result = op1 + op2;
                        st.push(result);
                        break;

                    case "-" :
                        result = op2-op1;
                        st.push(result);
                        break;

                    case "*" :
                        result = op1 * op2;
                        st.push(result);
                        break;

                    case "/":
                        result = op2 / op1;
                        st.push(result);
                        break;

                    default:
                        return -1;  
                }
            } else{
                st.push(Integer.parseInt(ch));
            }
        }
        return st.peek();
    }
}
