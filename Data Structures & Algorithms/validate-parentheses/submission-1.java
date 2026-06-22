class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> st = new Stack<>();
        for(int i=0; i<n; i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                st.push(s.charAt(i));
            } else {
                if(!st.isEmpty() && st.peek() == map.get(s.charAt(i))) {
                    st.pop();
                } else {
                    return false;
                }
            }
        } 
        if(!st.isEmpty()) {
            return false;
        }
        return true;
    }
}
