package model;

/**
 * @author lucas/loïc
 * interface d'un pawn
 *
 */
public interface Pawns {

	/**
	 * @param xFinal
	 * @param yFinal
	 * @return un booléen indiquant si le mouvement en diagonal a été effectué
	 */
	boolean isMoveDiagOk(int xFinal,int yFinal);

}
