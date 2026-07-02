class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int noOfDays = temperatures.length;
        int[] res = new int[noOfDays];

        Stack<int[]> stack = new Stack();
        for(int i = noOfDays - 1; i >= 0; i--) {
            int currTemp = temperatures[i];
            while(!stack.isEmpty() && stack.peek()[0] <= currTemp) {
                stack.pop();
            }
            if (!stack.isEmpty() && stack.peek()[0] > currTemp)
                res[i] = stack.peek()[1] - i;
                
            stack.push(new int[]{currTemp, i});
        }
        return res;
    }
}
