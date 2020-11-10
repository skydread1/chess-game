package model;

import java.util.LinkedList;
import java.util.List;

/**
 * @author francoise.perrin
 * Classe qui permet de rerockner des informations sur les pièces
 * en vue d'une utilisation par une IHM
 * 
 */
public  class PieceIHM {

	String type;
	Color couleur;
	List<Coord> list;

	PieceIHM(String type, Color couleur) {
		this.type = type;
		this.couleur = couleur;
		list = new LinkedList<Coord>();
	}

	/**
	 * @param coord
	 */
	public void add(Coord coord){
		list.add(coord);
	}

	/**
	 * @return the type
	 */
	public String getTypePiece() {
		return type;
	}

	/**
	 * @return the couleur
	 */
	public Color getCouleur() {
		return couleur;
	}

	/**
	 * @return the list
	 */
	public List<Coord> getList() {
		return list;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PieceIHM [type=" + type + ", couleur=" + couleur + ", list=" + list + "]";
	}
}