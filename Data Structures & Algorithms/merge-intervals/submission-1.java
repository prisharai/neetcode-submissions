public class Solution {
    public int[][] merge(int[][] intervals) {
        /**1. restate
        - input: list of intervals (might have some that overlap each other)
        - output: merge the ones that overlap 
        - key observations: sorting the list by start time will ensure that
            if there is an overlap in intervals, it will overlap with
            the interval(s) adjacent to it 
            - we do not know the length of the output array until all intervals 
            processed; use arraylist then convert to array 
        */

        /**2. example walkthrough
        i = [1, 3] j = [1, 5] --> overlapping? yes, f_i >= s_j ? true 
            merge: [s_i, f_j] = [1, 5]
        new list: [1, 5] [6, 7] 
        i = [1, 5] j = [6 ,7] -> overlapping? no, f_i >= s_j ? false 

        return [1, 5] [6, 7]
        */

        /**3. brute force
        - add all intervals to arraylist 
        - for each interval, check all other intervals for overlapping 
        - merge accordingly 
        - remove unmerged intervals; add merged interval
        - convert final arraylist into array 
            - new int [] size  arraylist.size()
            - for int[] in arraylist -> int[i] = arraylist.get(i)
        - time O(n^2)
        */

        /**4. derive better approach
        - sort intervals by start time
        - for two adjacent intervals 
            - check if overlapping 
            - if yes? 1) merge 2) add merged to list 3) remove two unmerged from list
        */ 

        /**5. complexity 
        O(n log n)
        */ 

        // CODE

        List<int []> output = new ArrayList<>(); 

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        output.add(intervals[0]); // just add the first interval

        for (int[] interval : intervals) {
            int[] last = output.get(output.size() - 1);
            if (interval[0] <= last[1]) {
                last[1] = Math.max(last[1], interval[1]);
            } 
            else {
                output.add(interval);
            }
        }

        // building the output 
        int[][] res = new int[output.size()][];
        for (int i = 0; i < output.size(); i++) {
            res[i] = output.get(i);
        }
        return res;

    }
}