class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        // BF is we will take each bar as left container and we will try to find its right max 
        // so that we will know how much it can store 
        // int area = 0;
        // for(int i=0; i<n; i++) {
        //     for(int j=i+1; j<n; j++) {
        //         area = Math.max(area, (Math.min(heights[i], heights[j]))*(j-i));
        //     }
        // }
        // return area;
        // TC - O(n^2)

        // optima solution
        // 2 pointer 
        // so we will take left and right pointer , we will move the minimum height one , 
        // because the min height one will no longer contribute to the maximum water 
        // so we will calculate how much min height can contribute and move the pointer from min 

//        We always move the pointer pointing to the smaller height because that height is the bottleneck for the current container.

// Once we calculate the area using that smaller height, we have already found the maximum possible area that particular height can contribute to, 
// since it is currently paired with the farthest possible bar on the other side (maximum width).

// Any future container using the same smaller height will have a smaller width, so its area can never be larger.

// if we take below example - 
// [1,7,2,5,4,7,3,6]

// left = 1 (height = 7)
// right = 7 (height = 6)

// Area = min(7,6) * (7 - 1)
//      = 6 * 6
//      = 36
// we have already explored the best possible container involving height 6.
// So we discard it and move the pointer inward looking for a taller bar that might increase the limiting height.
        int p1=0, p2=n-1, area=0;
        while(p1 < n && p2 >= 0) {
            if(heights[p1] < heights[p2]) {
                area = Math.max(area, heights[p1] * (p2-p1));
                p1++;
            } else {
                area = Math.max(area, heights[p2] * (p2-p1));
                p2--;
            }
        } 
        return area;
    }
}
