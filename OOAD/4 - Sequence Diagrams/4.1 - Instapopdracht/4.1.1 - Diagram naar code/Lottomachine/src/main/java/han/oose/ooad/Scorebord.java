package han.oose.ooad;

import java.util.ArrayList;

public class Scorebord {
	ArrayList<Lottobal> ballen = new ArrayList<>();
	
	public Scorebord() {
		
	}

	public void maakLeeg() {
		ballen.clear();
	}

	public void plaatsBal(Lottobal bal) {
		ballen.add(bal);
	}

	public void plaatsBonusbal(Lottobal bal) {
		ballen.add(bal);
	}
	
	public void sorteerBallenVerbeterd() {
		for (int i = ballen.size() - 1; i > 0; i--) {
			for (int j = 0; j < i - 1; j++) {
				if (ballen.get(j).isNummerGroterDan(ballen.get(j+i))) {
					Lottobal bal = ballen.get(j);
					ballen.set(j, ballen.get(j + 1));
					ballen.set(j + 1, bal);
				}
			}
		}
	}

	public void sorteerBallen() {
		for (int i = ballen.size() - 1; i > 0; i--) {
			for (int j = 0; j < i - 1; j++) {
				if (ballen.get(j).getBalNummer() > ballen.get(j + 1).getBalNummer()) {
					Lottobal bal = ballen.get(j);
					ballen.set(j, ballen.get(j + 1));
					ballen.set(j + 1, bal);
				}
			}
		}
	}

	public void printScorebord() {
		for (int i = 0; i < ballen.size() - 1; i++) {
			System.out.println(ballen.get(i).getBalNummer());
		}
		System.out.println(ballen.get(6).getBalNummer());
	}
}
