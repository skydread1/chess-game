package view;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import model.Coord;
import model.Color;
import model.PieceHMI;
import controler.controlerLocal.ChessGameControler;



/**
 * @author francoise.perrin
 * Inspiration Jacques SARAYDARYAN, Adrien GUENARD *
 * 
 * Vue console d'un game d echec
 * Cette classe est un observateur et le damier est mis a jour a chaque changement dans la classe metier
 */
public class ChessGameCmdLine implements Observer{

	ChessGameControler chessGameControler;

	/**
	 * @param chessGameControler
	 */
	public   ChessGameCmdLine(ChessGameControler chessGameControler) {
		this.chessGameControler = chessGameControler;
	}

	@Override
	public void update(Observable arg0, Object arg1) {

		System.out.println(chessGameControler.getMessage() + "\n");	

		@SuppressWarnings("unchecked")
		List<PieceHMI> piecesIHM = (List<PieceHMI>) arg1;


		String[][] damier = new String[8][8];

		// crﾃｩation d'un tableau 2D avec les noms des piﾃｨces
		for(PieceHMI pieceIHM : piecesIHM) {

			Color color = pieceIHM.getColor();
			String stColor = (Color.WHITE == color ? "B_" : "N_" );
			String type = (pieceIHM.getTypePiece()).substring(0, 2);

			for(Coord coord : pieceIHM.getList()) {
				damier[coord.y][coord.x] = stColor + type;
			}			
		}

		// Affichage du tableau formatte
		String st = "    0     1     2     3     4     5    6     7 \n";
		for ( int i = 0; i < 8; i++) {
			st += i + " ";
			for ( int j = 0; j < 8; j++) {				 
				String nomPiece = damier[i][j];				
				if (nomPiece != null) {						
					st += nomPiece + "  ";	
				} 
				else {
					st += "____  ";
				}
			}
			st +="\n";
		}

		System.out.println(st);		
	}

	/**
	 * main de test
	 */
	public void go() {

		System.out.print("\n Dﾃｩplacement de 3,6 vers 3,4 = ");
		chessGameControler.move(new Coord(3,6), new Coord(3, 4));	// true

		// dans ce cas, update non appelﾃｩ et pas d'affichage 
		// controleur empﾃｪche le move car pas le bon joueur
		System.out.print("\n Dﾃｩplacement de 3,4 vers 3,6 = ");		
		chessGameControler.move(new Coord(3,4), new Coord(3, 6));	// false 

		System.out.print("\n Dﾃｩplacement de 4,1 vers 4,3 = ");
		chessGameControler.move(new Coord(4, 1), new Coord(4, 3));	// true

		System.out.print("\n Dﾃｩplacement de 3,4 vers 3,4 = ");
		chessGameControler.move(new Coord(3, 4), new Coord(3, 4));	// false

		System.out.print("\n Dﾃｩplacement de 3,4 vers 4,3 = ");
		chessGameControler.move(new Coord(3, 4), new Coord(4, 3));	// true		


		chessGameControler.move(new Coord(3,6), new Coord(3, 4)); 

	}

}
