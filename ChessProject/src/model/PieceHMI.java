package model;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Loic and Lucas
 * <p>
 * Pieces information on the View that are meant to be use by HMI 
 */
public class PieceHMI {

	String type;
	Color color;
	List<Coord> list;

	PieceHMI(String type, Color color) {
		this.type = type;
		this.color = color;
		list = new LinkedList<Coord>();
	}

	/**
	 * @param coord
	 */
	public void add(Coord coord) {
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

	@Override
	public String toString() {
		return "PieceIHM [type=" + type + ", color=" + color + ", list=" + list + "]";
	}
}