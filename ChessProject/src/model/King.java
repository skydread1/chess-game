package model;
/**
 * @author lucas/loïc
 * pièce King
 *
 */
public class King extends AbstractPiece {
	/**
	 * @param color
	 * @param coord
	 * 
	 */
	public King(Color color,Coord coord){
		super(color,coord);
		this.name="King";

	}

	public boolean isMoveOk(int xFinal,int yFinal){
		boolean ret=false;
		if(isMoveOnChest(xFinal,yFinal)){
			if((xFinal==getX()+1 || xFinal==getX()-1 || xFinal==getX()) && ( yFinal==getY() || yFinal==getY()+1 || yFinal==getY()-1) ){
				ret= true;
			}
		}
		return ret;
	}

}
