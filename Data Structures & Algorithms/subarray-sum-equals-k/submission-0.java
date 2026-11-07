class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0; 

        HashMap<Integer, Integer> prefixSums = new HashMap<>();
        int prefixSum = 0;  
        prefixSums.put(prefixSum, 1);
        for (int num : nums){
            prefixSum += num; 
            int diff = prefixSum - k; 
            if (prefixSums.containsKey(diff)) result += prefixSums.get(diff); 
            prefixSums.put(prefixSum, 1 + prefixSums.getOrDefault(prefixSum, 0)); 
        }

        return result; 
    }
}