class Solution {
    public int search(int[] nums, int target) {
        return searchHelper (nums, target, 0, nums.length-1);
    }

    public int searchHelper(int[] nums, int target, int left, int right){
        if (left > right) return -1;

        int mid = left + (right - left) / 2;

        if (nums[mid] == target) return mid;
        
        return ((nums[mid]<target) ? searchHelper(nums, target, mid+1, right) : searchHelper(nums, target, left, mid-1));
    }
}
