package han.oose.dea;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.equals("")) {
            return 0;
        }

        if (numbers.contains(",")) {
            int result = 0;
            for (String number : numbers.split(",")) {
                result += Integer.parseInt(number);
            }
            return result;

        } else {
            return Integer.parseInt((numbers));
        }

    }

}
