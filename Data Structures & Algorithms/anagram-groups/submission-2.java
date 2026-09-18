class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> freq = new HashMap <>();
        // key - 26 char encoding, value - string 

        for (String str : strs) {
            int[] k = new int [26]; 
            for (int i = 0; i < str.length(); i++){
                k[str.charAt(i) - 'a']++;
            }
            String key = Arrays.toString(k);
            if (freq.containsKey(key)) freq.get(key).add(str);
            else {
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                freq.put(key, list);
            }
            
        }


        return new ArrayList <> (freq.values()); 
    }
}
