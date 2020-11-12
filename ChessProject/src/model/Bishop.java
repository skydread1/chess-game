package model;
/**
 * @author Loic and Lucas
 *
 */
public class Bishop
extends AbstractPiece {

	/**
	 * @param color
	 * @param coord
	 */
	public Bishop(Color color,Coord coord){
		super(color,coord);
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

