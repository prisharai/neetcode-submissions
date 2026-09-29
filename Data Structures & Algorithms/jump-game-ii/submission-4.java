class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0; 
        
        int num_jumps = 0; 
        
        int i = 0; 
        while (i < nums.length - 1){
            if (i + nums[i] >= nums.length - 1) {
                return num_jumps + 1;
            }

            int max_index = i + 1; 
            int max_reach = 0; 
            for (int j = i + 1; j <= nums[i] + i && j < nums.length; j++){
                if (j + nums[j] > max_reach) {
                    max_reach = j + nums[j];
                    max_index = j;
                }
            }
            i = max_index; 
            num_jumps++; 
        }

        return num_jumps; 
    }
}
