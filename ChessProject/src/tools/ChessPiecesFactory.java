package tools;

import java.util.LinkedList;
import java.util.List;

import model.Coord;
import model.Color;
import model.Pieces;

/**
 * @author Loic and Lucas
 * <p>
 * Build the HMI pieces given the color.
 */
public class ChessPiecesFactory {

	/**
	 * private to avoid instantiation
	 */
	private ChessPiecesFactory() {

	}

	/**
	 * @param pieceColor
	 * @return CHess game piece list
	 */
	public static List<Pieces> newPieces(Color pieceColor) {

		List<Pieces> pieces = null;
		pieces = new LinkedList<Pieces>();
		// String initColor = (Color.WHITE == pieceColor ? "B_" : "N_" );

		if (pieceColor != null) {
			for (int i = 0; i < ChessPiecePos.values().length; i++) {

				if (pieceColor.equals(ChessPiecePos.values()[i].color)) {
					for (int j = 0; j < (ChessPiecePos.values()[i].coords).length; j++) {
						String className = "model." + ChessPiecePos.values()[i].nom; // mind the path format
						Coord pieceCoord = ChessPiecePos.values()[i].coords[j];
						pieces.add(
								(Pieces) Introspection.newInstance(className, new Object[] { pieceColor, pieceCoord }));
					}
				}
			}
		}
		return pieces;
	}

	/**
	 * Unit Tests
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(ChessPiecesFactory.newPieces(Color.WHITE));
	}
}
