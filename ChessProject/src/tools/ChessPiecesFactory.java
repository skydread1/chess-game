package tools;

import java.util.LinkedList;
import java.util.List;

import model.Coord;
import model.Color;
import model.Pieces;

/**
 * @author francoise.perrin
 * Inspiration Jacques SARAYDARYAN, Adrien GUENARD
 * 
 * Classe qui fabrique une liste de pieces de jeu d'echec
 * de la color pass�e en param�tre
 *
 */
public class ChessPiecesFactory {

	/**
	 * private pour ne pas instancier d'objets
	 */
	private ChessPiecesFactory() {

	}

	/**
	 * @param pieceColor
	 * @return liste de pi�ces de jeu d'�chec
	 */
	public static List<Pieces> newPieces(Color pieceColor){

		List<Pieces> pieces = null;
		pieces = new LinkedList<Pieces>();
		//String initColor = (Color.WHITE == pieceColor ? "B_" : "N_" );

		if (pieceColor != null){
			for (int i = 0; i < ChessPiecePos.values().length; i++) {

				if (pieceColor.equals(ChessPiecePos.values()[i].color)) {
					for (int j = 0; j < (ChessPiecePos.values()[i].coords).length; j++) {
						String className = "model." + ChessPiecePos.values()[i].nom;	// attention au chemin
						Coord pieceCoord = ChessPiecePos.values()[i].coords[j];
						pieces.add((Pieces) Introspection.newInstance (className,
								new Object[] {pieceColor, pieceCoord}));
					}
				}
			}
		}
		return pieces;
	}

	/**
	 * Tests unitaires
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(ChessPiecesFactory.newPieces(Color.WHITE));
	}
}
