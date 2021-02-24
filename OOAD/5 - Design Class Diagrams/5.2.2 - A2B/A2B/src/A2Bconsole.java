import java.util.ArrayList;
import java.util.Scanner;

public class A2Bconsole {

	public static void main (String[] args) {
		Routeplanner planner = new Routeplanner();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Geef vertrekpunt: ");
		String vertrekpunt = scanner.nextLine();
		System.out.print("Geef bestemming: ");
		String bestemming = scanner.nextLine();
		
		ArrayList<String> routeinfo = planner.bepaalRouteinformatie(vertrekpunt, bestemming);
		for (String info: routeinfo) {
			System.out.println(info);
		}
	}
}
