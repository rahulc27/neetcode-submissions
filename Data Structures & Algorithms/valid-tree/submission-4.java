class Solution {
    HashMap<Integer, List<Integer>> adjMap = new HashMap();
    Set<Integer> visited = new HashSet();

    public boolean validTree(int n, int[][] edges) {
        for(int[] edge : edges) {
            if(!adjMap.containsKey(edge[0]))
                adjMap.put(edge[0], new ArrayList());
            if(!adjMap.containsKey(edge[1]))
                adjMap.put(edge[1], new ArrayList());
            adjMap.get(edge[0]).add(edge[1]);
            adjMap.get(edge[1]).add(edge[0]);
        }
        
        if (!dfs(0, -1))
            return false;
            
        return visited.size() == n;
    }

    public boolean dfs(int currNode, int prevNode) {
        if (visited.contains(currNode))
            return false;
        
        visited.add(currNode);
        for(int nextNode : adjMap.getOrDefault(currNode, Collections.emptyList()))
            if (nextNode != prevNode) {
                if (!dfs(nextNode, currNode))
                    return false;
            }
                
        return true;
    }
}
