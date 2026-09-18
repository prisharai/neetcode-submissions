class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        /**1. restate
        input: - int array to find two indicies i, j (if at all) that have same value 
               - Math.abs (i - j) <= k 
        output: true if the second inequality holds for valid i, j else false 
        */

        /**2. example
        i = 0 -> 1 
        i = 1 -> 2 (no match)
        i = 2 -> 3 (no match)
        i = 3 -> 1 (match)

        associated indicies: 0, 3 

        Math.abs(0 - 3) = 3 <= 3 ? true --> return true 
        */

        /**3. brute force
        two nested for loops keeping track of i and j 
        if two values at *different* indicies i and j are equal 
        check the inequality -> return true or false accordingly 
        return false if no two values are same in an array (default)
        time: O(n^2)

        /**4. better approach 
        hashmap - key = value in nums, value - index in array 
        if key exists in hashmap, then run the comparison on 1) i 2) value in map 
        return false default
        */

        /**5. complexity
        worst case O(n) with O(1) per iteration 
        hash map chosen for constant lookups of values to find a match 
        nums[i] = nums[j]
        */

        //CODE

        Map<Integer, Integer> map = new HashMap<>(); 
        boolean flag = false; 

        for (int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])) {
                if (Math.abs(i - map.get(nums[i])) <= k) return true; 
                else map.put(nums[i], i);
            }
            else map.put(nums[i], i);
        }

        return false; 

        /**6. dry run [1, 0, 1, 1] k = 1

        map = <>
        i = 0: 
            map contains 1 -> false 
            map = <(1, 0)>
        i = 1: 
            map contains 0 -> false
            map = <(1, 0), (0, 1)>
        i = 2: 
            map contains 1 -> true 
                | 2 - 0 | <= 1 ? -> 2 <= 1 -> false  
        ...
        i = 4: map = 
        
        */

        /**7. edge cases
        - empty nums --> yes 
        - k = negative --> yes 
        - all same number -> yes 
        */

        /**8. termination, final complexity
        terminates - for loop guard 
        complexity - O(n)
        */
        
    }
}