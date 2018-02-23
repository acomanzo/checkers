import java.util.Scanner;

public class checkerBoard {
	public static int capturedRed = 0;
	public static int capturedBlack = 0;
	public static boolean jumped = false;
	public static boolean noJump = false;
	static String regex = "\\D";

	public static char pieces[][] = new char[][] {
			{ ' ', '1', '2', '3', '4', '5', '6', '7', '8' },
			{ '1', '-', 'b', '-', 'b', '-', 'b', '-', 'b' },
			{ '2', 'b', '-', 'b', '-', 'b', '-', 'b', '-' },
			{ '3', '-', 'b', '-', 'b', '-', 'b', '-', 'b' },
			{ '4', '-', '-', '-', '-', '-', '-', '-', '-' },
			{ '5', '-', '-', '-', '-', '-', '-', '-', '-' },
			{ '6', 'r', '-', 'r', '-', 'r', '-', 'r', '-' },
			{ '7', '-', 'r', '-', 'r', '-', 'r', '-', 'r' },
			{ '8', 'r', '-', 'r', '-', 'r', '-', 'r', '-' } };

	/*
	 * public static char debug[][] = new char[][] { { ' ', '1', '2', '3', '4',
	 * '5', '6', '7', '8' }, { '1', '-', '-', '-', 'b', '-', 'b', '-', '-' }, {
	 * '2', 'r', 'r', 'b', 'b', '-', 'r', '-', '-' }, { '3', '-', '-', 'r', '-',
	 * '-', 'r', '-', '-' }, { '4', '-', '-', '-', '-', 'r', '-', 'b', '-' }, {
	 * '5', '-', '-', '-', '-', '-', '-', '-', '-' }, { '6', '-', '-', '-', '-',
	 * 'r', '-', '-', '-' }, { '7', '-', 'r', '-', 'r', '-', 'r', '-', 'r' }, {
	 * '8', 'r', '-', 'r', '-', 'r', '-', 'r', '-' } };
	 */
	public static int oldRow;
	public static int oldCol;
	public static int newRow;
	public static int newCol;

	public static char[][] movePiece() {
		while (true) {
			System.out.println("Enter the row of the piece you want to move.");
			Scanner kbReaderRow = new Scanner(System.in);
			String pieceRow = kbReaderRow.nextLine();

			System.out
					.println("Enter the column of the piece you want to move.");
			Scanner kbReaderCol = new Scanner(System.in);
			String pieceCol = kbReaderRow.nextLine();

			if (pieceRow.matches(regex) || pieceCol.matches(regex)) {
				System.out.println("Invalid input! Try again.");
			} else {
				oldRow = Integer.parseInt(pieceRow);
				oldCol = Integer.parseInt(pieceCol);
				if (pieces[oldRow][oldCol] == '-') {
					System.out.println("Invalid input! Try again.");
					continue;
				}
				break;
			}
		} // end while

		for (int i = 0; i < checkerBoard.pieces.length; i++) // rows
		{
			for (int a = 0; a < checkerBoard.pieces[0].length; a++) // columns
			{
				if (a - 2 != 0
						&& i - 2 != 0
						&& (pieces[oldRow][oldCol] == 'r' || pieces[oldRow][oldCol] == 'R')
						&& ((pieces[oldRow - 1][oldCol - 1] == 'b' || pieces[oldRow - 1][oldCol - 1] == 'B') && pieces[oldRow - 2][oldCol - 2] == '-')) {
					System.out.println("Jump left?");
					Scanner kbReader = new Scanner(System.in);
					String jump = kbReader.nextLine();
					while (true) {
						if (jump.toLowerCase().equals("yes")) {
							pieces[oldRow - 2][oldCol - 2] = pieces[oldRow][oldCol];
							pieces[oldRow - 1][oldCol - 1] = '-';
							pieces[oldRow][oldCol] = '-';
							jumped = true;
							capturedBlack++;
							break;
						} else if (jump.toLowerCase().equals("no")) {
							noJump = true;
							break;
						} else {
							System.out.println("Enter yes or no.");
							break;
						}
					}
				} else if (oldCol != 8
						&& a - 2 != 0
						&& i + 2 != 0
						&& (pieces[oldRow][oldCol] == 'r' || pieces[oldRow][oldCol] == 'R')
						&& ((pieces[oldRow - 1][oldCol + 1] == 'b' || pieces[oldRow - 1][oldCol + 1] == 'B') && pieces[oldRow - 2][oldCol + 2] == '-')) {
					System.out.println("Jump right?");
					Scanner kbReader = new Scanner(System.in);
					String jump = kbReader.nextLine();
					while (true) {
						if (jump.toLowerCase().equals("yes")) {
							pieces[oldRow - 2][oldCol + 2] = pieces[oldRow][oldCol];
							pieces[oldRow - 1][oldCol + 1] = '-';
							pieces[oldRow][oldCol] = '-';
							jumped = true;
							capturedBlack++;
							break;
						} else if (jump.toLowerCase().equals("no")) {
							noJump = true;
							break;
						} else {
							System.out.println("Enter yes or no.");
							break;
						}
					}
				} else if (a - 2 > 0
						&& i + 2 < 9
						&& (pieces[oldRow][oldCol] == 'b' || pieces[oldRow][oldCol] == 'B')
						&& ((pieces[oldRow + 1][oldCol - 1] == 'r' || pieces[oldRow + 1][oldCol - 1] == 'R') && pieces[oldRow + 2][oldCol - 2] == '-')) {
					System.out.println("Jump left?");
					Scanner kbReader = new Scanner(System.in);
					String jump = kbReader.nextLine();
					while (true) {
						if (jump.toLowerCase().equals("yes")) {
							pieces[oldRow + 2][oldCol - 2] = pieces[oldRow][oldCol];
							pieces[oldRow + 1][oldCol - 1] = '-';
							pieces[oldRow][oldCol] = '-';
							jumped = true;
							capturedRed++;
							break;
						} else if (jump.toLowerCase().equals("no")) {
							noJump = true;
							break;
						} else {
							System.out.println("Enter yes or no.");
							break;
						}
					}
				} else if (oldCol != 8
						&& a + 2 < 9
						&& i + 2 < 9
						&& (pieces[oldRow][oldCol] == 'b' || pieces[oldRow][oldCol] == 'B')
						&& ((pieces[oldRow + 1][oldCol + 1] == 'r' || pieces[oldRow + 1][oldCol + 1] == 'R') && pieces[oldRow + 2][oldCol + 2] == '-')) {
					System.out.println("Jump right?");
					Scanner kbReader = new Scanner(System.in);
					String jump = kbReader.nextLine();
					while (true) {
						if (jump.toLowerCase().equals("yes")) {
							pieces[oldRow + 2][oldCol + 2] = pieces[oldRow][oldCol];
							pieces[oldRow + 1][oldCol + 1] = '-';
							pieces[oldRow][oldCol] = '-';
							jumped = true;
							capturedRed++;
							break;
						} else if (jump.toLowerCase().equals("no")) {
							noJump = true;
							break;
						} else {
							System.out.println("Enter yes or no.");
							break;
						}
					} // end while
				} else if (a - 2 > 0
						&& i + 2 < 9
						&& (pieces[oldRow][oldCol] == 'R')
						&& ((pieces[oldRow + 1][oldCol - 1] == 'b' || pieces[oldRow + 1][oldCol - 1] == 'B') && pieces[oldRow + 2][oldCol - 2] == '-')) {
					System.out.println("Jump left?");
					Scanner kbReader = new Scanner(System.in);
					String jump = kbReader.nextLine();
					while (true) {
						if (jump.toLowerCase().equals("yes")) {
							pieces[oldRow + 2][oldCol - 2] = pieces[oldRow][oldCol];
							pieces[oldRow + 1][oldCol - 1] = '-';
							pieces[oldRow][oldCol] = '-';
							jumped = true;
							capturedBlack++;
							break;
						} else if (jump.toLowerCase().equals("no")) {
							noJump = true;
							break;
						} else {
							System.out.println("Enter yes or no.");
							break;
						}
					}
				} else if (a - 2 > 0
						&& i + 2 < 9
						&& (pieces[oldRow][oldCol] == 'R')
						&& ((pieces[oldRow + 1][oldCol + 1] == 'b' || pieces[oldRow + 1][oldCol + 1] == 'B') && pieces[oldRow + 2][oldCol + 2] == '-')) {
					System.out.println("Jump right?");
					Scanner kbReader = new Scanner(System.in);
					String jump = kbReader.nextLine();
					while (true) {
						if (jump.toLowerCase().equals("yes")) {
							pieces[oldRow + 2][oldCol + 2] = pieces[oldRow][oldCol];
							pieces[oldRow + 1][oldCol + 1] = '-';
							pieces[oldRow][oldCol] = '-';
							jumped = true;
							capturedBlack++;
							break;
						} else if (jump.toLowerCase().equals("no")) {
							noJump = true;
							break;
						} else {
							System.out.println("Enter yes or no.");
							break;
						}
					}
				} else if (a - 2 > 0
						&& i + 2 < 9
						&& (pieces[oldRow][oldCol] == 'B')
						&& ((pieces[oldRow - 1][oldCol - 1] == 'r' || pieces[oldRow - 1][oldCol - 1] == 'R') && pieces[oldRow + 2][oldCol + 2] == '-')) {
					System.out.println("Jump left?");
					Scanner kbReader = new Scanner(System.in);
					String jump = kbReader.nextLine();
					while (true) {
						if (jump.toLowerCase().equals("yes")) {
							pieces[oldRow - 2][oldCol - 2] = pieces[oldRow][oldCol];
							pieces[oldRow - 1][oldCol - 1] = '-';
							pieces[oldRow][oldCol] = '-';
							jumped = true;
							capturedRed++;
							break;
						} else if (jump.toLowerCase().equals("no")) {
							noJump = true;
							break;
						} else {
							System.out.println("Enter yes or no.");
							break;
						}
					}
				} else if (a - 2 > 0
						&& i + 2 < 9
						&& (pieces[oldRow][oldCol] == 'B')
						&& ((pieces[oldRow - 1][oldCol + 1] == 'r' || pieces[oldRow - 1][oldCol + 1] == 'R') && pieces[oldRow + 2][oldCol + 2] == '-')) {
					System.out.println("Jump right?");
					Scanner kbReader = new Scanner(System.in);
					String jump = kbReader.nextLine();
					while (true) {
						if (jump.toLowerCase().equals("yes")) {
							pieces[oldRow - 2][oldCol + 2] = pieces[oldRow][oldCol];
							pieces[oldRow - 1][oldCol + 1] = '-';
							pieces[oldRow][oldCol] = '-';
							jumped = true;
							capturedRed++;
							break;
						} else if (jump.toLowerCase().equals("no")) {
							noJump = true;
							break;
						} else {
							System.out.println("Enter yes or no.");
							break;
						}
					}

				} // last else if
				if (jumped == true || noJump == true) {
					break;
				}
			} // end for a
			if (jumped == true || noJump == true) {
				break;
			}
		} // end for i

		if (jumped == false) {
			System.out
					.println("Enter the row of where you want to move the piece.");
			Scanner kbReaderNewRow = new Scanner(System.in);
			String toRow = kbReaderNewRow.nextLine();

			System.out
					.println("Enter the column of where you want to move the piece.");
			Scanner kbReaderNewCol = new Scanner(System.in);
			String toCol = kbReaderNewCol.nextLine();
			if (toRow.matches(regex) || toCol.matches(regex)) {
				System.out.println("Invalid input! Try again.");
			} else {
				newRow = Integer.parseInt(toRow);
				newCol = Integer.parseInt(toCol);
				if (newCol > 8
						|| newCol < 1
						|| newRow > 8
						|| newRow < 1
						|| (checkerBoard.checkMove() == false)
						|| (checkForKing() == false
								&& pieces[oldRow][oldCol] == 'b' && newRow < oldRow)
						|| (checkForKing() == false
								&& pieces[oldRow][oldCol] == 'r' && newRow > oldRow)
						|| pieces[oldRow][oldCol] == '-') {
					System.out.println("Invalid move! Try again!");
				} else if (pieces[oldRow][oldCol] == pieces[newRow][newCol]) {
					System.out.println("Invalid move! Try again!");
				} else {
					pieces[newRow][newCol] = pieces[oldRow][oldCol];
					pieces[oldRow][oldCol] = '-';
				}
			}
		} // end if jumped == false
		jumped = false;
		noJump = false;
		makeKing();
		return pieces;
	}

	public static boolean checkForKing() {
		if (pieces[oldRow][oldCol] == 'B' || pieces[oldRow][oldCol] == 'R') {
			return true;
		} else {
			return false;
		}
	}

	public static boolean checkMove() {
		if ((Math.abs(oldRow - newRow) > 1) || (Math.abs(oldCol - newCol) > 1)
				|| (oldCol == newCol) || (oldRow == newRow) || (newRow < 1)
				|| (newCol < 1)) {
			return false;
		} else {
			return true;
		}
	}

	public static char[][] makeKing() {
		for (int i = 0; i < pieces[0].length; i++) {
			if (pieces[1][i] == 'r') {
				pieces[1][i] = 'R';
			}
		}
		for (int i = 0; i < pieces[0].length; i++) {
			if (pieces[8][i] == 'b') {
				pieces[8][i] = 'B';
			}
		}
		return pieces;
	}
}

