class Solution {
    public int lengthOfLongestSubstring(String s) {
        // variable sliding window with invariant that it always has unique chars 
        // expand window with right pointer 
        // shrink window from left until duplicate removed 
        int length = 0; 
        
        Set<Character> seen = new HashSet<>(); 
        int l = 0; 

        for (int r = 0; r < s.length(); r++){
            while(seen.contains(s.charAt(r))){
                // remove s[l] from set, move l right 
                seen.remove(s.charAt(l)); 
                l++; 
            }
            seen.add(s.charAt(r));
            length = Math.max(length, r - l + 1); 
        }

        return length; 
    }
}
