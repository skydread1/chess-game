package tools;

import model.Coord;
import model.Couleur;

/**
 * @author francoise.perrin
 *
 */
public enum ChessPiecePos {

	@SuppressWarnings("javadoc")
	TOURBLANC("Tour", Couleur.BLANC, new Coord[] {new Coord(0,7), new Coord(7,7)}),
	@SuppressWarnings("javadoc")
	CAVALIERBLANC("Cavalier", Couleur.BLANC, new Coord[] {new Coord(1,7), new Coord(6,7)}), 
	@SuppressWarnings("javadoc")
	FOUBLANC("Fou", Couleur.BLANC, new Coord[] {new Coord(2,7), new Coord(5,7)}), 
	@SuppressWarnings("javadoc")
	REINEBLANC("Reine", Couleur.BLANC, new Coord[] {new Coord(3,7)}), 
	@SuppressWarnings("javadoc")
	ROIBLANC("Roi", Couleur.BLANC, new Coord[] {new Coord(4,7)}),
	@SuppressWarnings("javadoc")
	PIONBLANC("Pion", Couleur.BLANC, new Coord[] {new Coord(0,6), new Coord(1,6), new Coord(2,6), new Coord(3,6),
			new Coord(4,6), new Coord(5,6), new Coord(6,6), new Coord(7,6)}),

	@SuppressWarnings("javadoc")
	TOURNOIR("Tour", Couleur.NOIR, new Coord[] {new Coord(0,0), new Coord(7,0)}),
	@SuppressWarnings("javadoc")
	CAVALIERNOIR("Cavalier", Couleur.NOIR, new Coord[] {new Coord(1,0), new Coord(6,0)}), 
	@SuppressWarnings("javadoc")
	FOUNOIR("Fou", Couleur.NOIR, new Coord[] {new Coord(2,0), new Coord(5,0)}), 
	@SuppressWarnings("javadoc")
	REINENOIR("Reine", Couleur.NOIR, new Coord[] {new Coord(3,0)}), 
	@SuppressWarnings("javadoc")
	ROINOIR("Roi", Couleur.NOIR, new Coord[] {new Coord(4,0)}),
	@SuppressWarnings("javadoc")
	PIONNOIR("Pion", Couleur.NOIR, new Coord[] {new Coord(0,1), new Coord(1,1), new Coord(2,1), new Coord(3,1),
			new Coord(4,1), new Coord(5,1), new Coord(6,1), new Coord(7,1)})   
	; 
	/**
	 * name
	 */
	public String nom;
	/**
	 * color
	 */
	public Couleur couleur;
	/**
	 * coordinates
	 */
	public  Coord[] coords = new Coord[8] ;   

	ChessPiecePos( String nom, Couleur couleur, Coord[] coords) { 
		this.nom = nom;this.couleur = couleur;
		this.coords = coords;
	} 

}

