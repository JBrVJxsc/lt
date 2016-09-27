public class MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();
    Stack<Integer> size = new Stack<>();
    
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            min.push(x);
            size.push(stack.size());
        } else {
            if (x < min.peek()) {
                stack.push(x);
                min.push(x);
                size.push(stack.size());
            } else {
                stack.push(x);
                // size.pop();
                // size.push(stack.size());
            }
        }
    }
    
    public void pop() {
        stack.pop();
        if (stack.size() < size.peek()) {
            min.pop();
            size.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */