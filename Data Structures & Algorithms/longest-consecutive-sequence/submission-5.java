class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0; 
        if (nums.length == 1) return 1;
        int count = 1;
        int maxCount = 1; 
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++){
            if (nums[i+1] == nums[i]) continue; 
            else if (nums[i+1] == nums[i] + 1) count++; 
            else count = 1; 
            maxCount = Math.max(maxCount, count);
        }
        return maxCount; 
    }
}
