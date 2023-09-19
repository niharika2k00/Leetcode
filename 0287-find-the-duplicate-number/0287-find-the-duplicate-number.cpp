class Solution {
public:

// Method: Making visited values negative
    int findDuplicate(vector<int>& nums) {
        int len = nums.size();

        for(int i=0; i<len; i++){
            int idx = abs(nums[i]); // value

            if(nums[idx] < 0)
                return idx;
            nums[idx] = -nums[idx];
        }

        return len;
    }

// METHOD - I
// Time Complexity : O(n logn)                   Don't do it :)
// Space Complexity : O(1)
        //  int len = nums.size(), i;
        //  sort(nums.begin(), nums.end()); //  Java :   Arrays.sort(nums);

        //  for (i = 1; i < len; i++)
        //      if (nums[i - 1] == nums[i])
        //          return nums[i];

        //  return -1;

// METHOD - II
// Time Complexity : O(n) [Hare & Tortoise ---> Cycle Detection ]
// Space Complexity : O(1)
        // while (nums[0] != nums[nums[0]])
        //     swap(nums[0], nums[nums[0]]);

        // return nums[0];

// METHOD - III
// Time Complexity : O(n) [Hare & Tortoise ---> Cycle Detection ]
// Space Complexity : O(1)
        // int slow = 0, fast = 0;
        //  slow = nums[0];
        //  fast = nums[0];

        //  do
        //  {
        //      slow = nums[slow];
        //      fast = nums[nums[fast]]; // 2 Step Jump
        //  } while (slow != fast);

        //  fast = nums[0]; // Reassign with the first index
        //  while (slow != fast)
        //  {
        //      slow = nums[slow];
        //      fast = nums[fast];
        //  }

        //  return slow;
};