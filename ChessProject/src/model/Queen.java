package model;
/**
 * @author lucas/loïc
 * pièce Queen
 *
 */
public class Queen extends AbstractPiece {
	/**
	 * @param couleur_de_piece
	 * @param coord
	 */
	public Queen(Color couleur_de_piece,Coord coord){
		super(couleur_de_piece,coord);
		this.name="Queen";

	}

	public boolean isMoveOk(int xFinal,int yFinal){
		boolean ret=false;
		if(isMoveOnChest(xFinal,yFinal)){
			int x=xFinal-getX();
			int y=yFinal-getY();
			if( (xFinal==getX() || yFinal==getY()) || (Math.abs(y)==Math.abs(x))){
				ret= true;
			}
		}
		return ret;
	}

}
