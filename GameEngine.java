
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameEngine {

    //Input reader
    Scanner scanner = null;

    // Initialise GameBoard
    GameBoard board = new GameBoard(6, 7);

    // Start game loop

    public List playTurn(int player){
        List moveLocation = new ArrayList();

        try {
            scanner = new Scanner(System.in);
            System.out.println("Enter column number to drop token into. -1 to exit.");
            int move = Integer.parseInt(scanner.nextLine().trim());
            if (move != -1) {
                move -= 1;     // get the move into 0 index form.
                while(true) {
                    if(board.isValidColumn(move)) {
                        int[] row = board.canAddToken(move);
                        if(row[0] == 1) {
                            board.addToken(player, row[1], move);
                            moveLocation.add(move);
                            moveLocation.add(row[1]);
                            break;
                        }
                    }
                    System.out.println("Invalid column. Try again. -1 to exit.");
                    move = Integer.parseInt(scanner.nextLine().trim());
                    if(move == -1) {
                        System.exit(-1);
                    }
                    move -= 1;
                }
            } else {
                System.exit(-1);
            }

            //check if input is valid
            //
        } catch (Exception e) {
            System.out.println("Unable to read input");
        }
        return moveLocation;
    }
}
