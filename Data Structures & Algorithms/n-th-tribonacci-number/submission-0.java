class Solution {
    public int tribonacci(int n) {
        int t0 = 0; 
        int t1 = 1; 
        int t2 = 1; 

        if (n == 0) return 0; 
        if (n == 1 | n == 2) return 1; 

        for (int i = 3; i < n+1; i++){
            int tmp1 = t2;
            int tmp2 = t1;
            t2 = t0 + t1 + tmp1; 
            t1 = tmp1; 
            t0 = tmp2;
        }

        return t2; 
    }
}