import java.util.Scanner;

public class board {
	String[] boardArray = new String[34];
	
	String turn = " X";
	
	int playCount = 0;
	
	public void initializeBoard(){
		this.boardArray[11] = "11";
		this.boardArray[12] = "12";
		this.boardArray[13] = "13";
		this.boardArray[21] = "21";
		this.boardArray[22] = "22";
		this.boardArray[23] = "23";
		this.boardArray[31] = "31";
		this.boardArray[32] = "32";
		this.boardArray[33] = "33";
	}
	
	public void printBoard() {
		System.out.println("|" + boardArray[11] + "|" + boardArray[21] + "|" + boardArray[31] + "|\n|" + boardArray[12] + "|" + boardArray[22] + "|" + boardArray[32] + "|\n|" + boardArray[13] + "|" + boardArray[23] + "|" + boardArray[33] + "|");
	}
	
	public boolean makeMove() {
		
		Scanner input = new Scanner(System.in); 
		System.out.println("Player " + this.turn + " please enter your move int the for XY from 1-3");
		int coordinate = input.nextInt();
		
		if (this.boardArray[coordinate] == " X" || this.boardArray[coordinate] == " O") {
			System.out.println("Sorry this spot is already occupied please choose another spot");
			return true;
		}
		else {
			this.boardArray[coordinate] = this.turn;
			if (this.turn == " X") {
				this.turn = " O";
			}
			else{
				this.turn = " X";
			}
			
			++ this.playCount;
			return false;
		}
		
	}

	public boolean isWon() {
		if ((this.boardArray[11] == this.boardArray[12]) && (this.boardArray[12] == this.boardArray[13])) {
			return true;
		}
		else if ((this.boardArray[21] == this.boardArray[22]) && (this.boardArray[22] == this.boardArray[23])) {
			return true;
		}
		else if ((this.boardArray[31] == this.boardArray[32]) && (this.boardArray[32] == this.boardArray[33])) {
			return true;
		}
		else if ((this.boardArray[11] == this.boardArray[21]) && (this.boardArray[21] == this.boardArray[31])) {
			return true;
		}
		else if ((this.boardArray[12] == this.boardArray[22]) && (this.boardArray[22] == this.boardArray[32])) {
			return true;
		}
		else if ((this.boardArray[13] == this.boardArray[23]) && (this.boardArray[23] == this.boardArray[33])) {
			return true;
		}
		else if ((this.boardArray[11] == this.boardArray[22]) && (this.boardArray[22] == this.boardArray[33])) {
			return true;
		}
		else if ((this.boardArray[13] == this.boardArray[22]) && (this.boardArray[22] == this.boardArray[31])) {
			return true;
		}
		return false;
		
	}

	public void playGame() {
		this.initializeBoard();
		
		while(!(this.isWon())) {
			this.printBoard();
			
			while(this.makeMove()) {}
			if (this.playCount == 9) {
				break;
			}
		}
		
		if (this.playCount == 9) {
			System.out.println("No Winner");
		}
		else {
			if (this.turn == " X") {
				this.turn = " O";
			}
			else{
				this.turn = " X";
			}
			System.out.println("Congrats player " +this.turn+ " you won in " +this.playCount+" plays");
		}
	}
}

