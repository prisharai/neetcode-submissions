class Solution {

    private static final int[][] directions = new int [][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        int ROWS = grid.length; 
        int COLS = grid[0].length;

        if (grid == null) return 0; 

        int islands = 0; 

        for (int r = 0; r < ROWS; r++){
            for (int c = 0; c < COLS; c++){
                if (grid[r][c] == '1'){
                    islands++; 
                    bfs(grid, r, c); 
                }
            }
        }

        return islands; 
    }

    public void bfs(char [][] grid, int r, int c){
        int ROWS = grid.length; 
        int COLS = grid[0].length;

        Queue<int[]> queue = new LinkedList<>(); //[r, c] gets added to queue 
        
        grid[r][c] = '0'; 
        queue.add(new int[]{r, c});
        while (!queue.isEmpty()){
            int [] curr = queue.poll();

            for (int [] dir : directions){
                int r1 = curr[0] + dir[0]; 
                int c1 = curr[1] + dir[1]; 

                if (r1 >= 0 && r1 < ROWS
                && c1 >= 0 && c1 < COLS
                && grid[r1][c1] == '1'){
                    grid[r1][c1] = '0'; 
                    queue.add(new int []{r1, c1});
                }
            }
        }
    }
}
