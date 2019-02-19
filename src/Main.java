import java.util.List;

public class Main {

    public static void main(String[] args) {

        //Game variables
        GameEngine e = new GameEngine();

        int maxTurns = 42;
        int currentTurn = 1;
        boolean playerOneTurn = true;             // True if it is currently player 1's turn
        boolean noWinner = true;

        // Players
        int player1 = 1;
        int player2 = 2;

        // Gameplay loop
        while(noWinner) {
            List playerMove = e.playTurn(1);
            e.board.printBoard();
            System.out.println(playerMove);
        }
    }
}