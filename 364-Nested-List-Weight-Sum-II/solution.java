/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public int depthSumInverse(List<NestedInteger> list) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        
        for (NestedInteger n : list) {
            max = Math.max(max, getDepth(n, 1));
        }        
        
        for (NestedInteger n : list) {
            sum += dfs(n, max);
        }
        
        return sum;
    }
    
    private int dfs(NestedInteger head, int depth) {
        if (head.isInteger()) {
            return head.getInteger() * depth;
        }
        
        int sum = 0;
        
        for (NestedInteger n : head.getList()) {
            sum += dfs(n, depth - 1);
        }
        
        return sum;        
    }
    
    private int getDepth(NestedInteger head, int depth) {
        if (head.isInteger()) {
            return depth;
        }
        int max = Integer.MIN_VALUE;
        
        for (NestedInteger n : head.getList()) {
            max = Math.max(max, getDepth(n, depth + 1));
        }
        
        return max;
    }
}