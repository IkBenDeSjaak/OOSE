import java.util.ArrayList;

public class Wegennet {

	private Locatie arnhem     = new Plaats("Arnhem", 51.98, 5.89);
	private Locatie nijmegen   = new Plaats("Nijmegen", 51.84, 5.85);
	private Locatie denbosch   = new Plaats("Den Bosch",  51.72, 5.30);
	private Locatie eindhoven  = new Plaats("Eindhoven", 51.44, 5.46);
	private Locatie bankhoef   = new Knooppunt(51.81, 5.67); 
	private Locatie paalgraven = new Knooppunt(51.73, 5.58);
	private Locatie ressen     = new Knooppunt(51.89, 5.86);
	private Locatie valburg    = new Knooppunt(51.90, 5.76);
	
	private Verbindingsstuk a326NijmegenBankhoef   = new Verbindingsstuk(nijmegen, bankhoef, 6);
	private Verbindingsstuk a50BankhoefPaalgraven  = new Verbindingsstuk(bankhoef, paalgraven, 10);
	private Verbindingsstuk a50PaalgravenEindhoven = new Verbindingsstuk(paalgraven, eindhoven, 24);
	private Verbindingsstuk a59PaalgravenDenBosch  = new Verbindingsstuk(paalgraven, denbosch, 13);
	private Verbindingsstuk a2DenBoschEindhoven    = new Verbindingsstuk(denbosch, eindhoven, 20);
	private Verbindingsstuk a325ArnhemRessen       = new Verbindingsstuk(arnhem, ressen, 6);
	private Verbindingsstuk a15RessenValburg       = new Verbindingsstuk(ressen, valburg, 6);
	private Verbindingsstuk a50ValburgBankhoef     = new Verbindingsstuk(valburg, bankhoef, 9);
	
	private void verwerkVerkeersmeldingen() {
		a50BankhoefPaalgraven.voegVertragingToe(new File(4));
		a50PaalgravenEindhoven.voegVertragingToe(new File(8));
		a50PaalgravenEindhoven.voegVertragingToe(new Wegwerkzaamheid(5));
	}
	
	public ArrayList<Route> berekenRoutes(String van, String naar) {
		verwerkVerkeersmeldingen();
		if (van.equals("Nijmegen") && naar.equals("Eindhoven")) {
			// maak routes van Nijmegen naar Eindhoven
			Route routeNijmegenEindhoven1 = new Route(nijmegen, eindhoven);
			routeNijmegenEindhoven1.voegToe(a326NijmegenBankhoef);
			routeNijmegenEindhoven1.voegToe(a50BankhoefPaalgraven);
			routeNijmegenEindhoven1.voegToe(a50PaalgravenEindhoven);

			Route routeNijmegenEindhoven2 = new Route(nijmegen, eindhoven);
			routeNijmegenEindhoven2.voegToe(a326NijmegenBankhoef);
			routeNijmegenEindhoven2.voegToe(a50BankhoefPaalgraven);
			routeNijmegenEindhoven2.voegToe(a59PaalgravenDenBosch); 
			routeNijmegenEindhoven2.voegToe(a2DenBoschEindhoven); 

			ArrayList<Route> routesNE = new ArrayList<Route>();
 			routesNE.add(routeNijmegenEindhoven1);
 			routesNE.add(routeNijmegenEindhoven2);
 			return routesNE;
		} else if (van.equals("Arnhem") && naar.equals("Den Bosch")) {
			// maak routes van Arnhem naar Den Bosch
			Route routeArnhemDenBosch1 = new Route(arnhem, denbosch);
			routeArnhemDenBosch1.voegToe(a325ArnhemRessen);
			routeArnhemDenBosch1.voegToe(a15RessenValburg);
			routeArnhemDenBosch1.voegToe(a50ValburgBankhoef); 
			routeArnhemDenBosch1.voegToe(a50BankhoefPaalgraven);
			routeArnhemDenBosch1.voegToe(a59PaalgravenDenBosch); 
			
			ArrayList<Route> routesADB = new ArrayList<Route>();
			routesADB.add(routeArnhemDenBosch1);
			return routesADB;
		} else
			return null;
	}
}
