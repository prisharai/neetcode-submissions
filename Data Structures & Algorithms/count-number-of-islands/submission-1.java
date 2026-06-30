class Solution {

    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length; 
        int islands = 0; 
        for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++){
                if (grid[r][c] == '1'){
                    dfs(grid, r, c);
                    // bfs(grid, r, c);
                    islands++; 
                }
            }
        }
        return islands; 
    }

    public void dfs (char[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0') return;
        grid[r][c] = '0'; 
        for (int[] dir : directions) {
            dfs(grid, r + dir[0], c + dir[1]);
        }
    }
    
    public void bfs (char[][] grid, int r, int c) {
        Queue<int[]> q = new LinkedList<>(); 
        grid[r][c] = '0'; 
        q.add(new int[]{r,c});
        while(!q.isEmpty()){
            int[] node = q.poll(); 
            int row = node[0], col = node[1]; 
            for (int[] dir : directions) {
                int nr = row + dir[0], nc = col + dir[1]; 
                if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == '1'){
                    q.add(new int[] {nr, nc});
                    grid[nr][nc] = '0'; 
                }
            }
        }
    }
}