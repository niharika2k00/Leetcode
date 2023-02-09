class Solution
{
public:
    int minOperations(vector<int> &nums, int x)
    {
        int len = nums.size(), sum = 0, subArrSum = 0, maxLength = -1;
        int i = 0, j = 0;

        sum = accumulate(nums.begin(), nums.end(), 0);

        if (x > sum)
            return -1;
        int remain = sum - x; //  11 - 5 = 6

        // Now we have to find the Longest Subarray with  SUM  = 6
        for (i = 0; i < len; i++)
        {
            subArrSum += nums[i];

            while (subArrSum > remain)
            {
                subArrSum = subArrSum - nums[j]; // delete the first element from the window
                j++;
            }

            if (subArrSum == remain)
                maxLength = max(maxLength, i - j + 1);
            // else if (subArrSum > remain)
            // {

            // }
        }

        return maxLength == -1 ? -1 : len - maxLength;
    }
};
