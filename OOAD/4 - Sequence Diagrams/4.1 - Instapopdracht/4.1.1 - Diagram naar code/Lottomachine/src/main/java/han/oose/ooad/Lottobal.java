package han.oose.ooad;

public class Lottobal {

	private int balNummer;

	public Lottobal(int nummer) {
		balNummer = nummer;
	}

	public boolean isNummerGroterDan(Lottobal andereBal) {
		return balNummer > andereBal.balNummer;
	}

	public int getBalNummer() {
		return balNummer;
	}

	public String toString() {
		return "" + balNummer;
	}

}
