
public class Scorecard {
	private int[] scores = new int[6];
	
	public void addScore(int boxnr, int score) {
		scores[boxnr] = score;
	}
	
	public String toString() {
		String result="";
		for (int i=0; i<scores.length; i++) {
			result += " " + scores[i];
		}	
		return result;
	}

}
