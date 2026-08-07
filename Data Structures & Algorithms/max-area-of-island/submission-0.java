class Solution {
    int area = 0;
    private int DFS(int[][] grid, int row, int col) {
        int[] rows = {0,0,1,-1};
        int[] cols = {1,-1,0,0};
        int n = grid.length, m = grid[0].length;
        for(int i=0; i<4; i++) {
            int adj_row = row + rows[i];
            int adj_col = col + cols[i];
            if(adj_row >= 0 && adj_row < n && adj_col >= 0 && adj_col < m) {
                if(grid[adj_row][adj_col] == 1) {
                    grid[adj_row][adj_col] = 0;
                    area++;
                    DFS(grid, adj_row, adj_col);
                }
            }
            
        }
        return area;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length, maxArea = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                area = 0;
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    area++;
                    int islandArea = DFS(grid, i, j);
                    maxArea = Math.max(islandArea, maxArea);
                }
            }
        }
        return maxArea;
    }
}
