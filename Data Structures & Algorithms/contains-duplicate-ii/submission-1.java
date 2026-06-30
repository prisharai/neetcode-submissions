class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> seen = new HashMap<>();
        // key - num in nums, value - index 
        for (int i = 0; i < nums.length; i++){
            if (seen.containsKey(nums[i])) {
                 int j = seen.get(nums[i]); 
                 if (Math.abs(i - j) <= k) return true;
            }
            seen.put(nums[i], i);
        }
        return false;
    }
}