class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false; 
        
        Map<Character, Integer> freq_s = new HashMap <> (); 
        Map<Character, Integer> freq_t = new HashMap <> (); 
        //key - letter, value - frequency 

        for (int i = 0; i < s.length(); i++){
            freq_s.put(s.charAt(i), freq_s.getOrDefault(s.charAt(i), 0) + 1);
            freq_t.put(t.charAt(i), freq_t.getOrDefault(t.charAt(i), 0) + 1);
        }

        return freq_s.equals(freq_t); 
    }
}
