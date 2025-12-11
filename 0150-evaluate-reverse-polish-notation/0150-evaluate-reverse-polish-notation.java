class Solution {
  public boolean isOperator(String s) {
    // https://www.w3schools.com/java/ref_string_contains.asp
    // here we can also use contains but couldn't use bcz e.g "-11".contains("-") it will be wrong
    return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
  }

  public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();

    for (String s : tokens) {
      if (isOperator(s)) { // if encounter an operator
        int a = !stack.empty() ? stack.pop() : 0;
        int b = !stack.empty() ? stack.pop() : 0;

        if (s.equals("+"))
          stack.push(a + b);
        else if (s.equals("-"))
          stack.push(b - a);
        else if (s.equals("*"))
          stack.push(a * b);
        else if (s.equals("/"))
          stack.push(b / a);
      } else
        stack.push(Integer.valueOf(s));
    }

    return stack.pop();
  }
}