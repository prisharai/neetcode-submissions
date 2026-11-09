class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0; 

        HashMap<Integer, Integer> map = new HashMap<>(); 
        map.put(0, 1);

        int windowSum = 0; 
        for (int num : nums){
            windowSum += num; 
            int diff = windowSum - k; // check what to exclude from the left 
            if (map.containsKey(diff)) res += map.get(diff); 
            map.put(windowSum, 1 + map.getOrDefault(windowSum, 0)); 
        }

        return res; 
    }
}