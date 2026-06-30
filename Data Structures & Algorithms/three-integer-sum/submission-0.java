class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>(); 
        for (int i = 0; i < nums.length; i++){
            Set<Integer> seen = new HashSet<>(); 
            int target = 0 - nums[i];
            for (int j = i+1; j < nums.length; j++){
                int diff = target - nums[j];
                if (seen.contains(diff)) {
                    List<Integer> threesum = new ArrayList<>(); 
                    threesum.add(diff);
                    threesum.add(nums[i]); 
                    threesum.add(nums[j]);
                    Collections.sort(threesum);
                    res.add(threesum);
                }
                seen.add(nums[j]);
            }
        }
        return new ArrayList<>(res);
    }
}
