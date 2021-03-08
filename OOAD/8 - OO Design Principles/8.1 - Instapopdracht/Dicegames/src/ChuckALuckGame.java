import java.util.Scanner;

public class ChuckALuckGame {
	private int balance = 100;
	private DiceCup cup;
	
	public void startGame() {
		cup = new DiceCup(3);
	}
	
	public void playLuckyNumber(int lucky, int cash) {
		cup.roll();
		int amountEqual = cup.diceEqualTo(lucky);
		updateBalance(amountEqual, cash);
	}
	
	private void updateBalance(int equal, int amount) {
		int addition = 0;
		if(equal == 1) {
			addition = amount;
		} else if (equal == 2) {
			addition = amount * 2;
		} else if (equal == 3) {
			addition = amount * 10;
		}
		balance += addition;
	}
	
	public String diceCupAsString() {
		return cup.toString();
	}
	
	public int getBalance() {
		return balance;
	}
	
}
