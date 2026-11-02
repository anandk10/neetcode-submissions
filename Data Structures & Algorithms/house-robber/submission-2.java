class Solution {


    public int rob(int[] nums) {

        // [rob1, rob2] represented as two independent ints 
        // but think of them as a window 
        // [1,2,3,1] [0,0]
        int rob1 = 0;
        int rob2 = 0;
        int t = 0;
        // traversing from right to left
        for (int i = nums.length - 1; i >= 0; i--) {
            t = Math.max(rob1, nums[i] + rob2);
            rob2 = rob1;
            rob1 = t;
        }

        return rob1;

        /**
        [1,2,3,1] [0,0]

        i   nums[i] r1  r2  t
                    0   0   0
        3   1       1   0   1
        2   3       3   1   3 
        1   2       3   3   3
        0   1       4   3   4         
        **/



    }


    // 11/01/26 --> The following solution moves the window left to right
    // trying a new solution that moves the window right to left
    // public int rob(int[] nums) {
    //     // [1,1,3,3]
    //     /*
    //     rob(i) indicates the maximum value obtained upto the index i.

    //     rob(i) = max(
    //                     nums[i] + rob(i-2),
    //                     rob(i-1)
    //                 ) 

    //     */

    //     int rob1 = 0; // represents rob(i-2)
    //     int rob2 = 0; // represents rob(i-1)

    //     for (int n : nums) {
    //         int temp = Math.max(n + rob1, rob2);
    //         rob1 = rob2;
    //         rob2 = temp;
    //     }

    //     return rob2;
    // }


    /**
        Here's your flash card for the House Robber algorithm:

---

**Front**

**House Robber**  
Given `nums` array, max money you can rob without robbing adjacent houses.

---

**Back**

**Recurrence**  
`rob(i) = max( nums[i] + rob(i-2), rob(i-1) )`  
*Decide: rob current + best up to 2 houses back **OR** skip current and keep best up to 1 house back.*

**Optimized DP (O(1) space)**  
1. `rob1 = 0`, `rob2 = 0`  
2. For each `n` in `nums`:  
   `temp = max(n + rob1, rob2)`  
   `rob1 = rob2`  
   `rob2 = temp`  
3. Return `rob2`

**Complexity**  
Time O(n), Space O(1)

**Example**  
`[1,1,3,3]` → `rob2` evolves: 0 → 1 → 1 → 4 → 4, return 4.

---

Keep this handy for quick recall during practice. Need any adjustments?

    */
}
