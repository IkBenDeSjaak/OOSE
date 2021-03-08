import java.util.ArrayList;
import java.util.List;

public class DiceCup {
//	private Die[] dice;
	private ArrayList<Die> dice = new ArrayList<Die>();
	
	public DiceCup(int count) {
		for(int i = 0; i < count; i++) {
			Die newDie = new Die();
//			dice[i] = newDie;
			dice.add(newDie);
		}
	}
	
	public void roll() {
		for(int i = 0; i < 3; i++) {
			dice.get(i).roll();
		}

	}
	
	public int diceEqualTo(int number) {
		int amountEqual = 0;
		for(int i = 0; i < 3; i++) {
			if(dice.get(i).getFaceValue() == number) {
				amountEqual++;
			}
		}
		return amountEqual;
	}

	public String toString() {
		String result="";
		for (int i=0; i< dice.size(); i++) {
			result += " " + dice.get(i).getFaceValue();
		}	
		return result;
	}
	
}
