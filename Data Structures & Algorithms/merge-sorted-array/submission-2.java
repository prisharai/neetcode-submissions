class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pointer1 = 0; 
        int pointer2 = 0; 
        if (m == 0){
            for (int i = 0; i < nums1.length; i++){
                nums1[i] = nums2[i];
            }
            return; 
        }
        while (pointer1 < m && pointer2 < n) {
            if (nums2[pointer2] < nums1[pointer1]){
                for (int i = nums1.length-1; i > pointer1; i--){
                    nums1[i] = nums1[i-1]; 
                }
                nums1[pointer1] = nums2[pointer2];
                pointer2++; 
                m++; 
            }
            pointer1++;
        }
        while (pointer2<n){
            nums1[pointer1] = nums2[pointer2];
            pointer1++;; 
            pointer2++;
        }       
    }
}