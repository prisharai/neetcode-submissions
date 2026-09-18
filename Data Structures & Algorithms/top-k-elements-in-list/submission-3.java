class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        /**1. restate
        input - int array nums, int k that tells length of output array 
        k most frequent elements in the output any order
        */

        /**2. example 
        1st most frequent -> 3 (freq: 3)
        2nd most frequent -> 2 (freq: 2)
        3rd most frequent -> 1 (freq: 1)

        return: [3, 2]
        */

        /**3. brute force
        get a hashmap of all frequencies 
        sort by frequencies in descending order
        return first k of the values  
        */

        /**4. better solution
        - create array containing arraylists. index = frequency. 
        - max possible frequency = length of nums
        - each index for frequency: store list of all numbers with that frequency 
        - iterate from end of array down and collect numbers until there are k of them 
        */
        
        List<Integer> [] freq = new List [nums.length + 1]; 

        Map<Integer, Integer> count = new HashMap <>();
        //key - the number; value - frequency 
        for (int num : nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < freq.length; i++){
            freq[i] = new ArrayList<>(); 
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int index = 0;
        for (int i = freq.length - 1; i > 0 && index < k; i--) {
            for (int n : freq[i]) {
                res[index++] = n;
                if (index == k) {
                    return res;
                }
            }
        }
        return res; 

    }
}
