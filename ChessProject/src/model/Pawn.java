package model;

/**
 * @author lucas.loic
 *
 */
public class Pawn extends AbstractPiece implements Pawns {

	/**
	 * constructor
	 * <p>
	 * 
	 * @param color
	 * @param coord
	 */
	public Pawn(Color color, Coord coord) {
		super(color, coord);
		this.name = "Pawn";
	}

	public boolean isMoveOk(int xFinal, int yFinal) {
		boolean ret = false;
		if (isMoveOnChess(xFinal, yFinal)) {
			if (getColor() == Color.WHITE) {
				if (xFinal == getX() && yFinal == getY() - 1) {
					ret = true;
				}
				if (getY() == 6 && yFinal == 4 && xFinal == getX()) {
					ret = true;
				}
			}

			if (getColor() == Color.BLACK) {
				if (xFinal == getX() && yFinal == getY() + 1) {
					ret = true;
				}
				if (getY() == 1 && yFinal == 3 && xFinal == getX()) {
					ret = true;
				}

			}
		}
		return ret;
	}

	public boolean isMoveDiagOk(int xFinal, int yFinal) {
		boolean ret = false;
		if (getColor() == Color.WHITE) {
			if (isMoveOnChess(xFinal, yFinal)) {
				if (Math.abs(xFinal - getX()) == 1 && yFinal == getY() - 1) {
					ret = true;
				}
			}
		}
		if (getColor() == Color.BLACK) {
			if (isMoveOnChess(xFinal, yFinal)) {
				if (Math.abs(xFinal - getX()) == 1 && yFinal == getY() + 1) {
					ret = true;
				}
			}
		}
		return ret;
	}

}
