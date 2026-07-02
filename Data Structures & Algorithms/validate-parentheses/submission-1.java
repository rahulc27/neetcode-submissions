class Solution {
    
    public boolean isValid(String s) {
        HashMap<Character, Character> closeToOpenMap = new HashMap();
        closeToOpenMap.put(')', '(');
        closeToOpenMap.put('}', '{');
        closeToOpenMap.put(']', '[');

        Stack<Character> stack = new Stack();

        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
                stack.add(s.charAt(i));
                continue;
            }
            
            if (stack.isEmpty() || closeToOpenMap.get(s.charAt(i)) != stack.peek())
                return false;  
            
            stack.pop();
        }
        return stack.isEmpty();
    }
}
