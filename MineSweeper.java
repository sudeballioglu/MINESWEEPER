package MineSweeper;

import java.util.Scanner;

public class MineSweeper {

	int row; //for size of map, received from the user.
	int column; //for size of map, received from the user.
	String[][] mineMap; //to show mines location.
	String[][] gameMap; //for user.
	int mines; //number of mines.
	
	
	public MineSweeper(int row, int column) { //constructor.
		this.row=row;
		this.column=column;
		this.mineMap=new String[row][column];
		this.gameMap=new String[row][column];
		this.mines=(row*column)/4;
	}
	
	
	
	
	void gameMap() {
		for(int i=0;i<this.gameMap.length;i++) {
			for(int j=0;j<this.gameMap[i].length;j++) {
				this.gameMap[i][j]=" - ";
			}
		}
	}
	
	
	
	
	void printMap() {
		for(int i=0;i<this.gameMap.length;i++) {
			for(int j=0;j<this.gameMap.length;j++) {
				System.out.print(this.gameMap[i][j]);
			}
			System.out.println();
		}
	}
	
	
	
	void mines() {
		
		while(this.mines>0) {//for mines location.
			
			int rndRow=(int)(Math.random()*this.row);//random index for row.
			int rndColumn=(int)(Math.random()*this.column);//random index for column.
			
			if(this.mineMap[rndRow][rndColumn]!=" * ") {
				this.mineMap[rndRow][rndColumn]=" * ";
				this.mines--;
			}
			continue;
		}
		
		
		
		
		for(int i=0;i<this.mineMap.length;i++) {//for empty locations.
			for(int j=0;j<this.mineMap[i].length;j++) {
				if(this.mineMap[i][j]!=" * ") {
					this.mineMap[i][j]=" - ";
				}
				System.out.print(this.mineMap[i][j]);
			}
			System.out.println();
		}
		
	}
	
	
		void printMineMap() {
			
			for(int i=0;i<this.mineMap.length;i++) { //for print map.
				for(int j=0;j<this.mineMap.length;j++) {
					System.out.print(this.mineMap[i][j] );
			}
	     		System.out.println();
		}
			
		}

		
		
	
	
	void run() {
		
		Scanner scan=new Scanner(System.in);
		
		int totalMove=(row*column)-mines;
		
		
		gameMap();
		System.out.println("Location of mines");
		mines();
		System.out.println("Welcome to the MineSweeper!");
		
		while(totalMove>0) {
			int counter=0;
			
			
			System.out.println("-------------------");
			System.out.println("Remaining moves: " + totalMove);
			printMap();
			
			System.out.print("Enter the row number: ");
			int rowNumber=scan.nextInt();
			System.out.print("Enter the column number: ");
			int columnNumber=scan.nextInt();
			
			
			if(rowNumber<0 || rowNumber>=this.row || columnNumber<0 || columnNumber>=this.column) {
				System.out.println("Wrong index.Please try again!");
				continue;
			}else {
				if(this.mineMap[rowNumber][columnNumber]==" * ") {
					System.out.println("Mine!Game Over.");
					printMineMap();
					break;
				}if(this.gameMap[rowNumber][columnNumber]!=" - ") {
					System.out.println("You already did this move!");
					continue;
				}else {
					
					int minRow=(rowNumber-1),maxRow=(rowNumber+1);
					int minColumn=(columnNumber-1),maxColumn=(columnNumber+1);
					
					if(minRow<0 || minColumn<0) {
						minRow=0;
						minColumn=0;
					}
					
					if(maxRow>=row || maxColumn>=column) {
						maxRow=rowNumber;
						maxColumn=columnNumber;
					}
					
					for(int i=minRow;i<=maxRow;i++) {
						for(int j=minColumn;j<=maxColumn;j++) {
							if(this.mineMap[i][j]==" * ") {
								counter++;
							}
						}
					}
					
					
					String mineCounter = String.valueOf(counter);
					this.gameMap[rowNumber][columnNumber]=" " + mineCounter + " ";
					totalMove--;
				
				}
			
		     }
		}
		
		if(totalMove==0) {
			System.out.println("You win!");
			printMineMap();
		}
		
	}
	
}
