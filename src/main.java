import java.util.Scanner;
//got this idea from geeksforgeeks.com
import java.util.concurrent.ThreadLocalRandom;



public class main {
    public static void main(String[] args) {
        int incorrectGuesses=7;
        boolean done=false;
        boolean foundFlag;
        Scanner input = new Scanner(System.in);
        String [] optionList = {"rhythm", "purple", "black", "porcupine", "chair" , "tsunami", "gullet", "algorithm",
                "hammer", "screwdriver"};
        int rand_int1 = ThreadLocalRandom.current().nextInt(10);
        String wordChoice=optionList[rand_int1];
        System.out.println(rand_int1+wordChoice);

        char [] availableLetters=
                {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

        System.out.println("");
        System.out.println("The word to guess has " + wordChoice.length() + " letters!");
        char[] visibleLetters = new char[wordChoice.length()];

        System.out.println();
        for (int i = 0; i < wordChoice.length(); i++) {
            visibleLetters[i] = '-';
            System.out.print(visibleLetters[i]);
        }
        while (incorrectGuesses>0 && !done ) {
            foundFlag=false;
            for (int i = 0; i < wordChoice.length(); i++) {
                System.out.print(visibleLetters[i]);
            }
            System.out.print("\nThe options are ");
            for (int i = 0; i < 26; i++) {
                System.out.print(availableLetters[i]);
            }
            System.out.println("\nYou have " +
                    incorrectGuesses + " incorrect guesses remaining!\n" +
                    "Please enter your guess: ");
            String guess = input.nextLine();

            char[] guessChar = guess.toCharArray();
            char[] wordChoiceChar = wordChoice.toCharArray();

            for (int i = 0; i < wordChoice.length(); i++) {
                if (guess.charAt(0) == wordChoiceChar[i]) {
                    System.out.println("Nice! " + guess + " is in the word!");
                    visibleLetters[i]=wordChoiceChar[i];
                    foundFlag = true;
                }
            }
            if (!foundFlag) {
                incorrectGuesses--;
                System.out.println(guess + " is not in the word. Too bad. " + incorrectGuesses + " guesses remaining");
            }
        }
    }
}
