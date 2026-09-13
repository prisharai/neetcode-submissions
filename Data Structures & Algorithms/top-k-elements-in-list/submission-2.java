class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // create a hash map where
        // key = number, value = frequency
        Map<Integer, Integer> count = new HashMap<>();

        // for each number in nums:
        // get its current frequency,
        // defaulting to 0 if absent
        // put(number, frequency + 1)
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // turn each hashmap entry
        // into a (number, frequency) pair
        List<int[]> arr = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            arr.add(new int[] {entry.getValue(), entry.getKey()});
        }

        // sort the pairs by frequency
        // from greatest to least
        arr.sort((a, b) -> b[0] - a[0]);

        // create result array size k
        int[] res = new int[k];

        // for i = 0 to k - 1:
        // put the number from
        // pair i into res[i]
        for (int i = 0; i < k; i++) {
            res[i] = arr.get(i)[1];
        }

        // return res
        return res;
    }
}
