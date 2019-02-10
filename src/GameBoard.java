import java.lang.reflect.Array;
import java.util.*;

/**
 *
 */
public class GameBoard {

    int boardWidth, boardHeight;
    private int[][] board;

    /*
        Constructor
     */
    public GameBoard(int width, int height) {
        this.boardWidth = width;
        this.boardHeight = height;
        this.board = new int[height][width];
    }


    public void resetBoard() {
        for (int r = 0; r < boardHeight; r++) {
            for (int c = 0; c < boardWidth; c++) {
                board[r][c] = 0;
            }
        }
    }

    public boolean isValidColumn(int column) {

        if (column < 0 || column >= boardWidth) {
            return false;
        }

        return true;
    }

    public boolean canAddToken(int column) {


        return true;
    }

    public int addToken(int row, int column) {

        return 0;
    }

    /*
        Token is 1 for player 1 and 2 for player 2
     */
    public boolean isGameOver(int player) {

        // Vertical

        // Horizontal


        // Forward Diagonal


        // Back Diagonal

        return true;
    }

    int[] checkAdjacentNodes(int player, int row, int column, int rowOffset, int columnOffset) {
        int[] adjacent = new int[4];
        return adjacent;
    }

}