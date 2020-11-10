package controler.controlerLocal;

import model.Coord;
import model.Color;
import model.observable.ChessGame;
import controler.AbstractChessGameControler;

/**
 * @author francoise.perrin
 * <p>
 * this local controller precise how to avoid a player which is not the current player to move a piece image on the chest
 */
public class ChessGameControler extends AbstractChessGameControler {

	/**
	 * constructor
	 * <p>
	 * @param chessGame
	 */
	public ChessGameControler(ChessGame chessGame) {
		super(chessGame);
	}

	@Override
	public boolean isPlayerOK(Coord initCoord) {
		boolean ret=false;
		Color couleurPiece=this.chessGame.getPieceColor(initCoord.x, initCoord.y);
		Color couleurJeuCourant=this.chessGame.getColorCurrentPlayer();
		if(couleurPiece.equals(couleurJeuCourant))
		{
			ret=true;
		}

		return ret;

	}

	@Override
	protected void endMove(Coord initCoord, Coord finalCoord,
			String promotionType) {
		//this.chessGame.getEchiquier().switchJoueur();	

	}

}
