import java.util.HashMap;

/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */
// Any 2 number from the list having , whose addition is == TARGET
// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[] res = null;

        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];

            if (hashMap.containsKey(difference)) {
                res = new int[] { i, hashMap.get(difference) };
            }

            hashMap.put(nums[i], i); // storing value, index as need to return index
        }

        return res;
    }
}
// @lc code=end

/*
 * KEY --> Value of Array
 * VALUE --> Index
 */