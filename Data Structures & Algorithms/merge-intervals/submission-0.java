public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        // sort intervals with a custom comparator in place by start time 

        List<int[]> output = new ArrayList<>();
        //output list 

        output.add(intervals[0]);
        //add the first interval 

        for (int[] interval : intervals) {
            int start = interval[0]; // start of current 
            int end = interval[1]; // end of current 
            int lastEnd = output.get(output.size() - 1)[1]; // finish time of last processed interval 

            if (start <= lastEnd) {
                output.get(output.size() - 1)[1] = Math.max(lastEnd, end); // merge interval logic
            } else {
                output.add(new int[]{start, end}); // add interval to list 
            }
        }
        return output.toArray(new int[output.size()][]); //convert dynamic size list back into array 
    }
}