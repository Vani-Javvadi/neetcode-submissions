class Solution {
    private void DFS(char[][] grid, int row, int col) {
        int n = grid.length;
        int m = grid[0].length;
        int[] rows = {0,0,1,-1};
        int[] cols = {1,-1,0,0};
        for(int i=0; i<4; i++) {
            int adj_row  = row + rows[i];
            int adj_col = col + cols[i];
            if(adj_row >= 0 && adj_row < n && adj_col >= 0 && adj_col < m) {
                if(grid[adj_row][adj_col] != '0') {
                    grid[adj_row][adj_col] = '0';
                    DFS(grid, adj_row, adj_col);
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        // we will do DFS traversal in all 4 directions here 
        // if a position in the given matrix is not visited, we will visit and check if we can form an island by traversing all of its child noded in Depth wise , as we can move only in 4 direction , we will visti all adjacent direc again apply DFS on those nodes 
       
        int n = grid.length;
        int m = grid[0].length;
         int[][] visited = new int[n][m];
         int island = 0;
         for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] != '0' && visited[i][j] != 1) {
                    grid[i][j] = '0';
                    island++;
                    DFS(grid, i,j);
                }
            }
         }
         return island;
         // TC - O(N*M)
         // SC - O(N*M) - if visited Array is taken , if we can make use of grid itself then we can remove the visted array and make space as O(1) 
    }
}
