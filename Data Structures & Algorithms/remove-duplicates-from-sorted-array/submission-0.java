class Solution {
    public int removeDuplicates(int[] nums) {

        int i=0; int j=i+1;

        /**
        Idea is to shift second pointer until a different number is hit
        and then increment the first pointer by 1 (because that's supposed
        to be the index of next unique number). And then overwrite the value
        at first pointer by the value at second pointer
        **/

        while (i < nums.length - 1 && j < nums.length) {
            while (j < nums.length && nums[i] == nums[j]) j++;
            i++;
            if(j == nums.length) return i;
            nums[i] = nums[j];
        }
        return i+1;

    }
}