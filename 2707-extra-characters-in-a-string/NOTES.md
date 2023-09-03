In the solve function-
​
* If index is equal to size of the string, return 0 since we've completed our task
* if dp[index] != -1 we've already calculated our answer for this index so return dp[index]
* Now, create a empty string currStr, this will store string formed till current index
minExtra stores the minimum size of extra chars required
* Iterate from cutIdx = 0 to s.size() and push the current character into our empty string.
* Now check if our currString is present in map or not, if it is our currExtra will be 0 , since no extra chars required, else it will be currStr.size().
* In nextExtra we're finding extra chars in the string that will be formed after the current string i.e from index cutIndex + 1 to s.size().
* totalExtra will be sum of the two calculate extras, i.e current and next.
* minExtra would store the minimum of all totalExtras.
* At last we return dp[index] = minExtra , here we are basically assigning minExtra to dp[index] and at the same time returning dp[index].