package model;
/**
 * @author lucas/loïc
 *
 */
public class Bishop
extends AbstractPiece {

	/**
	 * @param couleur_de_piece
	 * @param coord
	 */
	public Bishop(Color couleur_de_piece,Coord coord){
		super(couleur_de_piece,coord);
		this.name="Bishop";

	}

	public boolean isMoveOk(int xFinal,int yFinal){
		boolean ret_isMovOK = false;

		if(isMoveOnChest(xFinal,yFinal))
		{
			int x=xFinal-getX();
			int y=yFinal-getY();
			if(Math.abs(y)==Math.abs(x))
			{
				ret_isMovOK = true;
			}
		}
		return ret_isMovOK;
	}

}

