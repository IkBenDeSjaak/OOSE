import java.util.ArrayList;

public class Routeplanner {

	private Wegennet wegennet = new Wegennet();

	private ArrayList<Route> routes;

	public ArrayList<String> bepaalRouteinformatie(String van, String naar) {
		ArrayList<String> infoRoutes = new ArrayList<String>();
		routes = wegennet.berekenRoutes(van, naar);
		if (routes == null) {
			infoRoutes.add("Geen route gevonden");
		} 
		else {
			for (Route r: routes) {
				/* TO DO: pas onderstaand statement aan zodat de juiste
				   route-informatie aan infoRoutes wordt toegevoegd */

				int reistijd = r.berekenReistijd();
				infoRoutes.add("Reistijd: " + reistijd + ", Route: " + r);
			}
		}
		return infoRoutes;
	}
}
