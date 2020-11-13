package launcher.localLauncher;

import java.awt.Dimension;
import java.util.Observer;

import javax.swing.JFrame;

import controler.ChessGameControlers;
import controler.controlerLocal.ChessGameControler;
import model.observable.ChessGameObs;
import view.ChessGameGUI;

/**
 * @author Loic and Lucas
 * <p>
 * GUI launcher The View (ChessGameGUI) observes The Model (ChessGame)
 * Information goes through the Controller (ChessGameControlers)
 */
public class LauncherGUI {

	/**
	 * main for the GUI launcher
	 * <p>
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		ChessGameObs chessGame;
		ChessGameControlers chessGameControler;
		JFrame frame;
		Dimension dim;

		dim = new Dimension(800, 800);

		chessGame = new ChessGameObs();
		chessGameControler = new ChessGameControler(chessGame);

		frame = new ChessGameGUI("Game d'echec", chessGameControler, dim);
		chessGame.addObserver((Observer) frame);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(600, 10);
		frame.setPreferredSize(dim);
		frame.pack();
		frame.setVisible(true);
	}
}
