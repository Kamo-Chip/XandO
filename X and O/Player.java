import java.util.Scanner;

public class Player{
	private String name;
	private char symbol;
	private Scanner sc = new Scanner(System.in);

	public Player(){
	
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setSymbol(char symbol){
		this.symbol = symbol;
	}

	public char getSymbol(){
		return this.symbol;
	}
}