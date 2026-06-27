class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length; // rows 
        int m = matrix[0].length; // cols 
        // find valid row using binary search 
        // find valid col using binary search 

        int top=0, bot = n-1, mid_row=0; 
        while(top <= bot) {
            mid_row = (top+bot)/2;
            // check if target lies in mid row 

            // means if target is greater than last element of row , we will move top to mid+1 
            // as element cannot lie before it 
            if(target > matrix[mid_row][m-1]) {
                top = mid_row+1;
            } 
            // if target is even more lesser than current row least element we will move it before 
            else if(target < matrix[mid_row][0]) {
                bot = mid_row-1;
            } else {
                // means target lies
                break;
            }

        }
        if(top > bot) {
            return false;
        }
            // else do BS on current mid_row 
        int l = 0, r = m-1; 
        while(l <= r) {
            int m_r = (l+r)/2;
            if(matrix[mid_row][m_r] == target) {
                return true;
            } else if(matrix[mid_row][m_r] > target) {
                r = m_r-1;
            } else {
                l = m_r+1;
            }
        }
        if(l > r) {
            return false;
        }
        return false;
    }
}
