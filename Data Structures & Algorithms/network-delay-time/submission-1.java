class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        HashMap<Integer, List<int[]>> adjMap = new HashMap();

        for(int[] time : times) {
            if(!adjMap.containsKey(time[0]))
                adjMap.put(time[0], new ArrayList());
            
            adjMap.get(time[0]).add(new int[]{time[1], time[2]});
        }

        int time = 0;
        HashSet visited = new HashSet();

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        minHeap.add(new int[]{0, k});

        while(!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int currWeight = curr[0];
            int currNode = curr[1];
            System.out.println(currNode);
            if(visited.contains(currNode)) {
                continue;
            }

            visited.add(currNode);
            time = Math.max(time, currWeight);

            for(int[] adjNode : adjMap.getOrDefault(currNode, Collections.emptyList())) {
                if(!visited.contains(adjNode[0])) {
                    minHeap.add(new int[]{currWeight + adjNode[1], adjNode[0]});
                }
            }
        }
        return visited.size() == n ? time : -1;
    }
}
