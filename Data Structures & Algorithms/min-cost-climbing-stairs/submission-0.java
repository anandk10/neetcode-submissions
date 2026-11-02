class Solution {

    int[] cache;
    public int minCostClimbingStairs(int[] cost) {


        // topdown
        cache = new int[cost.length];
        Arrays.fill(cache, -1);

        return Math.min(dfs(cost, 0), dfs(cost, 1));
    }


    int dfs(int[] cost, int id) {
        if (id >= cost.length) {
            // return Integer.MAX_VALUE; // not a good idea for the last element's edge case
            return 0;
        }

        if (cache[id] != -1) {
            return cache[id];
        }

        cache[id] = cost[id] + Math.min(
            dfs(cost, id + 1),
            dfs(cost, id + 2)
        );
        return cache[id];
    }
}
