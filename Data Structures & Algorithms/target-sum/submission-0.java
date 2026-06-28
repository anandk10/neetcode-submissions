class Solution {

    class TargetSumSolution {
        record Key(int index, int total) {};
        int[] nums; int target;
        Map<Key, Integer> DP = new HashMap<>();

        TargetSumSolution(int[] nums, int target) {
            this.nums = nums;
            this.target = target;
        }

        int backtrack(Key data) {
            int i = data.index();
            int t = data.total();

            if (i == nums.length) {
                return t == target ? 1 : 0;
            }

            if (DP.containsKey(data)) {
                return DP.get(data);
            }

            DP.put(data, 
                    backtrack(new Key(i + 1, t + nums[i])) 
                    + backtrack(new Key(i + 1, t - nums[i])));

            return DP.get(data);
        }
    }

    public int findTargetSumWays(int[] nums, int target) {
        return new TargetSumSolution(nums, target)
            .backtrack(new TargetSumSolution.Key(0, 0));
    }
}
