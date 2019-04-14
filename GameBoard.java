
import java.util.*;

/**
 * <h1>Connect Four Board</h1>
 * Class for creating and managing a Connect Four board.
 *
 * @author Shaun Sewell
 * @version 1.0
 *
 */
public class GameBoard {

    private int boardWidth, boardHeight;

    private int[][] board;

    /**
     * Class Constructor
     * @param width The width of the game board
     * @param height  the height of the game board
     */
    public GameBoard(int height, int width) {
        this.boardWidth = width;
        this.boardHeight = height;
        this.board = new int[height][width];
    }

    /**
     * Game Board getter.
     * @return int[][] Returns the game board as 2D array
     */
    public int[][] getBoard() {
        return board;
    }

    /**
     * This method resets the game board array to an empty state.
     */
    public void resetBoard() {
        for (int r = 0; r < boardHeight; r++) {
            for (int c = 0; c < boardWidth; c++) {
                board[r][c] = 0;
            }
        }
    }

    /**
     * This method is used to check if a chosen column is a valid place to drop a token.
     * @param column The column the player is trying to place a token into.
     * @return boolean This returns true if the column is valid.
     */
    public boolean isValidColumn(int column) {

        if (column < 0 || column >= boardWidth) {
            return false;
        }

        return true;
    }

    /**
     * This method is used to check if a chosen column is has empty space to place a token.
     * @param column The column the player is trying to place a token into.
     * @return int[] This returns two ints. The first indicates success or failure and the
     * second the potential row to add the token to.
     */
    public int[] canAddToken(int column) {

        for(int r = 0; r < boardHeight; r++) {
            if(board[r][column] == 0) {         //empty space
                return new int[] {1, r};
            }
        }
        return new int[] {0, -1};
    }

    /**
     * This method is used to add a players token to the board.
     * @param player The token of the current player. Either 1 or 2.
     * @param row The row to add the token to.
     * @param column The column to add the token to.
     */
    public void addToken(int player, int row, int column) {
        board[row][column] = player;
    }

    /**
     * This method is used to check the board for any possible win states.
     * @param player The token of the current player.
     * @return boolean Whether the player has won or not.
     */
    public boolean isGameOver(int player) {
        List sequence;
        //int count = 0;
        // Vertical
        for(int row = 0; row < boardHeight - 3; row++) {
            for(int col = 0; col < boardWidth; col++) {
                sequence = checkAdjacentNodes(player, row, col,1,0);
                if(sequence.size() == 4) {
                    return true;
                }
            }
        }
        // Horizontal
        for(int row = 0; row < boardHeight; row++) {
            for(int col = 0; col < boardWidth - 3; col++) {
                sequence = checkAdjacentNodes(player, row, col,0,1);
                if(sequence.size() == 4) {
                    return true;
                }
            }
        }

        // Forward Diagonal
        for(int row = 0; row < boardHeight - 3; row++) {
            for(int col = 0; col < boardWidth - 3; col++) {
                sequence = checkAdjacentNodes(player, row, col,1,1);
                if(sequence.size() == 4) {
                    return true;
                }
            }
        }

        // Back Diagonal
        for(int row = 3; row < boardHeight; row++) {
            for(int col = 0; col < boardWidth - 3; col++) {
                sequence = checkAdjacentNodes(player, row, col,-1,1);
                if(sequence.size() == 4) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * This method checks the adjacent nodes in a row, column or diagonal for the players token.
     * @param player The player token
     * @param row The row to start checking from.
     * @param column The column to start checking from.
     * @param rowOffset The change the row variable should make with each step.
     * @param columnOffset The change the column variable should make with each step.
     * @return List Returns the list of player tokens in the row, column or diagonal.
     */
    List checkAdjacentNodes(int player, int row, int column, int rowOffset, int columnOffset) {
        List nodeSequence = new ArrayList();

        for(int i = 0; i < 4; i++) {
            if(player == board[row][column]){
                // need to change to some sort of tuple like system.
                nodeSequence.add(board[row][column]);
            }
            row += rowOffset;
            column += columnOffset;
        }

        return nodeSequence;
    }

    public void printBoard() {

        for(int h = boardHeight - 1; h >= 0; h--) {
            String row = "";
            for (int w = 0; w < boardWidth; w++) {
                int element = board[h][w];
                row += (String.valueOf(element));
                row += ("|");
            }
            System.out.println(row);
        }
    }

}
