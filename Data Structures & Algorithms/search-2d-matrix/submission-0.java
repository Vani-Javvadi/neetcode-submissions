class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i=0; i<n; i++) {
            int l_c=0;
            int h_c = m-1;
            int mid_r = i;
            if(matrix[i][l_c] <= target && target <= matrix[i][h_c]) {
                while(l_c <= h_c) {
                    int mid_c = (l_c + h_c)/2;
                    if(matrix[i][mid_c] == target) {
                        return true;
                    } else if(matrix[i][mid_c] > target) {
                        h_c = mid_c - 1;
                    } else {
                        l_c = mid_c + 1;
                    }
                }
            } else {
                continue;
            }
        }
        return false;
    }
}
