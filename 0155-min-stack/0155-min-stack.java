
class MinStack {
  Stack<Integer> stack;
  Stack<Integer> minStack;

  // constructor
  public MinStack() {
    stack = new Stack<>();
    minStack = new Stack<>();
  }

  public void push(int val) {
    stack.push(val);

    if (minStack.isEmpty() || val <= minStack.peek()) // curr val is min/less than stack top
      minStack.push(val);
    else { // curr val is more than stack top
      // int minEle = minStack.peek();
      // minStack.pop();
      // minStack.push(val);
      // minStack.push(minEle);
      minStack.push(minStack.peek()); // push the min again
    }
  }

  public void pop() {
    if (!stack.isEmpty())
      stack.pop();

    if (!minStack.isEmpty())
      minStack.pop();
  }

  public int top() {
    if (!stack.isEmpty())
      return stack.peek();
    return 0;
  }

  public int getMin() {
    if (!minStack.isEmpty())
      return minStack.peek();
    return 0;
  }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */