class Solution {
    public int maxProfit(int[] prices) {
        /**
        [10,1,5,6,7,1]
         l  r
            l r {4}
            l   r {5}
            l     r {6}--max
            l       r {0}

        **/


        int l = 0, r = 1;
        int max = 0;

        while (r < prices.length) {
            
            if (prices[l] < prices[r]) {
                // better prices to sell found; then update max
                // and increment r to go to the next sell price
                max = Math.max(max, prices[r]-prices[l]);
                r += 1;
            } else {
                // a new lower price is found, so update the l pointer
                // and set r to the next day i.e. l + 1
                l = r;
                r = l+1;
            }
        }
        return max;
    }
}
