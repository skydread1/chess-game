package model;


/**
 * @author Loic
 * Interface representing general board games behavior
 */
public interface BoardGames {	

	/**
	 * Given the initial coordinates, move the piece to the final coordinates
	 * @param xInit
	 * @param yInit
	 * @param xFinal
	 * @param yFinal
	 * @return OK if move OK 
	 */
	public boolean move (int xInit, int yInit, int xFinal, int yFinal); 


	/**
	 * @return true if end is reached
	 */
	public boolean isEnd();

	/**
	 * @return the game state
	 */
	public String getMessage();

	/**
	 * @return the current player color
	 */
	public Color getColorCurrentPlayer();

	/**
	 * @param x
	 * @param y
	 * @return the current selected piece color
	 */
	public Color getPieceColor(int x, int y);

}
