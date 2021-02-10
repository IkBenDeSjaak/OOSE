package han.oose.ooad;

import java.util.ArrayList;
import java.util.Random;

public class Glazenbol {
	private int capaciteit;
	ArrayList<Lottobal> verzameldeBallen = new ArrayList<>();
	
	Glazenbol(int aantalBallen) {
		this.capaciteit = aantalBallen;
	}

	public void verzamelAlleBallen() {
		for (int i = 0; i < capaciteit; i++) {
			verzameldeBallen.add(new Lottobal(i));
		}
	}

	public Lottobal schepBal() {
		Random random = new Random();
        int balNummer = random.nextInt(verzameldeBallen.size());
        
        Lottobal randomBal = verzameldeBallen.get(balNummer);
        verzameldeBallen.remove(balNummer);
        
        return randomBal;
	}
}
