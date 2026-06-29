class Solution {
    List<Integer> dx = new ArrayList(List.of(1,-1,0,0));
    List<Integer> dy = new ArrayList(List.of(0,0,-1,1));;

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (isExist(0, i, j, board, word))
                    return true;
            }
        }
        return false;
    }

    private boolean isExist(int index, int x, int y, char[][] board, String word) {
        if (index >= word.length())
            return true;
        
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length)
            return false;
        boolean isExist = false;
        if (board[x][y] == word.charAt(index)) {
            board[x][y] = '#';
            for (int i = 0; i < 4; i++) {
                if(isExist(index+1, x + dx.get(i), y + dy.get(i), board, word))
                    return true;
            }
            board[x][y] = word.charAt(index);
        }
        return isExist;
    }
}
