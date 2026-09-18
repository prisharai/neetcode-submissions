class Solution {
    
    public int maxProfit(int[] prices) {
        /**1. restate
        input: array of prices each index is a price on the ith day 
        output: max prices[i] - prices[j] s.t. i > j 
        */    

        /**2. example 
        10 -> nothing before it 
        1 - 10 -> negative -> invalid 
        5 - 10 -> invalid 
        5 - 1 -> 4 [OPTION 1]
        6 - 10 -> invalid 
        6 - 1 -> 5 [OPTION 2]
        6 - 5 -> 1 [OPTION 3]
        7 - 10 -> invalid 
        7 -1 -> 6 [OPTION 4]***
        7 -5 -> 2 [OPTION 5]
        7- 6 -> 1 [OPTION 6]
        1 - 10 -> invalid 
        ... 
        1 - 1 -> 0 [OPYION 7]
        */   

        /**3. Brute force 
        doing all pairwise calculations 
        O(n^2)
        */

        /**4. Better approach
        -//  want to do this in one pass of the array 
        - two pointers 
        - buy = 0, sell = 1 
        - ***always enforce that buy > sell
        - comparisions
            - if buy > sell --> swap (buy, sell)
            - if buy <= sell --> profit = profit[sell] - profit[buy] + 1
        - Math.max(max, profit[sell] - profit[buy] + 1)
        */ 

        /**5. Complexity
        - one pass, O(1) constant time operations of comparisons 
        per iteration thus O(n)
        */

        //CODE 
        /** 6. Psuedocode algorithm : two pointers 
        - initialize buy pointer and sell pointer
        - buy = index 0, sell = index 1
        - if buy > sell, buy = sell and sell = buy + 1
        - compute max profit with this buy and all sells afterwards until you come 
            across another buy that is less than the current buy 
        */

        int buy = 0; 
        int max = 0; 

        for (int sell = 1; sell < prices.length; sell++){
            if (prices[buy] > prices[sell]){
                buy = sell; 
                if (buy + 1 < prices.length) sell = buy + 1;
            }
            max = Math.max(max, prices[sell]-prices[buy]);
        }

        return max;

    /**7a. Dry run 
    [2, 1]
    buy = 0 max = 0 
    sell = 1: 
        2 > 1 -> true -> buy = 1 sell = 2 

    */

    /**7b. Dry run 
    [10,1,5,6,7,1]

    buy = 0 max = 0 
    sell = 1: 
        if 10 > 1 -> true 
            buy = 1
            sell = 2
        max = max(0, 5-1+1) = 5
    
    sell = 3: 
        if 1 > 6 -> false 
        max = max(5, 6-1+1) = 6 
    
    sell = 4: 
        ...

    */ 

        
}
}
