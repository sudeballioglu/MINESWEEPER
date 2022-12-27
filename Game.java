package MineSweeper;

import java.util.Scanner;

public class Game {

	public static void main(String[] args) {

	
		Scanner scan = new Scanner(System.in);
		System.out.print("Give the size of row: ");
		int row=scan.nextInt();
		System.out.print("Give the size of column: ");
		int column=scan.nextInt();
		
		
		MineSweeper game = new MineSweeper(row, column);
		game.run();

	}

}
