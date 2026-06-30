class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map <Integer, Integer> hashmap = new HashMap <> ();
        for (int i = 0; i < nums.length; i++){
            if (hashmap.containsKey(nums[i])) return true;
            hashmap.put(nums[i], i);
        }
        return false; 
    }
}