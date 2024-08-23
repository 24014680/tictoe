import java.util.Scanner;

public class Main {
    private static char[][] board = new char[3][3];
    private static char currentPlayer = 'X';
    public static void main(String[] args) {
        Board();
        boolean Won = false;
        int moves = 0;

        while (!Won && moves < 9) {
            printBoard();
            makeMove();
            Won = checkWin();
            if (!Won) {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
            moves++;
        }

        printBoard();
        if (Won) {
            System.out.println("Player " + currentPlayer + " wins!");
        } else {
            System.out.println("It's a draw");
        }
    }

    private static void Board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    private static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    private static void makeMove() {
        Scanner scanner = new Scanner(System.in);
        int row, col;
        do {
            System.out.println("Player " + currentPlayer + ", enter your move ( for row enter [1-3] and for column enter [1-3]): ");
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;
        } while (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ');

        board[row][col] = currentPlayer;
    }

    private static boolean checkWin() {
        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) return true;
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) return true;
        }
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) return true;
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) return true;

        return false;
    }

    }
