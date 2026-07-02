class Solution {
    HashMap<Integer, List<Integer>> adjList = new HashMap();
    Set<Integer> pathVisited = new HashSet();
    Set<Integer> visited = new HashSet();
    List<Integer> res = new ArrayList();

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        for(int[] prereq : prerequisites) {
            if(!adjList.containsKey(prereq[0]))
                adjList.put(prereq[0], new ArrayList());

            adjList.get(prereq[0]).add(prereq[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if(!visited.contains(i)) {
                if(!checkCycleAndFindOrder(i))
                    return new int[0];
            }
        }
        int[] arr = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            arr[i] = res.get(i);
        }
        return arr;
    }

    private boolean checkCycleAndFindOrder(int currCourse) {
        if (pathVisited.contains(currCourse)) {
            return false;
        }
        if (visited.contains(currCourse)) 
            return true;

        pathVisited.add(currCourse);
        visited.add(currCourse);

        for(int i : adjList.getOrDefault(currCourse, Collections.emptyList())) {
            if (!checkCycleAndFindOrder(i))
                return false;
        }
        pathVisited.remove(currCourse);
        res.add(currCourse);
        System.out.println(currCourse);
        return true;
    }
}
