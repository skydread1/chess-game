package model;


/**
 * @author Loic and Lucas
 * <p>
 * Pieces interface
 *
 */
public interface Pieces {
	/**
	 * @return x
	 */
	int getX();
	/**
	 * @return y
	 */
	int getY();
	/**
	 * @return color
	 */
	Color getColor();
	/**
	 * @param xFinal
	 * @param yFinal
	 * @return true if the move is valid
	 */
	boolean isMoveOk(int xFinal,int yFinal);
	/**
	 * @param xFinal
	 * @param yFinal
	 * @return true if the move is done
	 */
	boolean move(int xFinal,int yFinal);
	/**
	 * @return true if the capture is done
	 */
	boolean capture();
	/**
	 * @return the name
	 */
	String getName();
	java.lang.String toString();
}
