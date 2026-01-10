class Solution {
  List<String> res = new ArrayList<>();

  public List<String> letterCombinations(String digits) {
    HashMap<Character, String> digitToLetters = new HashMap<>();

    digitToLetters.put('2', "abc");
    digitToLetters.put('3', "def");
    digitToLetters.put('4', "ghi");
    digitToLetters.put('5', "jkl");
    digitToLetters.put('6', "mno");
    digitToLetters.put('7', "pqrs");
    digitToLetters.put('8', "tuv");
    digitToLetters.put('9', "wxyz");

    StringBuilder temp = new StringBuilder();
    backtrack(digits, 0, digitToLetters, temp);

    return res;
  }

  private void backtrack(String digits, int idx, HashMap<Character, String> digitToLetters, StringBuilder temp) {
    if (idx >= digits.length()) { // base case
      res.add(temp.toString());
      return;
    }

    String letters = digitToLetters.get(digits.charAt(idx));

    for (char letter : letters.toCharArray()) { // a b c
      temp.append(letter);
      backtrack(digits, idx + 1, digitToLetters, temp);
      temp.deleteCharAt(temp.length() - 1);
    }
  }
}