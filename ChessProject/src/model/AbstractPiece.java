package model;

/**
 * @author Loic and Lucas
 * <p>
 * abstract class containing the common methods for all
 * pieces in the chess game
 */
public abstract class AbstractPiece extends java.lang.Object implements Pieces {

	protected String name;
	private Color color;
	private Coord coord;

	/**
	 * @param color
	 * @param coord
	 */
	public AbstractPiece(Color color, Coord coord) {
		this.coord = coord;
		this.color = color;
	}

	public String getName() {
		return this.getClass().getSimpleName();
	}

	public int getX() {
		return this.coord.x;
	}

	public int getY() {
		return this.coord.y;
	}

	public Color getColor() {
		return this.color;
	}

	/**
	 * move the piece
	 * <p>
	 * 
	 * @param x
	 * @param y
	 *          <p>
	 * @return true once the move is done
	 */
	public boolean move(int x, int y) {
		this.coord.x = x;
		this.coord.y = y;
		return true;
	}

	/**
	 * capture the piece
	 * <p>
	 * 
	 * @return true once the capture is done
	 */
	public boolean capture() {
		this.coord.x = -1;
		this.coord.y = -1;
		return true;
	}

	/**
	 * @return a string representation of piece
	 */
	public java.lang.String toString() {
		return "Piece type :" + this.name + " Coords : (" + String.valueOf(getX()) + "," + String.valueOf(getY())
				+ ") \r";
	}

	/**
	 * @param xFinal
	 * @param yFinal
	 * @return true if the move is valid
	 */
	public abstract boolean isMoveOk(int xFinal, int yFinal);

	/**
	 * verify if the move is on the chess, the coordinates are between 0 to 7
	 * <p>
	 * 
	 * @param xFinal
	 * @param yFinal
	 * 
	 * @return true if the move is on the chess
	 */
	public boolean isMoveOnChess(int xFinal, int yFinal) {
		boolean ret = false;
		if (!(xFinal == getX() && yFinal == getY())) {
			if ((xFinal >= 0 && xFinal <= 7 && xFinal >= 0 && xFinal <= 7) || (xFinal == -1 && yFinal == -1)) {
				ret = true;
			}
		}
		return ret;
	}
}
