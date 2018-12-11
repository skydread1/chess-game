package model;

/**
 * @author lucas/loïc
 *
 */
public class Cavalier
extends AbstractPiece {



	/**
	 * @param couleur_de_piece
	 * @param coord
	 * piece cavalier
	 */
	public Cavalier(Couleur couleur_de_piece,Coord coord){
		super(couleur_de_piece,coord);
		this.name="Cavalier";
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