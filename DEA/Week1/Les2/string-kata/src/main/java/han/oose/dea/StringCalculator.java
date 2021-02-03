package han.oose.dea;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.equals("")) {
            return 0;
        } else {
            String delimiter = ",";
            if (numbers.matches("//(.*)\n(.*)")) {
                delimiter = Character.toString(numbers.charAt(2));
                numbers = numbers.substring(4);
            }
            String[] parts = numbers.split(delimiter + "|\n");
            return validate(parts);
        }

    }

    private static int validate(String[] numbers) {
        int result = 0;

        for (String number : numbers) {
            if (Integer.parseInt(number) <= 1000) {
                result += Integer.parseInt(number);
            }
        }
        return result;
    }

}
