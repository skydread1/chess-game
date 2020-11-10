package model;
/**
 * @author lucas.loic
 *
 */
public class Pawn
extends AbstractPiece
implements Pawns {

	/**
	 * constructor
	 * <p>
	 * @param couleur_de_piece
	 * @param coord
	 */
	public Pawn(Color couleur_de_piece,Coord coord){
		super(couleur_de_piece,coord);
		this.name="Pawn";	
	}

	public boolean isMoveOk(int xFinal,int yFinal){
		boolean ret=false;
		if(isMoveOnChest(xFinal,yFinal)){
			if(getCouleur()==Color.WHITE){
				if(xFinal==getX() && yFinal==getY()-1){
					ret= true;
				}
				if(getY()==6 && yFinal==4 && xFinal==getX()){
					ret= true;
				}
			}

			if(getCouleur()==Color.BLACK)
			{
				if(xFinal==getX() && yFinal==getY()+1){
					ret= true;
				}
				if(getY()==1 && yFinal==3 && xFinal==getX()){
					ret= true;
				}

			}
		}
		return ret;
	}

	public boolean isMoveDiagOk(int xFinal,int yFinal){
		boolean ret=false;
		if(getCouleur()==Color.WHITE){
			if(isMoveOnChest(xFinal,yFinal)){
				if(Math.abs(xFinal-getX())==1 && yFinal==getY()-1){
					ret= true;
				}
			}
		}
		if(getCouleur()==Color.BLACK){
			if(isMoveOnChest(xFinal,yFinal)){
				if(Math.abs(xFinal-getX())==1 && yFinal==getY()+1){
					ret= true;
				}
			}
		}
		return ret;
	}


}






