public class MedianFinder {

    private Queue<Integer> large = new PriorityQueue<>();
    private Queue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());

    // Adds a number into the data structure.
    public void addNum(int num) {
        large.add(num);
        small.add(large.remove());
        if (small.size() > large.size()) {
            large.add(small.remove());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (small.size() == large.size()) {
            return (double)(large.peek() + small.peek()) / 2;
        } else {
            return large.peek();
        }
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();