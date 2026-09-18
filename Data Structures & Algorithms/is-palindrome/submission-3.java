class Solution {
    public boolean isPalindrome(String s) {
        /**1. restate
        - input: string to check if palindrome
            - ignore non alphanumeric (including whitespace) 
            - convert all to lower 
        - output: boolean if it is a palindrome or not 
        */

        int l = 0; 
        int r = s.length() - 1; 

        while (l < r){
            while (l < r && !isAlphanumeric(s.charAt(l))) l++; 
            while (l < r && !isAlphanumeric(s.charAt(r))) r--; 

            if (Character.toLowerCase(s.charAt(l)) !=
            Character.toLowerCase(s.charAt(r))) return false;

            l++; 
            r--; 
        }
        return true; 
    }

    public boolean isAlphanumeric(char c) {
        return 
            (c >= 'A' && c <= 'Z') || (c >= 'a' && 
            c <= 'z') || (c >= '0' && c <= '9'); 
        
    }
}
        /**7. dry run 
        s = "tab a cat"
        l = 0 r = 8 
            0 < 8 -> true -> t != t -> no 
        l = 1 r = 7
            1 < 9 -> true -> a != a -> no
        l = 2 r = 6
            2 < 6 -> true -> b != c -> yes -> return false 
        */

        /**8. complexity 
        1 pass over half of string length n, constant time operations at iteration
        O(n)
        */
