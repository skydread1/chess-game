package model;

/**
 * @author Loic and Lucas
 * <p>
 * Interface representing a generic board game behavior
 */
public interface BoardGames {

	/**
	 * Given the initial coordinates, move the piece to the final coordinates
	 * 
	 * @param xInit
	 * @param yInit
	 * @param xFinal
	 * @param yFinal
	 * @return true once the move is done
	 */
	public boolean move(int xInit, int yInit, int xFinal, int yFinal);

	/**
	 * @return true if game has ended
	 */
	public boolean isEnd();

	/**
	 * @return string representation of the game
	 */
	public String getMessage();

	/**
	 * @return the current player color
	 */
	public Color getColorCurrentPlayer();

	/**
	 * @param x
	 * @param y
	 * @return the current piece color
	 */
	public Color getPieceColor(int x, int y);

}
