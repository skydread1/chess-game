package model;

/**
 * @author Loic and Lucas
 *
 */
public class Queen extends AbstractPiece {
	/**
	 * @param color
	 * @param coord
	 */
	public Queen(Color color, Coord coord) {
		super(color, coord);
		this.name = "Queen";

	}

	public boolean isMoveOk(int xFinal, int yFinal) {
		boolean ret = false;
		if (isMoveOnChess(xFinal, yFinal)) {
			int x = xFinal - getX();
			int y = yFinal - getY();
			if ((xFinal == getX() || yFinal == getY()) || (Math.abs(y) == Math.abs(x))) {
				ret = true;
			}
		}
		return ret;
	}

}