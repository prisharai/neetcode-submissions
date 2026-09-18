class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();

        Arrays.sort(strs); // O(m log m) where m = # strings
        int first = 0;
        int last = strs.length - 1; // last element 

        for (int i = 0; i < strs[0].length(); i++){ 
            char f = strs[first].charAt(i); 
            char l = strs[last].charAt(i);

            if (f == l) sb.append(strs[first].charAt(i));
            else break; 
        }

        return sb.toString(); 
    }
}