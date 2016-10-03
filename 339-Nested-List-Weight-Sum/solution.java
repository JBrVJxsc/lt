/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public int depthSum(List<NestedInteger> lists) {
        if (lists == null) {
            return 0;
        }
        int sum = 0;
        
        for (NestedInteger list : lists) {
            sum += dfs(list, 1);
        }
        
        return sum;
    }
    
    private int dfs(NestedInteger list, int depth) {
        if (list.isInteger()) {
            return list.getInteger() * depth;
        }
        int sum = 0;
        for (NestedInteger l : list.getList()) {
            sum += dfs(l, depth + 1);
        }
        return sum;
    }
}