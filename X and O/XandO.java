import java.util.Scanner;
import java.util.Arrays;

public class XandO{

	char[][] grid = {{'a','a','a'},{'a','a','a'},{'a','a','a'}};
	char symbol;
	Scanner sc = new Scanner(System.in);

	private XandO(){
		this.start();
	}

	private void start(){
		System.out.println("Which symbol would you like to play as:\n(1) X\n(2) O");
		int choice = sc.nextInt();
		switch(choice){
			case 1:
				symbol = 'X';
				this.play();
				break;
			case 2:
				symbol = 'O';
				this.play();
				break;
			default:
				System.out.println("Incorrect input value. Try again");
				this.start();
		}
	}

	private void play(){
		char letter = 'A';

		System.out.println("Enter grid value of where to play:\n");

		System.out.println("	A B C");
		for(int outer = 0; outer < grid.length; outer++){
			System.out.print((outer + 1));
			for(int inner = 0; inner < grid[0].length; inner++){
				System.out.print(grid[outer][inner] + " | ");
				
			}
			System.out.print("__");
			System.out.println();
			//letter++;
		}
	}


	public static void main(String[] args){
		new XandO();

	}
}