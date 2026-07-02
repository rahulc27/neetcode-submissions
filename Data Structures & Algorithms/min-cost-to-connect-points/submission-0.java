class Solution {
    public int minCostConnectPoints(int[][] points) {
        int numOfPoints = points.length;
        HashMap<Integer, List<int[]>> adjMap = new HashMap();
        for(int i = 0; i < numOfPoints; i++) {
            adjMap.put(i, new ArrayList());
        }

        //creating adj list
        for(int i = 0; i < numOfPoints; i++) {
            //point 1
            int x1 = points[i][0], y1 = points[i][1];

            for(int j = i+1; j < numOfPoints; j++) {
                //point 2
                int x2 = points[j][0], y2 = points[j][1];
                int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);

                adjMap.get(i).add(new int[]{dist, j}); //{i : [[dist, j]]}
                adjMap.get(j).add(new int[]{dist, i}); //{j : [[dist, i]]}
            }
        }

        int res = 0;
        Set<Integer> visited = new HashSet();

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        minHeap.add(new int[]{0,0}); // {dist, node}

        while(visited.size() != numOfPoints) {
            int[] curr = minHeap.poll();
            int dist = curr[0];
            int node = curr[1];
            if (visited.contains(node))
                continue;
            
            visited.add(node);
            res += dist;

            for(int[] adjNode : adjMap.getOrDefault(node, Collections.emptyList())) {
                if(!visited.contains(adjNode[1])) {
                    minHeap.add(new int[]{adjNode[0], adjNode[1]});
                }
            }
        }
        return res;
    }
}
