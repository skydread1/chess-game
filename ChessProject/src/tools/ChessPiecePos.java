package tools;

import model.Coord;
import model.Color;

/**
 * @author francoise.perrin
 *
 */
public enum ChessPiecePos {

	@SuppressWarnings("javadoc")
	TOURWHITE("Rock", Color.WHITE, new Coord[] {new Coord(0,7), new Coord(7,7)}),
	@SuppressWarnings("javadoc")
	CAVALIERWHITE("Knight", Color.WHITE, new Coord[] {new Coord(1,7), new Coord(6,7)}), 
	@SuppressWarnings("javadoc")
	FOUWHITE("Bishop", Color.WHITE, new Coord[] {new Coord(2,7), new Coord(5,7)}), 
	@SuppressWarnings("javadoc")
	REINEWHITE("Queen", Color.WHITE, new Coord[] {new Coord(3,7)}), 
	@SuppressWarnings("javadoc")
	ROIWHITE("King", Color.WHITE, new Coord[] {new Coord(4,7)}),
	@SuppressWarnings("javadoc")
	PIONWHITE("Pawn", Color.WHITE, new Coord[] {new Coord(0,6), new Coord(1,6), new Coord(2,6), new Coord(3,6),
			new Coord(4,6), new Coord(5,6), new Coord(6,6), new Coord(7,6)}),

	@SuppressWarnings("javadoc")
	TOURBLACK("Rock", Color.BLACK, new Coord[] {new Coord(0,0), new Coord(7,0)}),
	@SuppressWarnings("javadoc")
	CAVALIERBLACK("Knight", Color.BLACK, new Coord[] {new Coord(1,0), new Coord(6,0)}), 
	@SuppressWarnings("javadoc")
	FOUBLACK("Bishop", Color.BLACK, new Coord[] {new Coord(2,0), new Coord(5,0)}), 
	@SuppressWarnings("javadoc")
	REINEBLACK("Queen", Color.BLACK, new Coord[] {new Coord(3,0)}), 
	@SuppressWarnings("javadoc")
	ROIBLACK("King", Color.BLACK, new Coord[] {new Coord(4,0)}),
	@SuppressWarnings("javadoc")
	PIONBLACK("Pawn", Color.BLACK, new Coord[] {new Coord(0,1), new Coord(1,1), new Coord(2,1), new Coord(3,1),
			new Coord(4,1), new Coord(5,1), new Coord(6,1), new Coord(7,1)})   
	; 
	/**
	 * name
	 */
	public String nom;
	/**
	 * color
	 */
	public Color couleur;
	/**
	 * coordinates
	 */
	public  Coord[] coords = new Coord[8] ;   

	ChessPiecePos( String nom, Color couleur, Coord[] coords) { 
		this.nom = nom;this.couleur = couleur;
		this.coords = coords;
	} 

}

