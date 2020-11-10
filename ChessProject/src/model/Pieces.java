package model;


/**
 * @author lucas.loic
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
	Color getCouleur();
	/**
	 * @param xFinal
	 * @param yFinal
	 * @return true if the move is ok
	 */
	boolean isMoveOk(int xFinal,int yFinal);
	/**
	 * @param xFinal
	 * @param yFinal
	 * @return true if the move is done
	 */
	boolean move(int xFinal,int yFinal);
	/**
	 * @return true if the capute is done
	 */
	boolean capture();
	/**
	 * @return the name
	 */
	String getName();
	java.lang.String toString();
}
