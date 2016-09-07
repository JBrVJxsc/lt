public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (String str : tokens) {
            if (str.equals("+")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a + b);
            } else if (str.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if (str.equals("*")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a * b);
            } else if (str.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();            
                stack.push(b / a);                
            } else {
                stack.push(Integer.valueOf(str));
            }
        }
        
        return stack.pop();
    }
}