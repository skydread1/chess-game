package model.observable;

import java.util.Observable;
import java.util.Observer;

import model.BoardGames;
import model.Color;
import model.Chessboard;

/**
 * @author Loic and Lucas
 * <p>
 * Heavily connected to a Chess Board it creates It makes it observable
 * and simplify the interface (DP Proxy, Facade, Observer)
 *
 */
public class ChessGameObs extends Observable implements BoardGames {

	private Chessboard chessboard;

	/**
	 * Instantiate a chess board and notify the observers
	 */
	public ChessGameObs() {
		super();
		this.chessboard = new Chessboard();
		this.notifyObservers(chessboard.getPiecesHMI());
	}

	/**
	 * @return the chessboard
	 */
	public Chessboard getEchiquier() {
		return this.chessboard;
	}

	@Override
	public String toString() {
		String st = "";
		st += "\n" + chessboard.getMessage() + "\n";
		st = chessboard.toString();
		return st;
	}

	/**
	 * allow the move of a piece from initial to final coordinates if the move is ok
	 * also switch player
	 * 
	 * @param xInit
	 * @param yInit
	 * @param xFinal
	 * @param yFinal
	 * @return true once the move is one and player is switched
	 */
	public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
		boolean ret = false;

		ret = chessboard.isMoveOk(xInit, yInit, xFinal, yFinal);
		if (ret) {
			ret = chessboard.move(xInit, yInit, xFinal, yFinal);
		}
		if (ret) {
			chessboard.switchJoueur();
		}

		this.notifyObservers(this.chessboard.getPiecesHMI());
		return ret;
	}

	public boolean isEnd() {
		return chessboard.isEnd();
	}

	public String getMessage() {
		return chessboard.getMessage();
	}

	public Color getColorCurrentPlayer() {
		return chessboard.getColorCurrentPlayer();
	}

	public Color getPieceColor(int x, int y) {
		return chessboard.getPieceColor(x, y);
	}

	@Override
	public void notifyObservers(Object arg) {
		super.setChanged();
		super.notifyObservers(arg);
	}

	@Override
	public void addObserver(Observer o) {
		super.addObserver(o);
		this.notifyObservers(chessboard.getPiecesHMI());
	}
}