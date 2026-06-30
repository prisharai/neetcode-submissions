class Solution {
    public int missingNumber(int[] nums) {
        //sorting
        int[] tmp = new int[nums.length];
        sort(nums, 0, nums.length, tmp);

        //remaining code logic 
        if (nums[0] != 0) return 0; 
        for (int i = 1; i < nums.length; i++){
            if (nums[i-1]+1 != nums[i]) return nums[i]-1;
        }
        return nums[nums.length-1]+1;
    }

    public void sort(int[] a, int l, int r, int[] tmp) {
        if (l == r-1) return; // already sorted
        int m = (l+r)/2;
        sort(a, l, m, tmp);
        sort(a, m, r, tmp);
        merge(a, l, m, r, tmp);
    }

    public void merge(int[] a, int l, int m, int r, int[] tmp) {
        int i = l, j = m, k = l;
        while (i < m && j < r) {
            tmp[k++] = (a[i] <= a[j]) ? a[i++] : a[j++];
        }
        System.arraycopy(a, i, tmp, k, m-i);
        System.arraycopy(tmp, l, a, l, j-l);
    }
}
