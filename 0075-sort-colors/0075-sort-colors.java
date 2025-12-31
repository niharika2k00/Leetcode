class Solution {
  public void sortColors(int[] nums) {
    int len = nums.length, idx = 0;
    HashMap<Integer, Integer> hm = new HashMap<>();

    for (int i : nums) {
      hm.put(i, hm.getOrDefault(i, 0) + 1); // frequency count
    }

    for (int color = 0; color < 3; color++) {
      if (hm.containsKey(color)) {
        int freq = hm.get(color);

        for (int i = 0; i < freq; i++) {
          nums[idx] = color;
          idx++;
        }
      }
    }
  }
}

// Method 2: calculate frequency without hashmap
// class Solution {
//   public void sortColors(int[] nums) {
//     int zero = 0, one = 0, two = 0;
//     for (int n : nums) {
//       if (n == 0)
//         zero++;
//       else if (n == 1)
//         one++;
//       else
//         two++;
//     }

//     for (int i = 0; i < nums.length; i++) {
//       if (zero > 0) {
//         nums[i] = 0;
//         zero--;
//       } else if (one > 0) {
//         nums[i] = 1;
//         one--;
//       } else {
//         nums[i] = 2;
//         two--;
//       }
//     }
// }}