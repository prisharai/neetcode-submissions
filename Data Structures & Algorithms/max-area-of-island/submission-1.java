class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int area = 0; 
        
        int ROWS = grid.length; 
        int COLS = grid[0].length; 

        for (int r = 0; r < ROWS; r++){ 
            for (int c = 0; c < COLS; c++){
                if (grid[r][c] == 1){
                    //bfs(grid, r, c); 
                    area = Math.max(area, bfs(grid, r, c)); 
                }
            }
        } 

        return area; 
    }

    private static final int [][] directions = new int [][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; 

    /** For an island with a starting cell, find the int area of 
    * that island
    */ 
    private int bfs(int [][] grid, int r, int c){
        int ROWS = grid.length; 
        int COLS = grid[0].length;

        grid[r][c] = 0;  

        Queue<int[]> queue = new LinkedList<>(); 
        // queue holds the current cell [r, c]
        queue.add(new int [] {r, c}); 
        int area = 1; 
        while (!queue.isEmpty()){
            int [] curr = queue.poll(); 
            for (int [] dir : directions){
                int r1 = curr[0] + dir[0]; 
                int c1 = curr[1] + dir[1]; 
                if (r1 >= 0 && r1 < ROWS 
                && c1 >= 0 && c1 < COLS 
                && grid[r1][c1] == 1){
                    queue.add(new int [] {r1, c1});
                    grid[r1][c1] = 0; 
                    area++; 
                }
            }
        }

        return area; 
    }
}
