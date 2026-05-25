class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Integer>> columns = new ArrayList<>();
        List<Set<Integer>> squares = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            columns.add(new HashSet<>());
            squares.add(new HashSet<>());
        }

        for (int i = 0; i < 9; i++) {
            Set<Integer> row = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int num = Integer.parseInt(String.valueOf(board[i][j]));
                // System.out.println(num + "-> (" + i + ", " + j + ") " + getSquareBoxIndex(i, j));
                if (!row.add(num)) return false;
                if (!squares.get(getSquareBoxIndex(i, j)).add(num)) return false;
                if (!columns.get(j).add(num)) return false;
            }
        }
        return true;
    }

    public int getSquareBoxIndex(int i, int j) {
        if (i == 0 || i == 1 || i == 2) {
            if (j == 0 || j == 1 || j == 2) {
                return 0;
            } else if (j == 3 || j == 4 || j == 5) {
                return 1;
            } else {
                return 2;
            }
        } else if (i == 3 || i == 4 || i == 5) {
            if (j == 0 || j == 1 || j == 2) {
                return 3;
            } else if (j == 3 || j == 4 || j == 5) {
                return 4;
            } else {
                return 5;
            }
        } else {
            if (j == 0 || j == 1 || j == 2) {
                return 6;
            } else if (j == 3 || j == 4 || j == 5) {
                return 7;
            } else {
                return 8;
            }
        }
    }
}
