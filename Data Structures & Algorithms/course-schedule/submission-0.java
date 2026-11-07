class Solution {

    /**
    Adjacency list is usually a map to hold vertices and their
    * list of neighbors
    * Bc courses are 0 .. n-1 here, we use List<List<Integer>> 
    * to take advantage of that 
    */

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // 1) Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();

        // 2) Add a new list into the graph for each course node
        // index of the list is the course number 
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // 3) For each course, add its prereqs to its list 
        for (int[] prereq : prerequisites) {
            graph.get(prereq[0]).add(prereq[1]);
        }

        // 0 = unvisited, 1 = visiting, 2 = completed
        int[] state = new int[numCourses];

        // 2. Explore every course
        for (int course = 0; course < numCourses; course++) {
            if (!dfs(course, graph, state)) return false;
        }

        return true;
    }

    private boolean dfs(int course,
                        List<List<Integer>> graph,
                        int[] state) {

        // Cycle detected
        if (state[course] == 1) return false;

        // Already fully explored
        if (state[course] == 2) return true;

        // Mark current course as visiting
        state[course] = 1;

        // Explore all prerequisites of a course 
        for (int prereq : graph.get(course)) {
            if (!dfs(prereq, graph, state)) return false;
        }

        // All prerequisites are valid
        state[course] = 2;

        return true;
    }
}
