class Solution {
    public int climbStairs(int n) {
        
        // top down
        return topdown(n);


        // bottom up 
        // return bottomup(n);
    }

    
    int topdown(int n) {
        int[] cache = new int[n+1];
        Arrays.fill(cache, -1);
        // - every decision point has two choices
        // either climb 1 step or 2
        // - memoize on the outcome of the count/addition
        // - the base case here is reaching the nth step
        // which is reaching the target, so counts as 1
        // - going over the target must count as 0
        // - and always consult the dp table to check if
        // you have already computed the sum.

        return dfs(0, n, cache);
    }


    int dfs(int curr, int n, int[] cache) {

        if (curr > n) {
            return 0;
        }

        if (cache[curr] != -1) {
            // this has been computed before
            return cache[curr];
        }
        
        if (curr == n) {
            cache[curr] = 1;

            return cache[curr];
        }

        cache[curr] = dfs(curr + 1, n, cache) + dfs(curr + 2, n, cache);
        return cache[curr];
    }

    

    int bottomup(int n) {
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
