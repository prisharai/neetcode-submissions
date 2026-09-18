class Solution {
    public int longestConsecutive(int[] nums) {
        /**1. restate
        - input: array of integers (not necessarily positive) unsorted that we 
        have to find longest consecutive subset of 
        - output: length of the longest consecutive sequence 
        */   

        /**2. example
        - 2 - 3 - 4 - 5 --> length 4 
        */

        /**3. brute force
        1) sort array O(n log n)
        2) sliding window with two pointers to find the longest consecutive in 
        one page O(n)
        total complexity O(n log n)
        */

        /**4. derive correct approach 
        add all nums to a hashset to get rid of duplicates & O(1) lookup
        int longest
        if num-1 not in set, num = start of sequence 
            while (longest < nums.length)
              ...  
        */

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longest = 0;
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int length = 1;
                while (numSet.contains(num + length)) {
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;

    }
}
