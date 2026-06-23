class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int n = tokens.length;
        for(int i=0; i<n; i++) {
            String ch = tokens[i];
            if(ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/")) {
                if(!st.empty() && st.size() >= 2) {
                    int a = st.pop();
                    int b = st.pop();
                    if(ch.equals("+")) {
                        st.push(b+a); 
                    }  else if(ch.equals("-")) {
                        st.push(b-a); 
                    } else if(ch.equals("*")) {
                        st.push(a*b); 
                    } else {
                        st.push(b/a);
                    }
                    
                }
            } else {
                st.push(Integer.parseInt(tokens[i]));
            }
        }
        return st.peek();
    }
}
