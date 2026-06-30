class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 1. Sorting - O(m * n log n) time, O(m * n) space
        /*
        Map<String, List<String>> map = new HashMap<>(); // key - sorted string, value - list of anagrams
        for (String str : strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray); 
            map.putIfAbsent(sorted, new ArrayList<>());
            map.get(sorted).add(str); 
        }
        return new ArrayList<>(map.values());
        */

        // 2. Hash Table 
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (char c : str.toCharArray()) count[c - 'a']++; 
            String key = Arrays.toString(count); 
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
