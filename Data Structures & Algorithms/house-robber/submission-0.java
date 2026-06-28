class Solution {
    public int rob(int[] nums) {
        // [1,1,3,3]
        /*
        rob(i) indicates the maximum value obtained upto the index i.

        rob(i) = max(
                        nums[i] + rob(i-2),
                        rob(i-1)
                    ) 

        */

        int rob1 = 0; // represents rob(i-2)
        int rob2 = 0; // represents rob(i-1)

        for (int n : nums) {
            int temp = Math.max(n + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }

        return rob2;
    }
}
