package controler.controlerLocal;

import model.Coord;
import model.Color;
import model.observable.ChessGameObs;
import controler.AbstractChessGameControler;

/**
 * @author Loic and lucas
 * <p>
 * this local controller specifies how to avoid a player which is not
 * the current player to move a piece image on the chess board
 */
public class ChessGameControler extends AbstractChessGameControler {

	/**
	 * constructor
	 * <p>
	 * 
	 * @param chessGame
	 */
	public ChessGameControler (ChessGameObs chessGame) {
		super(chessGame);
	}

	@Override
	public boolean isPlayerOK (Coord initCoord) {
		boolean ret = false;
		Color colorPiece = this.chessGame.getPieceColor(initCoord.x, initCoord.y);
		Color colorCurrentGame = this.chessGame.getColorCurrentPlayer();
		if (colorPiece.equals(colorCurrentGame)) {
			ret = true;
		}

		return ret;
	}

	@Override
	protected void endMove (Coord initCoord, Coord finalCoord, String promotionType) {
	}
}
