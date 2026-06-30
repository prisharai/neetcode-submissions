class Solution {
    public boolean hasDuplicate(int[] nums) {
        /*
        // 1. Brute Force - O(n^2) time, O(1) space
        for (int i = 0, i < nums.length; i++){
            for (int j = i+1, j < nums.length; j++){
                if (nums[i] == nums[j]) return true; 
            }
        }
        return false; 

        // 2. Sorting - O(n log n) time, O(1) space
        Arrays.sort(nums); 
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] = nums[i-1]) return true; 
        }
        return false; 

        // 3. Hash Set Length - O(n) time, O(n) space 
        return Arrays.stream(nums).distinct().count() < nums.length; 
        */
        
        // 4. Hash Set - O(n) time, O(n) space 
        Set <Integer> seen = new HashSet<>(); 
        for (int num : nums) {
            if (seen.contains(num)) return true;
            seen.add(num);
        }
        return false; 
    }
}