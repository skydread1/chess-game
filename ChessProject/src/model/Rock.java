package model;

/**
 * @author Loic and Lucas
 */
public class Rock extends AbstractPiece {
	/**
	 * @param color
	 * @param coord
	 */
	public Rock(Color color, Coord coord) {
		super(color, coord);
		this.name = "Rock";
	}

	public boolean isMoveOk(int xFinal, int yFinal) {
		boolean ret = false;
		if (isMoveOnChess(xFinal, yFinal)) {
			if ((xFinal == getX() || yFinal == getY())) {
				ret = true;
			}
		}
		return ret;
	}
}