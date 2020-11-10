package model;

/**
 * @author Loic and Lucas
 * abstract class containing the common methods for all pieces in the chest game
 */
public abstract class AbstractPiece
extends java.lang.Object
implements Pieces{

	protected  String name;
	private Color couleur;
	private Coord coord; 

	/**
	 * @param couleur
	 * @param coord
	 */
	public AbstractPiece(Color couleur, Coord coord){
		this.coord=coord;
		this.couleur=couleur;
	}

	public String getName() {
		return this.getClass().getSimpleName();
	}

	public int getX(){
		return this.coord.x;	
	}

	public int getY(){
		return this.coord.y;
	}

	public Color getCouleur(){
		return this.couleur;	
	}

	/**
	 * move the piece
	 * <p>
	 * @param x
	 * @pram y
	 * <p>
	 * @return true if the move is done
	 */
	public boolean move(int x,int y){
		this.coord.x=x;
		this.coord.y=y;
		return true;
	}

	/**
	 * capture the piece
	 * <p>
	 * @return true if the capture is done
	 */
	public boolean capture(){
		this.coord.x=-1;
		this.coord.y=-1;
		return true;
	}

	/**
	 * @return piece and its coordinates
	 */
	public java.lang.String toString(){
		return "La piece est "+this.name+" et ses coordonnees sont ("+String.valueOf(getX())+","+String.valueOf(getY())+") \r";	
	}


	/**
	 * abstract method to verify if the move is ok
	 * <p>
	 * @param xFinal
	 * @param yFinal
	 */
	public abstract boolean isMoveOk(int xFinal,int yFinal);

	/**
	 * verify if the move is on the chest, the coordinates are between 0 to 7
	 * <p>
	 * @param xFinal
	 * @param yFinal
	 * 
	 * @return true if the move is on the chest
	 */
	public boolean isMoveOnChest(int xFinal,int yFinal){
		boolean ret=false;
		if(!(xFinal==getX() && yFinal==getY())){
			if((xFinal>=0 && xFinal <=7 && xFinal>=0 && xFinal <=7 ) || (xFinal==-1 && yFinal==-1)){
				ret= true;
			}
		}
		return ret;
	}

}





