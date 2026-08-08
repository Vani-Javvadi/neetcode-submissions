class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        for (int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 2) {
                    q.add(new Pair<>(i,j));
                }
            }
        }
        int min = 0;
        while(!q.isEmpty()) {
            int s = q.size();
            int rotten = 0;
            for(int k = 0; k<s; k++) {
                Pair<Integer, Integer> p = q.poll();
                int row = p.getKey();
                int col = p.getValue();
                int[] rows = {0,0,-1,1};
                int[] cols = {1,-1,0,0};
                for(int i=0; i<4; i++) {
                    int adj_row = rows[i] + row;
                    int adj_col = cols[i] + col;
                    if(adj_row < n  && adj_row >= 0 && adj_col >= 0 && adj_col < m) {
                        if(grid[adj_row][adj_col] == 1) {
                            grid[adj_row][adj_col] = 2;
                            q.add(new Pair<>(adj_row, adj_col));
                            rotten = 1;
                        }
                    }
                }
            }
            if(rotten == 1) {
                min++;
            }
            
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return min;
    }
}
