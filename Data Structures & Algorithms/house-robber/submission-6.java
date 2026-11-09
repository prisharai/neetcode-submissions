public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] DP = new int[nums.length];
        DP[0] = nums[0];
        DP[1] = Math.max(nums[0], nums[1]);

        int n = nums.length - 1; 

        for (int i = 2; i <= n; i++) {
            DP[i] = Math.max(DP[i - 1], nums[i] + DP[i - 2]);
        }

        return DP[n];
    }
}