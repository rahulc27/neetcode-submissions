class Solution {
    public int minCostClimbingStairs(int[] cost) {

        if (cost.length == 2)
            return Math.min(cost[0], cost[1]);
        
        int firstStep = cost[0], secondStep = cost[1], currStep = 0;
        for (int i = 2; i < cost.length; i++) {
            currStep = cost[i] + Math.min(firstStep, secondStep);
            firstStep = secondStep;
            secondStep = currStep;
        }
        return Math.min(firstStep, secondStep);
    }
}
