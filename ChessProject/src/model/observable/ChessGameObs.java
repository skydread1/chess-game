package model.observable;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

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
public class ChessGameObs implements BoardGames {

	private Chessboard chessboard;
	// the support allows us to add, remove and notify observers
	private PropertyChangeSupport support;

	/**
	 * Instantiate a chess board and notify the observers
	 */
	public ChessGameObs() {
		super();
		this.chessboard = new Chessboard();
		support = new PropertyChangeSupport(this);
	}

	/**
	 * @return the chessboard
	 */
	public Chessboard getChessboard() {
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

		this.notifyPiecesHMI(this.chessboard);
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

	/**
	 * @param pcl
	 */
	public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }
 
    /**
     * @param pcl
     */
    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }
 
    /**
     * notify the view about the new pieces HMI.
     * @param chessboard
     */
    public void notifyPiecesHMI(Chessboard chessboard) {
        support.firePropertyChange("piecesHMI", this.chessboard.getPiecesHMI(), chessboard.getPiecesHMI());
    }
}