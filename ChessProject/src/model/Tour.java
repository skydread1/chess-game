package model;
/**
 * @author lucas/loïc
 * pièce Tour
 *
 */
public class Tour
extends AbstractPiece {
	/**
	 * @param couleur_de_piece
	 * @param coord
	 * 
	 */
	public Tour(Couleur couleur_de_piece,Coord coord){
		super(couleur_de_piece,coord);
		this.name="Tour";

	}


	public boolean isMoveOk(int xFinal,int yFinal){
		boolean ret=false;
		if(isMoveOnChest(xFinal,yFinal)){
			if((xFinal==getX() || yFinal==getY())){
				ret= true;
			}
		}
		return ret;
	}

}