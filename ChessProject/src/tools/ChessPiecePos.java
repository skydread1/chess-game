package tools;

import model.Coord;
import model.Color;

/**
 * @author Loic and Lucas
 */
public enum ChessPiecePos {

	@SuppressWarnings("javadoc")
	ROCKWHITE("Rock", Color.WHITE, new Coord[] { new Coord(0, 7), new Coord(7, 7) }),
	@SuppressWarnings("javadoc")
	KNIGHTWHITE("Knight", Color.WHITE, new Coord[] { new Coord(1, 7), new Coord(6, 7) }),
	@SuppressWarnings("javadoc")
	BISHOPWHITE("Bishop", Color.WHITE, new Coord[] { new Coord(2, 7), new Coord(5, 7) }),
	@SuppressWarnings("javadoc")
	QUEENWHITE("Queen", Color.WHITE, new Coord[] { new Coord(3, 7) }),
	@SuppressWarnings("javadoc")
	KINGWHITE("King", Color.WHITE, new Coord[] { new Coord(4, 7) }),
	@SuppressWarnings("javadoc")
	PAWNWHITE("Pawn", Color.WHITE,
			new Coord[] { new Coord(0, 6), new Coord(1, 6), new Coord(2, 6), new Coord(3, 6), new Coord(4, 6),
					new Coord(5, 6), new Coord(6, 6), new Coord(7, 6) }),

	@SuppressWarnings("javadoc")
	ROCKBLACK("Rock", Color.BLACK, new Coord[] { new Coord(0, 0), new Coord(7, 0) }),
	@SuppressWarnings("javadoc")
	KNIGHTBLACK("Knight", Color.BLACK, new Coord[] { new Coord(1, 0), new Coord(6, 0) }),
	@SuppressWarnings("javadoc")
	BISHOPBLACK("Bishop", Color.BLACK, new Coord[] { new Coord(2, 0), new Coord(5, 0) }),
	@SuppressWarnings("javadoc")
	QUEENBLACK("Queen", Color.BLACK, new Coord[] { new Coord(3, 0) }),
	@SuppressWarnings("javadoc")
	KINGBLACK("King", Color.BLACK, new Coord[] { new Coord(4, 0) }),
	@SuppressWarnings("javadoc")
	PAWNBLACK("Pawn", Color.BLACK, new Coord[] { new Coord(0, 1), new Coord(1, 1), new Coord(2, 1), new Coord(3, 1),
			new Coord(4, 1), new Coord(5, 1), new Coord(6, 1), new Coord(7, 1) });

	/**
	 * name
	 */
	public String nom;
	/**
	 * color
	 */
	public Color color;
	/**
	 * coordinates
	 */
	public Coord[] coords = new Coord[8];

	ChessPiecePos(String nom, Color color, Coord[] coords) {
		this.nom = nom;
		this.color = color;
		this.coords = coords;
	}
}
