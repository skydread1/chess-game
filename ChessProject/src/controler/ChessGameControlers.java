package controler;

import java.util.List;

import model.Coord;

/**
 * 
 * @author lucas.loic
 * <p>
 * controller interface
 *
 */
public interface ChessGameControlers {


	/**
	 * @param initCoord
	 * @param finalCoord
	 * @return true if the move is done
	 */
	public boolean move(Coord initCoord, Coord finalCoord);

	/**
	 * @return message related to the error type
	 */
	public String getMessage();

	/**
	 * @return true is the game end in legal
	 */
	public boolean isEnd();

	/**
	 * @param initCoord
	 * @return info which will allow to avoid a chest move in the view 
	 */
	public boolean isPlayerOK(Coord initCoord);

	/**
	 * @param x
	 * @param y
	 * @return les coordonnées des cases où la pièce peut aller
	 */
	public List<Coord> whereCanYouGo(int x,int y);

}
