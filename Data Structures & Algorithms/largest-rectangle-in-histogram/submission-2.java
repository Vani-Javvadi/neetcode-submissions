class Solution {
    public int largestRectangleArea(int[] heights) {
        // a bar can contribute until it gets pse and nse in left and right 
        // TC - O(N) - NSE + O(N) - PSE + O(N) array traversal to find area 
        // SC - O(N) for NSE 

        // indorder to do in O(N), we can make use of stack 
        // store pse in stack , find the nse element for current value , if we found nse then we can calculate area 
        // ex - [7,1,2,2,10,11,11,2,2,3,4,5,7,6] 
        // 7 has no PSE , so coniser index of PSE for 7 as -1 , insert 7 to stack , find its nse
        // when we enocuter 1 , 1 < 7 , which is nse for 7 , so we will pop 7 and find area 
        // push 1 , push 2 , push 2, push 10, push 11, push 11, 
        // when we ecounter 2 which is lesser than top of stack means we found nse of 11 
        // we will pop until we get pse for 11 , then find area using index , currIndx - topInd * 11 
        // same for 10 , 2 is nse and pse is 2 , so we will find area 
        // but for 2 still we can count 

        int n = heights.length, area=0;
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++) {
            // when we get nse , nse = i 
            while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
                int currentIndex = st.pop();
                int pse = st.isEmpty() ? -1 : st.peek();
                area = Math.max(area, (i - pse - 1) * heights[currentIndex]);
            }
            st.push(i);
        }
        // 2,2,4 in stack 
        int nse = n-1; //means for the elements remained in stack there is no nse  
        while(!st.isEmpty()) {
            int currentIndex = st.pop();
            // pop until we get pse 
            while (!st.isEmpty() && heights[st.peek()] >= heights[currentIndex]) {
                st.pop();
            }
            int pse = st.isEmpty() ? -1 : st.peek();
            area = Math.max(area, (nse - pse) * heights[currentIndex]);
        }
        return area;

        // TC - O(N) 

        // Every element is pushed once.
        // Every element can be removed by one of these inner loops only once.
        // Once an index is popped, it never comes back.
        // Therefore, although the loop is nested, the total number of pops across all executions is at most N.
        // This is an amortized analysis.

        // SC - O(N) 
    }
}
