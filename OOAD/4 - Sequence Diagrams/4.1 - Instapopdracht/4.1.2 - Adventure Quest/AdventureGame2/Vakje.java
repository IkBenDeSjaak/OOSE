
public class Vakje {

	private int vaknr;
	private int xpos, ypos;
	
	private Karakter karakter;

	public Vakje(int i) {
		vaknr = i;
		xpos = vaknr % Spelbord.MAAT;
		ypos = vaknr / Spelbord.MAAT;
	}
	
    public void setKarakter(Karakter k) {
        this.karakter = k;
        // om te testen een println
        System.out.println(k.getNaam() + " staat op vakje " + this.vaknr + ": (" + this.xpos + "," + this.ypos + ")");
    }

    public boolean isLeeg() {
    	return karakter == null;
    }
}
