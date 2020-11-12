package model;

import java.util.LinkedList;
import java.util.List;

/**
 * @author francoise.perrin
 * Classe qui permet de retourner des informations sur les pièces
 * en vue d'une utilisation par une IHM
 * 
 */
public class PieceIHM {

	String type;
	Color color;
	List<Coord> list;

	PieceIHM(String type, Color color) {
		this.type = type;
		this.color = color;
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
	 * @return the color
	 */
	public Color getColor() {
		return color;
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
		return "PieceIHM [type=" + type + ", color=" + color + ", list=" + list + "]";
	}
}