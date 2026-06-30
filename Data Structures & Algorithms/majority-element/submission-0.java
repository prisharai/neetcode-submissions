class Solution {
    public int majorityElement(int[] nums) {
        /*
        logic: 
        - add all into frequency map 
        - get values 
        - find value that is greater than or equal to max
        - find its key and return it 
        */
        int max = nums.length / 2;
        Map <Integer, Integer> freq = new HashMap<>(); 
        // key - element , value - frequency 
        for (int i = 0; i < nums.length; i++){
            freq.put(nums[i], 1 + freq.getOrDefault(nums[i], 0));
            if (freq.get(nums[i]) > max) return nums[i]; 
        }
        return nums[nums.length-1];
    }
}