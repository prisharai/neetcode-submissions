class Solution {

    public static final int [][] directions = 
    new int [][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int orangesRotting(int[][] grid) {
        int minutes = -1; 

        int ROWS = grid.length; 
        int COLS = grid[0].length; 

        Queue<int[]> queue = new LinkedList<>();

        // for the initial queue, find all rotten fruit
        for (int r = 0; r < ROWS; r++){
            for (int c = 0; c < COLS; c++){
                if (grid[r][c] == 2){
                    queue.add(new int[]{r, c});
                } 
            }
        }

        while (!queue.isEmpty()){
            int num_pops = queue.size(); 
            for (int i = 0; i < num_pops; i++){
                int [] curr = queue.poll(); 
                for (int [] dir : directions){
                    int r1 = curr[0] + dir[0]; 
                    int c1 = curr[1] + dir[1]; 
                    if(r1 >= 0 && r1 < ROWS 
                    && c1 >= 0 && c1 < COLS 
                    && grid[r1][c1] == 1) {
                        grid[r1][c1] = 2; 
                        queue.add(new int[]{r1, c1}); 
                    }
                }
            }
            minutes++; 
        }

        // FIX 1: Check for unreachable fresh fruit
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 1) return -1;
            }
        }

        // FIX 2: Handle an empty initial BFS queue
        return Math.max(0, minutes);
    }
}
