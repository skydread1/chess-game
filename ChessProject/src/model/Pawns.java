package model;

/**
 * @author Loic and Lucas
 * interface for a pawn
 *
 */
public interface Pawns {

	/**
	 * @param xFinal
	 * @param yFinal
	 * @return true if the diagonal move in ok
	 */
	boolean isMoveDiagOk(int xFinal,int yFinal);

}
