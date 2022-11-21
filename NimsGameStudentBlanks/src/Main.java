import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("What is player1's name?: ");
        String name = sc.nextLine();
        Player p1 = new Player(name);

        System.out.println("What is player2's name?: ");
        String name2 = sc.nextLine();
        Player p2 = new Player(name2);

        String again = "Literally any string";
        Player currentPlayer;

        // Runs the game
        while (!again.equals("q")) {
            Game game = new Game(p1, p2);

            int playerChoose = (int) (Math.random() * 2);
            if (playerChoose == 1) {
                currentPlayer = p1;
            } else {
                currentPlayer = p2;
            }
            System.out.println("It is now player " + playerChoose + " turn");

            game.setFirstPlayer(currentPlayer);
            // This is the loop in which the game will be played
            while (!game.isComplete()) {
                game.takePiece();
                // TO DO

                currentPlayer = game.getNextPlayer();
            }
            System.out.println(currentPlayer.getName() + " Won!!");
            System.out.println(p1.getName() + " had removed " + p1.getScore() + " pieces!");
            System.out.println(p2.getName() + " had removed " + p2.getScore() + " pieces!");
            System.out.println("------------------------------------------");
            System.out.println("Enter q to quit, enter anything else to play again.");
            again = sc.nextLine();
        }
        System.out.println("Thank you for playing!");
    }
}
