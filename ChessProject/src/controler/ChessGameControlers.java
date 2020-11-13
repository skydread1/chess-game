package controler;

import java.util.List;

import model.Coord;

/**
 * 
 * @author Loic and Lucas
 * <p>
 * controller interface
 */
public interface ChessGameControlers {

	/**
	 * @param initCoord
	 * @param finalCoord
	 * @return true if the move is done
	 */
	public boolean move(Coord initCoord, Coord finalCoord);

	/**
	 * @return the detailed message of this Throwable instance
	 */
	public String getMessage();

	/**
	 * @return true is the has ended
	 */
	public boolean isEnd();

	/**
	 * @param initCoord
	 * @return true if the player is valid
	 */
	public boolean isPlayerOK (Coord initCoord);

	/**
	 * @param x
	 * @param y
	 * @return The coordinates of the potential moves
	 */
	public List<Coord> whereCanYouGo (int x, int y);

}
