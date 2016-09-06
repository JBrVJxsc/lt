public class TwoSum {

    private Map<Integer, Integer> map = new LinkedHashMap<>();
    
    // Add the number to an internal data structure.
    public void add(int num) {
        int n = map.getOrDefault(num, 0) + 1;
        map.put(num, n);
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int dif = value - num;
            if (dif == num) {
                int count = entry.getValue();
                if (count > 1) {
                    return true;
                }
            } else if (map.get(dif) != null) {
                return true;
            }
        }
        return false;
    }
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);