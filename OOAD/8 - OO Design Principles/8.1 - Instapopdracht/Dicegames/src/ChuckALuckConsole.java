import java.util.Scanner;

public class ChuckALuckConsole {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ChuckALuckGame game = new ChuckALuckGame();
		game.startGame();
		
		System.out.print("What's your lucky number? ");
		int luckyNumber = scanner.nextInt();
		System.out.print("What's your cash for playing? ");
		int cash = scanner.nextInt();
		game.playLuckyNumber(luckyNumber, cash);
		System.out.println("throw with dice cup gives: " + game.diceCupAsString());
		int currentBalance = game.getBalance();
		System.out.println("balance: " + currentBalance);
		
		scanner.close();
	}
}
