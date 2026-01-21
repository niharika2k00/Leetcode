class Solution {
  List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> subsets(int[] nums) {
    List<Integer> subset = new ArrayList<>();
    backtrack(0, subset, nums);

    return result;
  }

  private void backtrack(int idx, List<Integer> subset, int[] nums) {
    if (idx >= nums.length) {
      result.add(new ArrayList<>(subset));
      return;
    }

    // case 1: if we pick the element
    subset.add(nums[idx]);
    backtrack(idx + 1, subset, nums);
    subset.remove(subset.size()-1); // remove 1 digit from the subset

    // case 2: do not pick
    backtrack(idx + 1, subset, nums);
  }
}