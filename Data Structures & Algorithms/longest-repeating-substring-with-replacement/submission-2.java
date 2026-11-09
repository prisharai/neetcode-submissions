class Solution {
    public int characterReplacement(String s, int k) { // Variable sliding window 
        int length = 0; 
        
        Map<Character, Integer> freq = new HashMap<>(); 
        int l = 0; 

        int maxFreq = 0;        // historical maximum

        for (int r = 0; r < s.length(); r++) {       // expand window with right pointer
            freq.put(s.charAt(r),1 + freq.getOrDefault(s.charAt(r), 0));

            maxFreq = Math.max(maxFreq, freq.get(s.charAt(r)));

            while((r - l + 1) - maxFreq > k){          // shrink window from left until substring valid again 
                freq.put(s.charAt(l), freq.get(s.charAt(l)) - 1);     // decrement freq of s[l]
                l++;                                                    // move l right
            }
            
            length = Math.max(length, r - l + 1); 
        }

        return length; 
        
        
    }
}
