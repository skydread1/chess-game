package controler;

import java.util.ArrayList;
import java.util.List;

import model.Coord;
import model.Color;
import model.observable.ChessGameObs;

import view.ChessGameGUI;

/**
 * @author Loic and Lucas
 * <p>
 * the controller represents the DP Strategy regarding the view
 * <p>
 * common methods for the controller which consist in establishing
 * communication between the View and the Model
 */
public abstract class AbstractChessGameControler implements ChessGameControlers {

	protected ChessGameObs chessGame;

	/**
	 * constructor
	 * <p>
	 * 
	 * @param chessGame
	 */
	public AbstractChessGameControler(ChessGameObs chessGame) {
		super();
		this.chessGame = chessGame;
	}

	/**
	 * link the View and the Model for the move
	 * <p>
	 * 
	 * @param initCoord
	 * @param finalCoord
	 *                   <p>
	 * @return boolean if move done
	 */
	final public boolean move(Coord initCoord, Coord finalCoord) {
		boolean ret = false;
		String promotionType = null;
		initCoord = conversionCoord(initCoord);
		finalCoord = conversionCoord(finalCoord);

		// make the move in the model
		ret = this.moveModel(initCoord, finalCoord);

		// variable actions regarding the controller type
		if (ret) {
			this.endMove(initCoord, finalCoord, promotionType);
		}

		return ret;
	}

	/**
	 * abstract method to verify the current player
	 */
	public abstract boolean isPlayerOK(Coord initCoord);

	/**
	 * make a move in the model
	 * <p>
	 * 
	 * @param initCoord
	 * @param finalCoord
	 *                   <p>
	 * @return a chessGame move
	 */
	protected boolean moveModel(Coord initCoord, Coord finalCoord) {
		return chessGame.move(initCoord.x, initCoord.y, finalCoord.x, finalCoord.y);
	}

	/**
	 * end a move in the model
	 * <p>
	 * 
	 * @param initCoord
	 * @param finalCoord
	 */
	protected abstract void endMove(Coord initCoord, Coord finalCoord, String promotionType);

	/**
	 * @return true if the game has ended
	 */
	public boolean isEnd() {
		return this.chessGame.isEnd();
	}

	/**
	 * @return the error message
	 */
	public String getMessage() {
		String ret = "error";
		ret = this.chessGame.getMessage();
		return ret;
	}

	/**
	 * overriding of toString method
	 * 
	 * @return a string representing the data
	 */
	public String toString() {
		return this.chessGame.toString();
	}

	/**
	 * @return the color of the current player
	 */
	protected Color getColorCurrentPlayer() {
		return this.chessGame.getColorCurrentPlayer();
	}

	/**
	 * get the color of the piece given the coordinates
	 * <p>
	 * 
	 * @param initCoord
	 *                  <p>
	 * @return a color of the piece from the chessGame
	 */
	protected Color getPieceColor(Coord initCoord) {
		return this.chessGame.getPieceColor(initCoord.x, initCoord.y);
	}

	/**
	 * convert graphic coordinates to model coordinates
	 * <p>
	 * 
	 * @param initCoord
	 *                  <p>
	 * @return coordinates between 0 to 7 instead of 0 to approximatively 850
	 */
	protected Coord conversionCoord(Coord initCoord) {
		double coordx;
		double coordy;
		coordx = (double) initCoord.x / (ChessGameGUI.getDim().width / 8);
		coordy = (double) initCoord.y / (ChessGameGUI.getDim().height / 8);
		return new Coord((int) coordx, (int) coordy);
	}

	/**
	 * show the possible moves of the piece given its coordinates
	 * 
	 * @return a list of coordinates where the piece can possibly move to
	 */
	public List<Coord> whereCanYouGo(int x, int y) {
		Coord initCoord = conversionCoord(new Coord(x, y));
		List<Coord> tabCoord = new ArrayList<Coord>();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (this.chessGame.getChessboard().isMoveOk(initCoord.x, initCoord.y, i, j)) {
					tabCoord.add(new Coord(i, j));
				}
			}
		}

		return tabCoord;
	}
}
