class Solution {

    /**
    Adjacency list is usually a map to hold vertices and their
    * list of neighbors
    * Bc courses are 0 .. n-1 here, we use List<List<Integer>> 
    * to take advantage of that 
    */

    // Build adjacency list (list of neighbors for each node 0 .. n-1)
        List<List<Integer>> graph = new ArrayList<>();

    // 0 = unvisited, 1 = visiting, 2 = completed
        int[] state;

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // 1) Add a new list into the graph for each course node
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        
        // 2) For each prereq pair, add a course's prereq to its list 
        for (int[] prereq : prerequisites) graph.get(prereq[0]).add(prereq[1]);

        // 3) state 
        state = new int[numCourses]; 

        // 4)  Explore every course
        for (int course = 0; course < numCourses; course++) {
            if (!dfs(course)) return false;
        }

        return true;
    } 

    /** True if course path in graph has no cycles 
    * False if course path contains cycle 
    */ 
    private boolean dfs(int course) {

        // BASE CASES 
        if (state[course] == 1) return false; // Cycle detected
        if (state[course] == 2) return true; // Already explored

        // Mark current node as visiting 
        state[course] = 1;

        // Explore all neighbors (prerequisites of a course)
        for (int prereq : graph.get(course)) 
            if (!dfs(prereq)) return false;
        
        // Mark completed 
        state[course] = 2;

        return true;
    }
}
