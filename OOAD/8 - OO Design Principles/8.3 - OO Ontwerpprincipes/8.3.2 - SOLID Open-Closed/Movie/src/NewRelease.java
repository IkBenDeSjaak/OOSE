public class NewRelease implements IMovieType{
    @Override
    public double getCharge(int daysRented) {
        double charge = daysRented * 3;
        return charge;
    }
}
