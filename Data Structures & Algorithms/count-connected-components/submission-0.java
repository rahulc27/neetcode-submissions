class Solution {
    Set<Integer> visited = new HashSet();
    HashMap<Integer, List<Integer>> adjMap = new HashMap();

    public int countComponents(int n, int[][] edges) {

        for(int[] edge : edges) {
            if (!adjMap.containsKey(edge[0]))
                adjMap.put(edge[0], new ArrayList());
            if (!adjMap.containsKey(edge[1]))
                adjMap.put(edge[1], new ArrayList());

            adjMap.get(edge[0]).add(edge[1]);
            adjMap.get(edge[1]).add(edge[0]);
        }

        int compCount = 0;

        for(int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                compCount++;
                dfs(i);
            }
        }

        return compCount;
    }

    private void dfs(int currNode) {
        if (visited.contains(currNode))
            return;

        visited.add(currNode);
        for(int nextNode : adjMap.getOrDefault(currNode, Collections.emptyList())) {
            dfs(nextNode);
        }
    }
}
