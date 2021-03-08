
public class Movie {
    private String title;
    private int releaseyear;
    private IMovieType movieType;

    public Movie(String title, int releaseyear, IMovieType movieType) {
        this.title = title;
        this.releaseyear = releaseyear;
        this.movieType = movieType;
    }

    public double getCharge(int daysRented) {
        return movieType.getCharge(daysRented);
    }


}
