public class MinStack {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> min = new Stack<>();
    private Stack<Integer> size = new Stack<>();
    
    /** initialize your data structure here. */
    public MinStack() {
        min.push(Integer.MAX_VALUE);
        size.push(1233);
    }
    
    public void push(int x) {
        stack.push(x);
        if (x < getMin()) {
            min.push(x);
            size.push(1);
        } else {
            size.push(size.pop() + 1);
        }
    }
    
    public void pop() {
        stack.pop();
        int temp = size.pop() - 1;
        if (temp == 0) {
            min.pop();
        } else {
            size.push(temp);
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