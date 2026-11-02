class Solution {
    int houseRobber1(int[] nums, int l, int r) {
        if (l > r) return nums[0];

        int rob1 = 0;
        int rob2 = 0;
        int t = 0;

        for (int i = r; i >= l; i--) {
            t = Math.max(rob1, nums[i] + rob2);
            rob2 = rob1;
            rob1 = t;
        }

        return rob1;
    }


    public int rob(int[] nums) {
        return Math.max(
        houseRobber1(nums, 0, nums.length - 2),
        houseRobber1(nums, 1, nums.length - 1));
    }
}
