package model;
/**
 * @author lucas/loïc
 *
 */
public class Fou
extends AbstractPiece {

	/**
	 * @param couleur_de_piece
	 * @param coord
	 */
	public Fou(Couleur couleur_de_piece,Coord coord){
		super(couleur_de_piece,coord);
		this.name="Fou";

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

