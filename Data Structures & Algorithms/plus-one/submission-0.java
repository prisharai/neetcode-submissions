class Solution {
    public int[] plusOne(int[] digits) {
        int index = digits.length-1; 
        while (digits[index] == 9 && index > 0){
            digits[index] = 0;
            index--;
        }
        if (digits[index] == 9) {
            int[] dig = new int[digits.length+1]; 
            dig[0] = 1; 
            return dig; 
        }
        digits[index]++;
        return digits; 
    }
}
