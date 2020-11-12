package model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tools.ChessPiecesFactory;
/**
 * @author Loic and Lucas
 */
public class Game extends java.lang.Object{
	private List<Pieces> pieces=null;
	private Color color;
	/**
	 * @param color
	 */
	public Game(Color color){
		pieces=ChessPiecesFactory.newPieces(color);
		this.color=color;
	}

	/**
	 * @param x
	 * @param y
	 * @return true if there is a piece in the coordinates in parameters of the method
	 */
	public boolean isPieceHere(int x,int y){
		boolean ret=false;
		if(findPiece(x,y)!=null){
			ret=true;
		}
		return ret;
	}

	/**
	 * @param xInit
	 * @param yInit
	 * @param xFinal
	 * @param yFinal
	 * @return true if the move is possible
	 */
	public boolean isMoveOk(int xInit,int yInit,int xFinal,int yFinal){
		boolean ret=false;
		
		if(isPieceHere(xInit,yInit))
		{
			Pieces pieces=findPiece(xInit,yInit);
			ret=pieces.isMoveOk(xFinal, yFinal);
		}

		return ret;

	}

	/**
	 * move a piece on the chest
	 * <p>
	 * @param xInit
	 * @param yInit
	 * @param xFinal
	 * @param yFinal
	 * <p>
	 * @return true if the move is done
	 */
	public boolean move(int xInit,int yInit,int xFinal,int yFinal){
		boolean ret=false;
		Pieces pieces=findPiece(xInit,yInit);
		ret= pieces.move(xFinal, yFinal);

		return ret;
	}

	/**
	 * verify if the capture is possible
	 * <p>
	 * @param xCapture
	 * @param yCapture
	 * <p>
	 * @return true if the capture is possible
	 */
	public boolean isCapturePossible(int xCapture, int yCapture){
		boolean ret=false;
		
		if(isPieceHere(xCapture, yCapture)){
			ret=true;
		}
		return ret;
	}

	/**
	 * do the capture
	 * <p>
	 * @param xCapture
	 * @param yCapture
	 */
	public void isCapture(int xCapture, int yCapture) {
		if(isCapturePossible(xCapture, yCapture)){
			Pieces p=findPiece(xCapture,yCapture);			 
			//p.capture(); //on met à (-1,-1) la piece qui est capturée
			p.capture();
			System.out.println("CAPTURE");
		}	 

	}

	public java.lang.String toString(){
		return this.pieces.toString();

	}

	/**
	 * @param x
	 * @param y
	 * <p>
	 * @return the piece color 
	 */
	public Color getPieceColor(int x,int y){
		Color ret=Color.BLACKWHITE;
		if(isPieceHere(x,y)){
			Pieces pieces=findPiece(x,y);
			ret= pieces.getColor();		
		}
		return ret;
	}

	/**
	 * @param x
	 * @param y
	 * @return the name of the piece at the given coordinates
	 */
	public java.lang.String getPieceType(int x,int y){
		java.lang.String ret=null;
		Pieces pieces=findPiece(x,y);
		if(pieces!=null){
			ret= pieces.getName();
		}
		return ret;
	}

	/**
	 * @return the color of the game
	 */
	public Color getColor(){
		return this.color;	
	}

	/**
	 * @return une vue de la liste des piﾃｨces en cours
	 * ne donnant que des accﾃｨs en lecture sur des PieceIHM
	 * (type piece + color + liste de coordonnﾃｩes)
	 */
	public List<PieceIHM> getPiecesIHM(){
		PieceIHM newPieceIHM = null;
		List<PieceIHM> list = new LinkedList<PieceIHM>();
		for (Pieces piece : pieces)
		{
			boolean existe = false;

			// si le type de piece existe dﾃｩjﾃ� dans la liste de PieceIHM
			// ajout des coordonnﾃｩes de la piﾃｨce dans la liste de Coord de ce type
			// si elle est toujours en jeu (x et y != -1)
			for ( PieceIHM pieceIHM : list){
				if ((pieceIHM.getTypePiece()).equals(piece.getClass().getSimpleName())){
					existe = true;
					if (piece.getX() != -1){
						pieceIHM.add(new Coord(piece.getX(), piece.getY()));
					}
				}
			}
			// sinon, crﾃｩation d'une nouvelle PieceIHM si la piﾃｨce est toujours en jeu
			if (! existe) {
				if (piece.getX() != -1){
					newPieceIHM = new PieceIHM(piece.getClass().getSimpleName(),
							piece.getColor());
					newPieceIHM.add(new Coord(piece.getX(), piece.getY()));
					list.add(newPieceIHM);
				}
			}
		}
		return list;
	}

	/**
	 * Not sure yet...
	 */
	public void setCastling(){

	}

	/**
	 * undo previous move
	 */
	public void undoMove(){

	}

	/**
	 * undo previous capture
	 */
	public void undoCapture(){

	}

	/**
	 * @param xFinal
	 * @param yFinal
	 * @return true if the pawn promotion is possible
	 */
	public boolean isPawnPromotion(int xFinal,int yFinal){
		boolean ret=false;
		if(getColor()==Color.WHITE){
			if(yFinal==7){
				ret= true;
			}	
		}

		if(getColor()==Color.BLACK){
			if(yFinal==0){
				ret= true;
			}
		}
		return ret;
	}

	/**
	 * do the promotion
	 * @param xFinal
	 * @param yFinal
	 * @param type
	 * @return true if the promotion was correctly done
	 */
	public boolean pawnPromotion(int xFinal,int yFinal,java.lang.String type){
		boolean ret=false;
		//Pieces piece=findPiece(xFinal,yFinal);
		if (this.getPieceType(xFinal,yFinal)=="Pawn" && type!="Pawn" && type!="King"){
			Pieces piece=findPiece(xFinal,yFinal);
			piece.move(-1, -1);
			switch(type){
			case "Queen":
				pieces.add(new Queen(piece.getColor(),new Coord(xFinal,yFinal)));
				ret=true;
				break;
			case "Rock":
				pieces.add(new Rock(piece.getColor(),new Coord(xFinal,yFinal)));
				ret=true;
				break;
			case "Bishop":
				pieces.add(new Bishop(piece.getColor(),new Coord(xFinal,yFinal)));
				ret=true;
				break;
			case "Knight":
				pieces.add(new Knight(piece.getColor(),new Coord(xFinal,yFinal)));
				ret=true;
				break;	
			default:
				ret=false;
			}
		}
		return ret;
	}


	/**
	 * @return the King coordinates
	 */
	public Coord getKingCoord(){
		Coord ret=null;	
		Coord coord = new Coord(0,0);
		Iterator<Pieces> li = pieces.listIterator();

		while(li.hasNext()){
			Pieces p_tampon = li.next();
			if (p_tampon.getClass().getSimpleName().contains("King")){
				coord.x=p_tampon.getX();
				coord.y=p_tampon.getY();
				ret= coord;
			}
		}
		return ret;
	}

	/**
	 * @param x
	 * @param y
	 * @return the piece at the given coordinates
	 */
	Pieces findPiece(int x, int y)
	{
		Pieces ret=null;
		Iterator<Pieces> i = pieces.iterator();
		Pieces piece;
		while(i.hasNext()){
			piece= (Pieces)i.next();
			if (piece.getX()==x && piece.getY()==y)
				ret= piece;
		}
		return ret;	
	}

}
