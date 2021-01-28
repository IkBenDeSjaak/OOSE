import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MastermindGame {
    private final ArrayList<String> secretCode = new ArrayList<>();
    private final String[] colors = {"B", "G", "R", "Y"};
    private boolean isWon = false;
    private int currentRound = 0;
    private int positionsRight;
    private int positionsWrong;

    public void generateSecretCode() {
        for (int i = 0; i < 4; i++) {
            this.secretCode.add(this.colors[new Random().nextInt(4)]);
        }

        //For testing purposes
        System.out.println(secretCode);
    }

    public void checkCombination(String guessString) {
        List<String> userInputList = new ArrayList<>(Arrays.asList(guessString.split("")));

        if (this.secretCode.equals(userInputList)) {
            this.isWon = true;
        } else {
            for (int i = 0; i < this.secretCode.size(); i++) {
                if (userInputList.get(i).equals(this.secretCode.get(i))) {
                    this.positionsRight++;
                } else if (this.secretCode.contains(userInputList.get(i))) {
                    this.positionsWrong++;
                }
            }

            this.currentRound++;
        }
    }

    public boolean isWon() {
        return this.isWon;
    }

    public String getHint() {
        String line1 = "right colour right position = " + this.positionsRight;
        String line2 = "right colour wrong position = " + this.positionsWrong;
        this.positionsRight = 0;
        this.positionsWrong = 0;
        return line1 + "\r\n" + line2;
    }

    public boolean maxTurnsUsed() {
        if (this.currentRound == 8) {
            return true;
        } else {
            return false;
        }
    }

    public String getSecretCode() {
        return this.secretCode.toString();
    }
}
