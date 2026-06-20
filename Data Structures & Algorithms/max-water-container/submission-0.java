class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        // BF is we will take each bar as left container and we will try to find its right max 
        // so that we will know how much it can store 
        int area = 0;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                area = Math.max(area, (Math.min(heights[i], heights[j]))*(j-i));
            }
        }
        return area;
    }
}
