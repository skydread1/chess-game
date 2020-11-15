package model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tools.ChessPiecesFactory;

/**
 * @author Loic and Lucas
 */
public class Game extends java.lang.Object {
	private List<Pieces> pieces = null;
	private Color color;

	/**
	 * @param color
	 */
	public Game(Color color) {
		pieces = ChessPiecesFactory.newPieces(color);
		this.color = color;
	}

	/**
	 * @param x
	 * @param y
	 * @return true if there is a piece at the given coordinates
	 */
	public boolean isPieceHere(int x, int y) {
		boolean ret = false;
		if (findPiece(x, y) != null) {
			ret = true;
		}
		return ret;
	}

	/**
	 * @param xInit
	 * @param yInit
	 * @param xFinal
	 * @param yFinal
	 * @return true if the move is possible
	 */
	public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal) {
		boolean ret = false;

		if (isPieceHere(xInit, yInit)) {
			Pieces piece = findPiece(xInit, yInit);
			ret = piece.isMoveOk(xFinal, yFinal);
		}

		return ret;
	}

	/**
	 * move a piece on the chess board
	 * <p>
	 * 
	 * @param xInit
	 * @param yInit
	 * @param xFinal
	 * @param yFinal
	 * <p>
	 * @return true once the move is done
	 */
	public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
		boolean ret = false;
		Pieces piece = findPiece(xInit, yInit);
		ret = piece.move(xFinal, yFinal);

		return ret;
	}

	/**
	 * verify if the capture is possible
	 * <p>
	 * 
	 * @param xCapture
	 * @param yCapture
	 * <p>
	 * @return true if the capture is possible
	 */
	public boolean isCapturePossible(int xCapture, int yCapture) {
		boolean ret = false;

		if (isPieceHere(xCapture, yCapture)) {
			ret = true;
		}
		return ret;
	}

	/**
	 * do the capture
	 * <p>
	 * 
	 * @param xCapture
	 * @param yCapture
	 */
	public void capture(int xCapture, int yCapture) {
		if (isCapturePossible(xCapture, yCapture)) {
			Pieces p = findPiece(xCapture, yCapture);
			p.capture();
			System.out.println("CAPTURE");
		}
	}

	public java.lang.String toString() {
		return this.pieces.toString();

	}

	/**
	 * @param x
	 * @param y
	 * <p>
	 * @return the color of the piece at the given coordinates
	 */
	public Color getPieceColor(int x, int y) {
		Color ret = Color.BLACKWHITE;
		if (isPieceHere(x, y)) {
			Pieces pieces = findPiece(x, y);
			ret = pieces.getColor();
		}
		return ret;
	}

	/**
	 * @param x
	 * @param y
	 * @return the name of the piece at the given coordinates
	 */
	public java.lang.String getPieceType(int x, int y) {
		java.lang.String ret = null;
		Pieces pieces = findPiece(x, y);
		if (pieces != null) {
			ret = pieces.getName();
		}
		return ret;
	}

	/**
	 * @return the color of the game
	 */
	public Color getColor() {
		return this.color;
	}

	/**
	 * @return a list of the on going HMI pieces with read access only
	 */
	public List<PieceHMI> getPiecesIHM() {
		PieceHMI newPieceIHM = null;
		List<PieceHMI> list = new LinkedList<PieceHMI>();
		for (Pieces piece : pieces) {
			boolean existe = false;

			// piece type exists in list so add the coordinates of the new piece of this type
			for (PieceHMI pieceIHM : list) {
				if ((pieceIHM.getTypePiece()).equals(piece.getClass().getSimpleName())) {
					existe = true;
					if (piece.getX() != -1) {
						pieceIHM.add(new Coord(piece.getX(), piece.getY()));
					}
				}
			}
			// piece type does not exist in list so create a HMI piece and add it to the list
			if (!existe) {
				if (piece.getX() != -1) {
					newPieceIHM = new PieceHMI(piece.getClass().getSimpleName(), piece.getColor());
					newPieceIHM.add(new Coord(piece.getX(), piece.getY()));
					list.add(newPieceIHM);
				}
			}
		}
		return list;
	}

	/**
	 * The rule of castling :
	 * 
	 * @see <a href="https://www.youtube.com/watch?v=4jXQyGaeUV8&ab_channel=Chess.com">How to Castle</a>
	 * @param xInit
	 * @param yInit
	 * @param xFinal
	 * @param yFinal
	 * @return true if the castling is possible given the king new coordinates
	 * 
	 * TODO: the king and the switching Rock should not have moved the entire game
	 * 		 the steps between the King and the Rock should not be in check
	 */
	public boolean isCastlingPossible(int xInit, int yInit, int xFinal, int yFinal) {
		boolean ret = false;
		Color kingColor = getColor();
		// King is White and at starting position.
		if (kingColor == Color.WHITE && xInit == 4 && yInit == 7) {
			// King castling with right Rock
			if (xFinal == 6 && yFinal == 7) {
				// No pieces between King and Rock
				if (!isPieceHere(5, 7) && !isPieceHere(6, 7) && isPieceHere(7, 7)) {
					if (findPiece(7, 7).getName().equals("Rock") && findPiece(7, 7).getColor() == kingColor) {
						ret = true;
					}
				}
			}

			// King castling with left Rock
			if (xFinal == 2 && yFinal == 7) {
				// No pieces between King and Rock
				if (isPieceHere(0, 7) && !isPieceHere(1, 7) && !isPieceHere(2, 7) && !isPieceHere(3, 7)) {
					if (findPiece(0, 7).getName().equals("Rock") && findPiece(0, 7).getColor() == kingColor) {
						ret = true;
					}
				}
			}
		}

		// King is Black and at starting position.
		if (kingColor == Color.BLACK && xInit == 4 && yInit == 0) {
			// King castling with right Rock
			if (xFinal == 6 && yFinal == 0) {
				// No pieces between King and Rock
				if (!isPieceHere(5, 0) && !isPieceHere(6, 0) && isPieceHere(7, 0)) {
					if (findPiece(7, 0).getName().equals("Rock") && findPiece(7, 0).getColor() == kingColor) {
						ret = true;
					}
				}
			}

			// King castling with left Rock
			if (xFinal == 2 && yFinal == 0) {
				// No pieces between King and Rock
				if (isPieceHere(0, 0) && !isPieceHere(1, 0) && !isPieceHere(2, 0) && !isPieceHere(3, 0)) {
					if (findPiece(0, 0).getName().equals("Rock") && findPiece(0, 0).getColor() == kingColor) {
						ret = true;
					}
				}
			}
		}
		return ret;
	}

	/**
	 * 7 Do the castle move, meaning move the king and the Rock accordingly
	 * 
	 * @param xInit  of the king
	 * @param yInit  of the king
	 * @param xFinal of the king
	 * @param yFinal of the king
	 * @return true once the castling move is done
	 * 
	 */
	public boolean castle(int xInit, int yInit, int xFinal, int yFinal) {
		boolean ret = false;
		if (this.isCastlingPossible(xInit, yInit, xFinal, yFinal)) {
			// move the king
			move(xInit, yInit, xFinal, yFinal);

			// move the rock
			// white
			if (yInit == 7) {
				// right
				if (xFinal == 6) {
					move(7, 7, 5, 7);
					ret = true;
				}
				// left
				else {
					move(0, 7, 3, 7);
					ret = true;
				}
			}
			// black
			else {
				// right
				if (xFinal == 6) {
					move(7, 0, 5, 0);
					ret = true;
				}
				// left
				else {
					move(0, 0, 3, 0);
					ret = true;
				}
			}
		}
		System.out.println("CASTLING");
		return ret;
	}

	/**
	 * undo previous move
	 */
	public void undoMove() {

	}

	/**
	 * undo previous capture
	 */
	public void undoCapture() {

	}

	/**
	 * @param xFinal
	 * @param yFinal
	 * @return true if the pawn promotion is possible
	 */
	public boolean isPawnPromotion(int xFinal, int yFinal) {
		boolean ret = false;
		if (getColor() == Color.WHITE) {
			if (yFinal == 7) {
				ret = true;
			}
		}

		if (getColor() == Color.BLACK) {
			if (yFinal == 0) {
				ret = true;
			}
		}
		return ret;
	}

	/**
	 * do the promotion
	 * 
	 * @param xFinal
	 * @param yFinal
	 * @param type
	 * @return true once the promotion is done
	 */
	public boolean pawnPromotion(int xFinal, int yFinal, java.lang.String type) {
		boolean ret = false;
		if (this.getPieceType(xFinal, yFinal) == "Pawn" && type != "Pawn" && type != "King") {
			Pieces piece = findPiece(xFinal, yFinal);
			piece.move(-1, -1);
			switch (type) {
			case "Queen":
				pieces.add(new Queen(piece.getColor(), new Coord(xFinal, yFinal)));
				ret = true;
				break;
			case "Rock":
				pieces.add(new Rock(piece.getColor(), new Coord(xFinal, yFinal)));
				ret = true;
				break;
			case "Bishop":
				pieces.add(new Bishop(piece.getColor(), new Coord(xFinal, yFinal)));
				ret = true;
				break;
			case "Knight":
				pieces.add(new Knight(piece.getColor(), new Coord(xFinal, yFinal)));
				ret = true;
				break;
			default:
				ret = false;
			}
		}
		return ret;
	}

	/**
	 * @return the King coordinates
	 */
	public Coord getKingCoord() {
		Coord ret = null;
		Coord coord = new Coord(0, 0);
		Iterator<Pieces> li = pieces.listIterator();

		while (li.hasNext()) {
			Pieces p_tampon = li.next();
			if (p_tampon.getClass().getSimpleName().contains("King")) {
				coord.x = p_tampon.getX();
				coord.y = p_tampon.getY();
				ret = coord;
			}
		}
		return ret;
	}

	/**
	 * @param x
	 * @param y
	 * @return the piece at the given coordinates
	 */
	Pieces findPiece(int x, int y) {
		Pieces ret = null;
		Iterator<Pieces> i = pieces.iterator();
		Pieces piece;
		while (i.hasNext()) {
			piece = (Pieces) i.next();
			if (piece.getX() == x && piece.getY() == y)
				ret = piece;
		}
		return ret;
	}

	/**
	 * Unit tests
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Unit test for Castling check and move - all prints should return true");

		Game whiteGame = new Game(Color.WHITE);
		System.out.println(whiteGame.isCastlingPossible(4, 7, 6, 7) == false);

		whiteGame.move(4, 6, 4, 5); // move pawn up
		whiteGame.move(5, 7, 2, 4); // move out the right bishop
		whiteGame.move(6, 7, 7, 5); // move out right knight
		System.out.println(whiteGame.isCastlingPossible(4, 7, 6, 7));
		System.out.println(whiteGame.castle(4, 7, 6, 7));
		System.out.println(whiteGame.findPiece(6, 7).getName().equals("King"));

		Game blackGame = new Game(Color.BLACK);
		System.out.println(blackGame.isCastlingPossible(4, 0, 6, 0) == false);
		blackGame.move(4, 1, 4, 2); // move pawn up
		blackGame.move(5, 0, 2, 3); // move out the right bishop
		blackGame.move(6, 0, 7, 2); // move out right knight
		System.out.println(blackGame.isCastlingPossible(4, 0, 6, 0));
		System.out.println(blackGame.castle(4, 0, 6, 0));
		System.out.println(blackGame.findPiece(6, 0).getName().equals("King"));
	}
}