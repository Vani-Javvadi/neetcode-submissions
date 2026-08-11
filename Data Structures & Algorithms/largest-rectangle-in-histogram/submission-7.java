class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> pse = new Stack<>();
        int area = 0,maxArea = 0;
        for(int i=0; i<n; i++) {
            while(!pse.isEmpty() && heights[i] < heights[pse.peek()]) {
                // we encountered nse element for current element in top of stack 
                // so other elements below it in the stack are of course less that the current one , else if they are greated they would have got removed earlier , so kandippa they will be lesser , so for current top find the area it can contribute to 
             
                int index = pse.pop();
                int previousSmallerIndex = pse.isEmpty() ? -1 : pse.peek();
                area = (heights[index] * (i - previousSmallerIndex - 1));
                maxArea = Math.max(area, maxArea);
            }
            pse.push(i);
        }
        // when no nse element is there - 2,2,4 
        while(!pse.isEmpty()) {
            int index = pse.pop();
            int previousSE = pse.isEmpty() ? -1 : pse.peek();
            area = (heights[index] * (((n-1) - previousSE)));
            maxArea = Math.max(area, maxArea);

        }
        return maxArea;
    }
}
