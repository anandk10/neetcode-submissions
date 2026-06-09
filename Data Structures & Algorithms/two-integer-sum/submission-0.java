class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> lookup = new HashMap<>();
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++) {
            if (lookup.containsKey(target - nums[i])) {
                result = new int[]{lookup.get(target - nums[i]), i};
            } else {
                lookup.put(nums[i], i);
            }
        }
        return result;
        
    }
}
