class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for (char c : tasks) {
            freq.put(c, 1 + freq.getOrDefault(c, 0));
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(freq.values());

        Queue<int[]> queue = new LinkedList<int[]>();

        int time = 0;

        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            time += 1;
            if (!maxHeap.isEmpty()) {
                int currFreq = maxHeap.poll() - 1;
                if (currFreq > 0) {
                    queue.add(new int[]{currFreq, time + n});
                }               
            }
            if (!queue.isEmpty()) {
                int[] firstTask = queue.peek();
                if (firstTask[1] == time) {
                    maxHeap.add(queue.poll()[0]);
                }
            }
        }

        return time;
    }
}
