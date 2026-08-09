class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 0) {
                    q.add(new Pair<>(i,j));
                }
            }
        }
        while(!q.isEmpty()) {
            Pair<Integer, Integer> p = q.poll();
            int row = p.getKey(), col = p.getValue();
            int[] rows = {-1,1,0,0};
            int[] cols = {0,0,-1,1};
            for(int i=0; i<4; i++) {
                int adj_row = row + rows[i];
                int adj_col = col + cols[i];
                if(adj_row >= 0 && adj_row < n && adj_col >= 0 && adj_col < m) {
                    if(grid[adj_row][adj_col] == 2147483647) {
                          grid[adj_row][adj_col] = grid[row][col]+1;
                          q.add(new Pair<>(adj_row, adj_col));              
                    }
                } 
            }
        }
    }
}
