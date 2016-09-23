public class RandomizedCollection {

    Map<Integer, Set<Integer>> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    Random random = new Random();

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.get(val) == null) {
            map.put(val, new HashSet<>());
        }
        list.add(val);
        Set<Integer> temp = map.get(val);
        temp.add(list.size() - 1);
        return temp.size() == 1;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        Set<Integer> temp = map.get(val);    
        if (temp == null || temp.size() == 0) {
            return false;
        }
        int index = temp.iterator().next();
        temp.remove(index);
        
        if (index != list.size() - 1) {
            int last = list.get(list.size() - 1);
            temp = map.get(last);
            temp.remove(list.size() - 1);
            temp.add(index);
            list.set(index, last);
        }
        list.remove(list.size() - 1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */