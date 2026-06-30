class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()) return false;
        Map <Character, Integer> anagram = new HashMap <> (); //key val
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            anagram.put(c, anagram.getOrDefault(c, 0) + 1);
        }

        for (int j = 0; j < t.length(); j++) {
            char c = t.charAt(j);
            if (!anagram.containsKey(c)) return false;
            anagram.put(c, anagram.get(c) - 1);
            if (anagram.get(c) == 0) anagram.remove(c);
        }
        return true;
    }
}
