class Solution {
    private List<String> res = new ArrayList();
    public List<String> generateParenthesis(int n) {
        generateParanthesis(n, 0, 0, "");
        return res;
    }

    private void generateParanthesis(int n, int numOfOpening, int numOfClosing, String currComb) {
        if (numOfOpening == n && numOfClosing == n) {
            res.add(new String(currComb));
            return;
        }

        if (numOfClosing < numOfOpening) {
            generateParanthesis(n, numOfOpening, numOfClosing+1, currComb + ")");
        }
            
        if (numOfOpening < n) {
            generateParanthesis(n,numOfOpening+1, numOfClosing, currComb + "(");
        }

    }
}
