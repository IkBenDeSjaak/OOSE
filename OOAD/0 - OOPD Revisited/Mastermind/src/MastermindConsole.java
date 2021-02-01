import java.util.Scanner;

public class MastermindConsole {

    public static void main(String[] args) {
        // start game and generate secret code
        MastermindGame game = new MastermindGame();
        game.generateSecretCode();

        // let player guess the secret code
        System.out.println("Welcome to mastermind. Try to find the secret code.");
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("Guess please: ");
            String guessString = input.nextLine();
            game.checkCombination(guessString);
            System.out.println(game.getHint());
        } while (!game.isWon() && !game.maxTurnsUsed());
        input.close();

        // end game
        if (game.isWon())
            System.out.println("You found the secret code. Congrats!");
        else
            System.out.println("You did not find the right code. The secret code was: " + game.getSecretCode());
    }
}
