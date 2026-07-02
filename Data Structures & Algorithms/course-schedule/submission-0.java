class Solution {
    HashMap<Integer, List<Integer>> adjList = new HashMap();
    Set<Integer> visited = new HashSet();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int[] preReq : prerequisites) {
            if(!adjList.containsKey(preReq[0])) {
                adjList.put(preReq[0], new ArrayList());
            } 
            adjList.get(preReq[0]).add(preReq[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if(checkCycle(i))
                return false;
        }
        return true;
    }

    private boolean checkCycle(int currCourse) {
        if (visited.contains(currCourse))
            return true;
        boolean isCycle = false;
        visited.add(currCourse);

        for(Integer i : adjList.getOrDefault(currCourse, Collections.emptyList()))
            isCycle = isCycle || checkCycle(i);

        visited.remove(currCourse);
        return isCycle;
    }
}
