class Solution {
    public boolean hasDuplicate(int[] nums) {
        // return hasDuplicateVersion1(nums);
        return hasDuplicateVersion2(nums);
    }

    private boolean hasDuplicateVersion1(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            uniqueNums.add(nums[i]);
        }
        return uniqueNums.size() != nums.length;
    }

    private boolean hasDuplicateVersion2(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(uniqueNums.contains(nums[i])) {
                return true;
            }
            uniqueNums.add(nums[i]);
        }
        return false;
    }
}
