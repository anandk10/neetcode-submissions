class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> lkp = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if(lkp.containsKey(diff)) {
                res[0] = lkp.get(diff);
                res[1] = i;
            } else {
                lkp.put(nums[i], i);
            }
        }

        return res;
    }
}
