import java.util.Scanner;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
public class XandO{

	char[][] grid = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
	Scanner sc = new Scanner(System.in);
	Player[] players = new Player[2];

	private XandO(){
		start();
	}

	private void start(){
		System.out.println("Enter name of players: ");
		System.out.print("Player 1: ");
		players[0] = new Player();
		players[0].setName(sc.nextLine());
		System.out.print("Player 2: ");
		players[1] = new Player();
		players[1].setName(sc.nextLine());

		System.out.println(players[0].getName() + " pick symbol:\nX or O");
		String choice = sc.next();
		switch(choice.toUpperCase()){
			case "X":
				players[0].setSymbol('X');
				players[1].setSymbol('O');
				this.play();
				break;
			case "O":
				players[0].setSymbol('O');
				players[1].setSymbol('X');
				this.play();
				break;
			default:
				System.out.println("Incorrect input value. Try again");
				this.start();
		}
	}

	private void printArr(){
		System.out.println("       A   B   C");
		System.out.println("       -   -   -");
		for(int outer = 0; outer < grid.length; outer++){
			System.out.print((outer + 1) + "   ");
			System.out.print(" | ");
			for(int inner = 0; inner < grid[0].length; inner++){
				System.out.print(grid[outer][inner] + " | ");
			}
			System.out.println();
			System.out.println("       -   -   -");
		}
	}

	private void restart(){
		System.out.println("\nPlay again?\nY or N");
		String choice = sc.next();

		switch(choice.toUpperCase()){
			case "Y": 
				this.play();
				break;
			case "N":
				System.exit(0);
				break;
			default:
				System.out.println("Incorrect input value.");
				this.restart();
				break;
		}
	}

	private void play(){
		this.printArr();

		while(this.checkForWin() == false){
		System.out.println("Enter grid value of where to play: (e.g A1)");
		for(Player player : players){
			System.out.println(player.getName() + "'s turn to play");
			String section = sc.next();
			switch(section.toUpperCase()){
				case "A1":
					if(grid[0][0] == ' '){
						grid[0][0] = player.getSymbol();
						this.printArr();
					}else{
						System.out.println("Cannot play here!\n");
						this.play();
					}
					if(this.checkForWin() == true){
						JFrame frame = new JFrame();
						JOptionPane.showMessageDialog(frame, player.getName() + " wins!");
						//System.out.println("**********\n"+player.getName() + " wins!\n\n**********");
						this.restart();
					}
					break;
				case "A2":
					if(grid[1][0] == ' '){
						grid[1][0] = player.getSymbol();
						this.printArr();
					}else{
						System.out.println("Cannot play here!\n");
						this.play();
					}
					if(this.checkForWin() == true){
						JFrame frame = new JFrame();
						JOptionPane.showMessageDialog(frame, player.getName() + " wins!");
						this.restart();
					}
					break;
				case "A3":
					if(grid[2][0] == ' '){
						grid[2][0] = player.getSymbol();
						this.printArr();
					}else{
						System.out.println("Cannot play here!\n");
						this.play();
					}
					if(this.checkForWin() == true){
						JFrame frame = new JFrame();
						JOptionPane.showMessageDialog(frame, player.getName() + " wins!");
						this.restart();
					}
					break;
				case "B1": 
					if(grid[0][1] == ' '){
						grid[0][1] = player.getSymbol();
						this.printArr();
					}else{
						System.out.println("Cannot play here!\n");
						this.play();
					}
					if(this.checkForWin() == true){
						JFrame frame = new JFrame();
						JOptionPane.showMessageDialog(frame, player.getName() + " wins!");
						this.restart();
					}
					break;
				case "B2":
					if(grid[1][1] == ' '){
						grid[1][1] = player.getSymbol();
						this.printArr();
					}else{
						System.out.println("Cannot play here!\n");
						this.play();
					}
					if(this.checkForWin() == true){
						JFrame frame = new JFrame();
						JOptionPane.showMessageDialog(frame, player.getName() + " wins!");
						this.restart();
					}
					break;
				case "B3":
					if(grid[2][1] == ' '){
						grid[2][1] = player.getSymbol();
						this.printArr();
					}else{
						System.out.println("Cannot play here!\n");
						this.play();
					}
					if(this.checkForWin() == true){
						JFrame frame = new JFrame();
						JOptionPane.showMessageDialog(frame, player.getName() + " wins!");
						this.restart();
					}
					break;
				case "C1":
					if(grid[0][2] == ' '){
						grid[0][2] = player.getSymbol();
						this.printArr();
					}else{
						System.out.println("Cannot play here!\n");
						this.play();
					}
					if(this.checkForWin() == true){
						JFrame frame = new JFrame();
						JOptionPane.showMessageDialog(frame, player.getName() + " wins!");
						this.restart();
					}
					break;
				case "C2":
					if(grid[1][2] == ' '){
						grid[1][2] = player.getSymbol();
						this.printArr();
					}else{
						System.out.println("Cannot play here!\n");
						this.play();
					}
					if(this.checkForWin() == true){
						JFrame frame = new JFrame();
						JOptionPane.showMessageDialog(frame, player.getName() + " wins!");
						this.restart();
					}
					break;
				case "C3":
					if(grid[2][2] == ' '){
						grid[2][2] = player.getSymbol();
						this.printArr();
					}else{
						System.out.println("Cannot play here!\n");
						this.play();
					}
					if(this.checkForWin() == true){
						JFrame frame = new JFrame();
						JOptionPane.showMessageDialog(frame, player.getName() + " wins!");
						this.restart();
					}
					break;
				default: 
					System.out.println("Incorrect input value!");
					this.play();
				}
			}
		}
	}

	public boolean checkForWin(){
		//horizontal check
		/*
			0,0 | 0,1 | 0,2
			1,0 | 1,1 | 1,2
			2,0 | 2,1 | 2,2
		*/
		if(this.checkAdjacent(0, 0, 0, 1) && this.checkAdjacent(0, 1, 0, 2)){
			return true;
		}else if(this.checkAdjacent(1, 0, 1, 1) && this.checkAdjacent(1, 1, 1, 2)){
			return true;
		}else if(this.checkAdjacent(2, 0, 2, 1) && this.checkAdjacent(2, 1, 2, 2)){
			return true;
		}
		//vertical check
		else if(this.checkAdjacent(0, 0, 1, 0) && this.checkAdjacent(1, 0, 2, 0)){
			return true;
		}else if(this.checkAdjacent(0, 1, 1, 1) && this.checkAdjacent(1, 1, 2, 1)){
			return true;
		}else if(this.checkAdjacent(0, 2, 1, 2) && this.checkAdjacent(1, 2, 2, 2)){
			return true;
		}
		//diagonal check
		else if(this.checkAdjacent(0, 0, 1, 1) && this.checkAdjacent(1, 1, 2, 2)){
			return true;
		}else if(this.checkAdjacent(0, 2, 1, 1) && this.checkAdjacent(1, 1, 2, 0)){
			return true;
		}else{
			return false;
		}
	}

	public boolean checkAdjacent(int a, int b, int c, int d){
		if(grid[a][b] == (grid[c][d]) && grid[a][b] != ' '){
			return true;
		}else{
			return false;
		}
	}


	public static void main(String[] args){
		new XandO();
	}
}