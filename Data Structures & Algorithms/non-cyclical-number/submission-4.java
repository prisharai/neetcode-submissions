class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = sumOfSquares(n); 

        while (slow != fast){
            fast = sumOfSquares(fast);
            fast = sumOfSquares(fast); 
            slow = sumOfSquares(slow); 
        }

        return fast == 1; 
    }

    public int sumOfSquares(int n){
        int sum = 0; 
        while (n > 0) {
            int curr = n % 10; 
            sum += curr*curr; 
            n = (n-curr)/10;
        }
        return sum; 
    }
}
