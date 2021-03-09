public class Test {

    public static void main(String args[]) {
        IMovieType movieTypeRegular = new Regular();
        Movie childrenTest = new Movie("children", 2020, movieTypeRegular);

        System.out.println(childrenTest.getCharge(10));
    }
}
