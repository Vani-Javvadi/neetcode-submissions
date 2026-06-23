class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // BF - n^2 , we will find first highest in right part 

        // optimal - next greater element 
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        // we will come from end of array 
        for(int i=n-1; i>=0; i--) {
            if(st.isEmpty()) {
                result[i] = 0;
            } else {
                // if previous temps are less than current one , they will no longer be warmer than current one 
                // so no point in having them so pop 
                while(!st.isEmpty() &&  temperatures[st.peek()] <= temperatures[i]) {
                    st.pop();
                }
                result[i] = !st.isEmpty() ? st.peek() - i : 0;
            }
            st.push(i);
        }
        return result;
        // Tc - O(N) 
        // SC - O(N) 
    }
}
