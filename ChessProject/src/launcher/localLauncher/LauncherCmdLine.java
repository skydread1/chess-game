package launcher.localLauncher;

import java.util.Observer;

import model.observable.ChessGameObs;
import vue.ChessGameCmdLine;
import controler.controlerLocal.ChessGameControler;


/**
 * @author francoise.perrin
 * <p>
 * COnsole mode execution
 */
public class LauncherCmdLine {

	/**
	 * main of the launcher in command line
	 * <p>
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
		model.addObserver((Observer) vue);
		vue.go();
	}

}
