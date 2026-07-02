class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        Set<String> operator = new HashSet(Arrays.asList("+", "-", "*", "/"));

        for(String token : tokens) {
            if (!operator.contains(token)) {
                stack.add(Integer.parseInt(token));
            } else {
                int v2 = stack.pop();
                int v1 = stack.pop();

                switch(token) {
                    case "+":
                        stack.add(v1 + v2);
                        break;
                    case "-":
                        stack.add(v1 - v2);
                        break;
                    case "*":
                        stack.add(v1 * v2);
                        break;
                    case "/":
                        stack.add(v1 / v2);
                        break;
                }
            }
        }

        return stack.peek();
    }
}
