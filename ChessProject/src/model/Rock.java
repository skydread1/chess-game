package model;
/**
 * @author lucas/loïc
 * pièce Rock
 *
 */
public class Rock
extends AbstractPiece {
	/**
	 * @param couleur_de_piece
	 * @param coord
	 * 
	 */
	public Rock(Color couleur_de_piece,Coord coord){
		super(couleur_de_piece,coord);
		this.name="Rock";

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