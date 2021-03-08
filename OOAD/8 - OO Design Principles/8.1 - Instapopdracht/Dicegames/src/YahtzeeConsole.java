import java.util.Scanner;

public class YahtzeeConsole {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		YahtzeeGame game = new YahtzeeGame();
		game.startGame();

		for (int thrownr=0; thrownr<6; thrownr++) {
			game.rollDice();
			System.out.println("throw: " + game.diceCupAsString());

			System.out.print("Which box number? ");
			int boxnumber = scanner.nextInt();
			game.addToScoreCard(boxnumber);
			
			System.out.println("score card: " + game.scorecardAsString());	
			System.out.println();
		}
		scanner.close();
	}
}
