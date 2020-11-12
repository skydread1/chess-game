package tools;



import model.Coord;
import model.Color;
import model.Pieces;

/**
 * @author francoise.perrin
 * Inspiration Jacques SARAYDARYAN, Adrien GUENARD
 * 
 * Classe qui fabrique 1 pièce de jeu d'echec
 * de la color, du type et aux coordonnées
 * passées en paramètre
 *
 */
public class ChessSinglePieceFactory {

	/**
	 * private pour ne pas instancier d'objets
	 */
	private ChessSinglePieceFactory() {

	}

	/**
	 * @param pieceColor
	 * @param type 
	 * @param x 
	 * @param y 
	 * @return pieces of a chest game list
	 */
	public static Pieces newPiece(Color pieceColor, String type, int x, int y){

		Pieces piece = null;

		String className = "model." + type;	// attention au chemin		
		Coord pieceCoord = new Coord(x, y);
		piece = (Pieces) Introspection.newInstance (className,
				new Object[] {pieceColor, pieceCoord});

		return piece;
	}

	/**
	 * Tests unitaires
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(ChessSinglePieceFactory.newPiece(Color.WHITE, "Rock", 0, 6));
	}
}
