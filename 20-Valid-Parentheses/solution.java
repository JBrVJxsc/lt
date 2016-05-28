public class Solution {
  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
      if (stack.isEmpty()) {
        stack.push(c);
      } else {
        if (c == '{' || c =='[' || c == '(') {
          stack.push(c);
        } else {
          if (c == '}' && stack.peek() == '{' || c == ')' && stack.peek() == '(' || c == ']' && stack.peek() == '[') {
            stack.pop();
          } else {
            stack.push(c);
          }
        }
      }
    } 
    return stack.isEmpty();
  }
}