class Solution {
    // define a public enum directions with pairs (0,1) (1, 0) (1, 1) (0, 0)
    int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') { // if island 
                    dfs(grid, r, c); // process entire island 
                    count++; // we found an island 
                }
            }
        }
        return count;
    }

    public void dfs (char[][] grid, int r, int c){ 
        if (r < 0 || r >= grid.length || // make sure we dont go out of bounds 
            c < 0 || c >= grid[0].length || // when looking for neighbors 
            grid[r][c] != '1') {
            return;
        }

        grid[r][c] = '0';

        for (int[] d : directions) {
            dfs(grid, r + d[0], c + d[1]);
        }
    }
}
