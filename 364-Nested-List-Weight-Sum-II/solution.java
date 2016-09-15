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
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        
        int depth = 0;
        for (NestedInteger node : nestedList) {
            depth = Math.max(depth, getDepth(node, 0));
        }
        
        int sum = 0;
        for (NestedInteger node : nestedList) {
            sum += dfs(node, depth);
        }        
        return sum;
    }
    
    private int dfs(NestedInteger root, int depth) {
        if (root == null) {
            return 0;
        }
        if (root.isInteger()) {
            return root.getInteger() * depth;
        }
        int sum = 0;
        for (NestedInteger node : root.getList()) {
            sum += dfs(node, depth - 1);
        }        
        return sum;
    }
    
    private int getDepth(NestedInteger root, int depth) {
        if (root == null) {
            return depth;
        }
        if (root.isInteger()) {
            return depth + 1;
        }
        int max = 0;
        for (NestedInteger node : root.getList()) {
            max = Math.max(max, getDepth(node, depth + 1));
        }
        return max;
    }
}