class Solution {
    public int tribonacci(int n) {
        if (n < 2) return n;
        if (n == 2) return 1;

         int [] DP = new int[n + 1]; 

         DP[0] = 0; 
         DP[1] = 1;
         DP[2] = 1; 
         
         for (int i = 3; i <= n; i++){
            DP[i] = DP[i-3] + DP[i-2] + DP[i-1]; 
            System.out.print(DP[i] + "\n");
         }

         return DP[n]; 
    }
}