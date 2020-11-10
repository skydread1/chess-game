package model;

/**
 * @author Loic and Lucas
 *
 */
public class Knight
extends AbstractPiece {



	/**
	 * @param color
	 * @param coord
	 * piece knight
	 */
	public Knight(Color color,Coord coord){
		super(color,coord);
		this.name="Knight";
	}

	public boolean isMoveOk(int xFinal,int yFinal){
		boolean ret=false;
		if(isMoveOnChest(xFinal,yFinal)){
			if((xFinal==getX()+2 && yFinal==getY()+1) || (xFinal==getX()+2 && yFinal==getY()-1) || (xFinal==getX()-2 && yFinal==getY()+1) || (xFinal==getX()-2 && yFinal==getY()-1) || 
					(xFinal==getX()+1 && yFinal==getY()+2) || (xFinal==getX()+1 && yFinal==getY()-2) || (xFinal==getX()-1 && yFinal==getY()+2) || (xFinal==getX()-1 && yFinal==getY()-2)){
				ret= true;
			}
		}
		return ret;
	}

}