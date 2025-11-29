class Solution {
    public boolean isPalindrome(String s) {
      int len = s.length();
      int start=0, end=len-1;
      char[] arr = s.toCharArray();
      
      if (len <= 1) return true;
      
      // for(char i: s.toCharArray()) {
      while (start <= end){
        if (!Character.isLetterOrDigit(arr[start])) start++;
        if (!Character.isLetterOrDigit(arr[end])) end--;

        if (Character.isLetterOrDigit(arr[start]) && Character.isLetterOrDigit(arr[end])) {
          if (Character.toLowerCase(arr[start]) ==  Character.toLowerCase(arr[end])) {
            start++;
            end--;
            continue;
          }
          else 
            return false;
        }
      }

      return true;
    }
}