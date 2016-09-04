public class RandomizedCollection {

    private Map<Integer, Set<Integer>> map = new HashMap<>();
    private List<Integer> nums = new ArrayList<>();
    private Random random = new Random();
    
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.get(val) == null) {
            map.put(val, new HashSet<>());
        }
        map.get(val).add(nums.size());
        nums.add(val);
        return map.get(val).size() == 1;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (map.get(val) == null || map.get(val).size() == 0) {
            return false;
        }
        Set<Integer> set = map.get(val);
        int index = set.iterator().next();
        set.remove(index);
        
        if (index != nums.size() - 1) {
            int last = nums.get(nums.size() - 1);
            nums.set(index, last);
            map.get(last).add(index);
            map.get(last).remove(nums.size() - 1);
        }
        
        nums.remove(nums.size() - 1);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */