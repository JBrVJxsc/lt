public class TwoSum {

    Map<Integer, Integer> map = new HashMap<>();
    
    // Add the number to an internal data structure.
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int dif = value - entry.getKey();
            if (dif == entry.getKey()) {
                if (entry.getValue() > 1) {
                    return true;
                }
            } else {
                if (map.get(dif) != null && map.get(dif) > 0) {
                    return true;
                }
            }
        }
        return false;
    }
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);