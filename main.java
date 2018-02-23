import java.util.Arrays;


public class Checkers {
	public static void main(String args[])
	{
		for(int i=0;i<checkerBoard.pieces.length;i++)
		{
			System.out.println(" ");
			for(int a=0;a<checkerBoard.pieces[0].length;a++)
			{
				System.out.print(checkerBoard.pieces[i][a]+" ");
			}
		}
		System.out.println("\n");
		
		System.out.println("This game uses rows and columns to move the pieces.");
		System.out.println("The numbers going down are rows, and the numbers going across" +
				" are columns."); 
		System.out.println("b stands for a black piece, B stands for a black" +
				" king, r stands for a red piece, R stands for a red king, and" +
				" - stands for an empty space.");
		while(checkerBoard.capturedRed<12&&checkerBoard.capturedBlack<12)
		{
			System.out.println("\n");
			checkerBoard.movePiece();
			for(int i=0;i<checkerBoard.pieces.length;i++)
			{
				System.out.println(" ");
				for(int a=0;a<checkerBoard.pieces[0].length;a++)
				{
					System.out.print(checkerBoard.pieces[i][a]+" ");
				}
			}
			System.out.println("\n");
			System.out.println("Red player score: "+checkerBoard.capturedBlack);
			System.out.println("Black player score: "+checkerBoard.capturedRed);
		}
	}
}

