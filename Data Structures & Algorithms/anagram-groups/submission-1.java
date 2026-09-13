class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>(); 

        for (String str : strs){ 
            int [] count = new int [26]; 
            char [] charArray = str.toCharArray(); 
            for (char c : charArray) {
                count[c - 'a']++;
            }
            String key = Arrays.toString(count); 
            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(str) ;//add
        }

        return new ArrayList<>(res.values());
    }
}
