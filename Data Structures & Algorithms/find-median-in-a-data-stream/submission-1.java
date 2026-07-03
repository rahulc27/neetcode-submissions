class MedianFinder {

    PriorityQueue<Integer> minNumberHeap;
    PriorityQueue<Integer> maxNumberHeap;

    public MedianFinder() {
        minNumberHeap = new PriorityQueue(Collections.reverseOrder());
        maxNumberHeap = new PriorityQueue();
    }
    
    public void addNum(int num) {
        minNumberHeap.add(num);

        if (!maxNumberHeap.isEmpty() && minNumberHeap.peek() > maxNumberHeap.peek()) {
            maxNumberHeap.add(minNumberHeap.poll());
        }
        if(minNumberHeap.size() > maxNumberHeap.size() + 1) {
            maxNumberHeap.add(minNumberHeap.poll());
        }
        if(maxNumberHeap.size() > minNumberHeap.size() + 1) {
            minNumberHeap.add(maxNumberHeap.poll());
        }
    }
    
    public double findMedian() {
        if (maxNumberHeap.size() == minNumberHeap.size()) {
            return (double) (maxNumberHeap.peek() + minNumberHeap.peek()) / 2;
        }
        if (maxNumberHeap.size() > minNumberHeap.size()) {
            return maxNumberHeap.peek();
        }
        
        return minNumberHeap.peek();
    }
}
