public class Regular implements IMovieType {
    @Override
    public double getCharge(int daysRented) {
        double charge = 0;

        charge += 2;
        if (daysRented > 2) {
            charge += (daysRented - 2) * 1.5;
        }

        return charge;
    }
}
