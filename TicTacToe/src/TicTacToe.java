import java.util.*;

public class TicTacToe {

	char[][] board = new char[3][3];
	char player = 'X';
	static boolean gameOver = false;

	public static void main(String[] args) {
		TicTacToe obj = new TicTacToe();
		while (!gameOver) {
			obj.turn();
			obj.printBoard();			
		}
	}

	public void turn() {
		System.out.println("Player '" + player + "' enter the co-ordinates:");
		Scanner sc = new Scanner(System.in);
			int row = sc.nextInt();
			int col = sc.nextInt();
			if (row < 3 && col < 3 && board[row][col] == '\u0000') {
				board[row][col] = player;
				isGameOver();
			} else {
				System.out.println("Invalid entry. Try again!");
				turn();
			}
		player = player == 'X' ? 'O' : 'X';
	}

	public void printBoard() {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				if (col == board[row].length - 1) {
					System.out.print(board[row][col]);
				} else {
					System.out.print(board[row][col] + "|");
				}
			}
			System.out.println(" ");
		}
	}

	public void isGameOver() {
		if ((board[0][0] == player && board[1][1] == player && board[2][2] == player)
				|| (board[0][2] == player && board[1][1] == player && board[0][2] == player)) {
			gameOver = true;
			System.out.println("Player " + player + " wins!");
		} else {
			for (int row = 0; row < board.length; row++) {
				if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
					gameOver = true;
					System.out.println("Player " + player + " wins!");
				}
				for (int col = 0; col < board[row].length; col++) {
					if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
						gameOver = true;
						System.out.println("Player " + player + " wins!");
					}
				}
			}
		}		
	}
}