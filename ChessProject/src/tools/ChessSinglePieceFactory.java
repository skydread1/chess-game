package tools;

import model.Coord;
import model.Color;
import model.Pieces;

/**
 * @author Loic and Lucas
 *         <p>
 *         Create one chess game piece given the color, the type and the
 *         coordinates
 */
public class ChessSinglePieceFactory {

	/**
	 * private to avoid instantiation
	 */
	private ChessSinglePieceFactory() {

	}

	/**
	 * @param pieceColor
	 * @param type
	 * @param x
	 * @param y
	 * @return pieces of a chess game list
	 */
	public static Pieces newPiece(Color pieceColor, String type, int x, int y) {

		Pieces piece = null;

		String className = "model." + type; // mind the path format
		Coord pieceCoord = new Coord(x, y);
		piece = (Pieces) Introspection.newInstance(className, new Object[] { pieceColor, pieceCoord });

		return piece;
	}

	/**
	 * Unit tests
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(ChessSinglePieceFactory.newPiece(Color.WHITE, "Rock", 0, 6));
	}
}
