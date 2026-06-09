class Solution {
    public int[] twoSum(int[] numbers, int target) {
       int i=0; 
       int j=numbers.length-1;
       for(; i < j;) {
        int tmpSum = numbers[i] + numbers[j];
        if (tmpSum > target) j--;
        else if (tmpSum < target) i++;
        else break;
       }
       return new int[]{i+1, j+1};
    }
}
