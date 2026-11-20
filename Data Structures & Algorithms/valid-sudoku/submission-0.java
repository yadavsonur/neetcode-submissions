class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Trackers for 9 rows, 9 columns, and 9 boxes (each holding digits 0-8)
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char current = board[i][j];
                
                // Skip empty cells
                if (current == '.') {
                    continue;
                }

                int num = current - '1';          // Convert '1'-'9' to 0-8
                int boxIndex = (i / 3) * 3 + (j / 3); // Find which 3x3 box (0-8)

                // If seen in current row, column, or box, board is invalid
                if (rows[i][num] || cols[j][num] || boxes[boxIndex][num]) {
                    return false;
                }

                // Mark digit as seen
                rows[i][num] = true;
                cols[j][num] = true;
                boxes[boxIndex][num] = true;
            }
        }

        return true;
    }
}
