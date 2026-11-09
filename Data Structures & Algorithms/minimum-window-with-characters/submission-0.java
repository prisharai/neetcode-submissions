
class Solution {
    public String minWindow(String s, String t) {
        if (t.length() == 0 || s.length() < t.length()) return ""; // base cases 

        int length = Integer.MAX_VALUE;
        int start = 0;

        // Required character frequencies from t
        HashMap<Character, Integer> need = new HashMap<>();

        for (char c : t.toCharArray()) {
            need.put(c, 1 + need.getOrDefault(c, 0));
        }

        // Character frequencies in current window
        HashMap<Character, Integer> freq = new HashMap<>();

        int l = 0;
        int matched = 0;

        for (int r = 0; r < s.length(); r++) { // expand window with right pointer

            char right = s.charAt(r);

            // Add right character if it is required
            if (need.containsKey(right)) {
                freq.put(right, 1 + freq.getOrDefault(right, 0));

                // Count it only if we still need more of this char
                if (freq.get(right) <= need.get(right)) {
                    matched++;
                }
            }

            // Shrink window WHILE valid to find smallest length
            while (matched == t.length()) {

                // Update shortest valid substring
                if (r - l + 1 < length) {
                    length = r - l + 1;
                    start = l;
                }

                char left = s.charAt(l);

                // Remove leftmost character from window
                if (need.containsKey(left)) {

                    // If removing it breaks a requirement,
                    // the window will become invalid
                    if (freq.get(left) <= need.get(left)) {
                        matched--;
                    }

                    freq.put(left, freq.get(left) - 1);
                }

                l++; // move left pointer right
            }
        }

        // Return shortest substring, or "" if none exists
        return length == Integer.MAX_VALUE
            ? ""
            : s.substring(start, start + length);
    }
}
