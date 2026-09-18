class Solution {
    public int lengthOfLongestSubstring(String s) {
        /**1. restate
        - input: string to find the max substring of unique letters 
        - output: length of the string we built 
        - edge cases: all same --> min substring = 1 
        */ 

        /**2. example 
        len = 0
        z -> unique -> len = 1
        x -> unique -> len = 2
        y -> unique -> len = 3 
        */

        /**3. brute force 
        nested for loop
        for each index, begin a possible substring there
        record the longest substring of non duplicates starting at every single index
        return max of all of those
        time O(n^2)

        /**4. derive algorithm 
        - sliding window variable size (two pointers)
            - left and right pointers 
            - when a duplicate character is hit, shift the left pointer to begin 
            at the index after the index of the first occurence of this character
        - return max size of window 
        - keep track of current longest and longest 
        */ 

        /**5. complexity
        one pass of string length n 
        constant time operations at each index in the string 
        O(n)
        */

        // CODE

        HashSet<Character> charSet = new HashSet<>(); 
        int l = 0;
        int max = 0;

        for (int r = 0; r < s.length(); r++) {
            while (charSet.contains(s.charAt(r))) {
                charSet.remove(s.charAt(l));
                l++;
            }
            charSet.add(s.charAt(r));
            max = Math.max(max, r - l + 1);
        }
        return max;

        /** 7. dry run 
        ...
        */ 

        /**8. edge cases 
        all duplicates -> r = l throughout and max = r - 1 + 1 = r - r + 1 = 1
        empty string -> for loop never hit, max = 0 
        */
        
        /**9. final analysis
        terminates when entire string processes (kept track with r pointer)
        complexity O(n) because 1 pass of string, n = len string 
        O(m) space, m = # unique characters in string 
        */
    }
}
