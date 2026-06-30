class Solution {
    private Set<Integer> colSet = new HashSet();
    private Set<Integer> posDiaSet = new HashSet();
    private Set<Integer> negDiaSet = new HashSet();
    private List<List<String>> res = new ArrayList();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int row = 0; row < n; row++)
            Arrays.fill(board[row], '.');
        getComb(0, n, board);
        return res;
    }

    private void getComb(int row, int max, char[][] board) {
        if (row >= max) {
            List<String> currComb = new ArrayList();
            for (int rowIndex = 0; rowIndex < max; rowIndex++){
                currComb.add(new String(board[rowIndex]));
            }
            res.add(currComb);
            return;
        }

        for (int col = 0; col < max; col++) {
            if (!colSet.contains(col)   
                && !posDiaSet.contains(row + col) 
                && !negDiaSet.contains(row - col)) {

                colSet.add(col);
                posDiaSet.add(row + col);
                negDiaSet.add(row - col);
                board[row][col] = 'Q';

                getComb(row + 1, max, board);

                colSet.remove(col);
                posDiaSet.remove(row + col);
                negDiaSet.remove(row - col);
                board[row][col] = '.';

            }
        }
    }
}
