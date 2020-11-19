package launcher.localLauncher;

import java.beans.PropertyChangeListener;
import java.util.Observer;

import model.observable.ChessGameObs;
import view.ChessGameCmdLine;
import controler.controlerLocal.ChessGameControler;

/**
 * @author Loic and Lucas
 * <p>
 * Command line launcher
 */
public class LauncherCmdLine {

	/**
	 * main of the launcher in command line
	 * <p>
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		ChessGameObs model;
		ChessGameControler controler;
		ChessGameCmdLine vue;

		model = new ChessGameObs();
		controler = new ChessGameControler(model);

		new ChessGameCmdLine(controler);

		vue = new ChessGameCmdLine(controler);
		model.addPropertyChangeListener((PropertyChangeListener) vue);
		vue.go();
	}

}