class Solution {
    public void solve(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                // boundary check , get the bouandary zeros add it to Queue 
                // These are the Os that definitely cannot be converted because their region touches the boundary.

                if(i==0 || j==0 || i==n-1 || j==m-1) {
                    if(grid[i][j] == 'O') {
                        q.add(new Pair<>(i,j));
                    }
                }
            }
        }
        while (!q.isEmpty()) {
            Pair<Integer, Integer> p = q.poll();
            // visit it by marking 1 
            int row = p.getKey();
            int col = p.getValue();
            grid[row][col] = '1';
            // check the adjacent if they are zeros add them 
            int[] rows = {0,0,-1,1};
            int[] cols = {1,-1,0,0};
            for(int i=0; i<4; i++) {
                int adj_row = row + rows[i];
                int adj_col = col + cols[i];
                if(adj_row >= 0 && adj_col >= 0 && adj_row < n && adj_col < m) {
                    // check if adj is 0 and it was not visited , if so add it to queue 
                    if(grid[adj_row][adj_col] == 'O') {
                        q.add(new Pair<>(adj_row, adj_col));
                    }
                }
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 'O') {
                    grid[i][j] = 'X';
                } else if(grid[i][j] == '1') {
                    grid[i][j] = 'O';
                }
            }
        }
    }
}
