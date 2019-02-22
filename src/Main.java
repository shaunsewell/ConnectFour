import java.util.List;

public class Main {

    public static void main(String[] args) {
        //TODO: move game loop to GameEngine.java
        //TODO: implement max turn limit
        //TODO: add ability to start a new game immediately after one has finished.
        //TODO: Add ability to reset the current game instead of exiting.

        //Game variables
        GameEngine e = new GameEngine();

        int maxTurns = 42;
        int currentTurn = 1;
        boolean playerOneTurn = true;             // True if it is currently player 1's turn
        boolean noWinner = true;
        boolean gameover = false;
        // Players
        int player1 = 1;
        int player2 = 2;

        List playerMove;
        // Gameplay loop
        System.out.println("Starting game...");
        e.board.printBoard();
        while(noWinner) {
            if(playerOneTurn) {
                System.out.println("Player 1's turn");
                playerMove = e.playTurn(1);
                System.out.println("Player 1 placed token at " + playerMove);
                if(e.board.isGameOver(1)){
                    System.out.println("Player 1 wins");
                    noWinner = false;
                }
                playerOneTurn = false;

            } else {
                System.out.println("Player 2's turn");
                playerMove = e.playTurn(2);
                System.out.println("Player 2 placed token at " + playerMove);
                if(e.board.isGameOver(2)){
                    System.out.println("Player 2 wins");
                    noWinner = false;
                }
                playerOneTurn = true;
            }
            e.board.printBoard();

        }
    }
}