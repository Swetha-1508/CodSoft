import java.util.Scanner;

public class NumberGames {
    public static void main(String[] args) {
        int score = 0;
        Scanner in = new Scanner(System.in);

        System.out.println("Are you eager to play!?");
        char wish;

        do {
            int chance = 3;
            score = playGame(chance, score);
            System.out.println("Do you want to continue? (y/n): ");
            wish = in.next().charAt(0);
            in.nextLine(); 
        } while (wish == 'y' || wish == 'Y');

        System.out.println("Thanks for playing!");
    }

    public static int playGame(int chance, int score) {
        int computerMove = (int) (Math.random() * 100);
        int playerMove;

        Scanner in = new Scanner(System.in);

        while (chance > 0) {
            System.out.println("Enter any number between 1 to 100: ");
            playerMove = in.nextInt();
              System.out.println("\n you choose "+playerMove+ " computer chose " +computerMove);

            if (playerMove == computerMove) {
                score++;
                System.out.println("You win! Your score is " + score);
                return score; 
            } else {
                chance--;
                System.out.println("You lose. Your score is " + score);
                System.out.println("Chances left: " + chance);
            }
        }

        System.out.println("No more chances left.");
        return score; 
}
}