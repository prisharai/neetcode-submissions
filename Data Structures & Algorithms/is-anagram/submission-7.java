class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length()!= t.length()) return false; 
        Map<Character, Integer> smap = new HashMap<>(); //key - letter, value - frequency 
        Map<Character, Integer> tmap = new HashMap<>(); //key - letter, value - frequency 
        for (int i = 0; i < s.length(); i++){
            smap.put(s.charAt(i), 1 + smap.getOrDefault(s.charAt(i), 0));
        }
        for (int i = 0; i < t.length(); i++){
            tmap.put(t.charAt(i), 1 + tmap.getOrDefault(t.charAt(i), 0));
        }
        return smap.equals(tmap); 
    }
}
