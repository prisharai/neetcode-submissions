public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>(); // enable O(1) lookup
        for (int num : nums) numSet.add(num);

        int longest = 0;

        for (int num : numSet) { // try all (valid) starts of sequence
            if (!numSet.contains(num - 1)) { // number is start of sequence if num - 1 not in set
                int length = 1;
                while (numSet.contains(num + length)) { //O(1) lookups 
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}