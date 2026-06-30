public class Solution {
    public int[] twoSum(int[] nums, int target) {
        /*psuedocode: 
        look at the first element. do target - first 
        is this difference in the hashmap? if not, add the num to the hashmap with key = num and val = index to put in array later
        move on , loop til a difference is in the hashmap
        return a new int [2] {seen.get(target-nums[i]), i}

        */
        Map<Integer, Integer> seen = new HashMap <>(); //key = nums, value =index
        for (int i = 0; i < nums.length; i++){
            if (seen.containsKey((target - nums[i]))) {
                return new int[]{seen.get(target-nums[i]), i}; 
            }
            seen.put(nums[i], i);
        }
        return new int[2]; 
    }
}