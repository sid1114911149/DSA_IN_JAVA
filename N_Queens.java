import java.util.*;

public class N_Queens{

    static int totalCount = 0;

    public static boolean isSafe(int row, int col, char[][] board) {
        int n = board.length;
        for (int j = 0; j < col; j++) {
            if (board[row][j] == 'Q') {
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void solveNQueens(char[][] board, List<List<String>> allBoards, int col) {
        int n = board.length;

        if (col == n) { 
            saveBoard(board, allBoards);
            totalCount++;
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, board)) {
                board[row][col] = 'Q'; 
                solveNQueens(board, allBoards, col + 1);
                board[row][col] = '.'; 
            }
        }
    }

    public static void saveBoard(char[][] board, List<List<String>> allBoards) {
        List<String> currentBoard = new ArrayList<>();
        for (char[] row : board) {
            currentBoard.add(new String(row));
        }
        allBoards.add(currentBoard);
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> allBoards = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        solveNQueens(board, allBoards, 0);
        return allBoards;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value of N: ");
        int n = sc.nextInt();

        List<List<String>> solutions = solveNQueens(n);
        System.out.println("Total no. of ways to place " + n + " queens: " + totalCount);
        for (List<String> board : solutions) {
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println();
        }

        sc.close();
    }
}
