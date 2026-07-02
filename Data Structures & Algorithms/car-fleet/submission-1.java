class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pair = new int[position.length][2];
        for(int i = 0; i < position.length; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }

        Arrays.sort(pair, (a,b) -> Integer.compare(a[0], b[0]));
        Stack<Float> stack = new Stack();

        for(int i = position.length - 1; i >= 0; i--) {
            float time = (float)(target - pair[i][0]) / pair[i][1];
            
            if (stack.isEmpty() || stack.peek() < time) {
                stack.add(time);
            }
        }
        return stack.size();
    }
}
