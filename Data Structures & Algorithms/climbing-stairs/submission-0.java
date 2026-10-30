class Solution {
    public int climbStairs(int n) {
        
        // top down



        // bottom up 

        int[] dp = {1, 0}; // base case
        for (int i=0; i < n; i++) {
            // i is just for counter
            int t = dp[0] + dp[1];
            dp[1] = dp[0];
            dp[0] = t;
            // the two sized array is like a window of size 2
            // which will move from right to left
            //  0  1       t  becomes dp[0] after dp[1] moves to dp[0]
            // [1, 0]      1
            //   \\
            // [1, 1]      2
            //   \\         
            // [2, 1]      3 
            //   \\         
            // [3, 2]      5 
            //   \\         
            // [5, 3]      8 
            //   \\         
            // [8, 5]      13 
        }
        return dp[0];



    }
}
