class Solution {
    public int hammingWeight(int n) {
      String binary = Integer.toBinaryString(n);
      int counter=0;
    
      for (int i: binary.toCharArray()) {
        if (i == '1') counter++;
      }
      
      return counter;
    }
}