class Solution {
    public boolean isAnagram(String s, String t) {
        /*// 1. Sorting - O(n log n + m log m) time, O(1) space 
        if (s.length() != t.length()) return false; 
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        return Arrays.equals(sArr, tArr);*/
        
        // 2. Hash Map 
        if (s.length() != t.length()) return false; 
        Map<Character, Integer> sMap = new HashMap<>(); // key - letter , value - frequency
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        return sMap.equals(tMap);
    }
}
