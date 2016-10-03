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
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList == null) {
            return 0;
        }
        
        int max = 0;
        for (NestedInteger item : nestedList) {
            max = Math.max(max, getMaxDepth(item, 1));
        }
        
        int sum = 0;
        for (NestedInteger item : nestedList) {
            sum += dfs(item, max);
        }        
        
        return sum;
    }
    
    private int getMaxDepth(NestedInteger ni, int depth) {
        if (ni.isInteger()) {
            return depth;
        }
        
        int max = depth;
        
        for (NestedInteger item : ni.getList()) {
            max = Math.max(max, getMaxDepth(item, depth + 1));
        }
        
        return max;
    }
    
    private int dfs(NestedInteger ni, int depth) {
        if (ni.isInteger()) {
            return ni.getInteger() * depth;
        }
        
        int sum = 0;
        
        for (NestedInteger item : ni.getList()) {
            sum += dfs(item, depth - 1);
        }        
        
        return sum;
    }
}