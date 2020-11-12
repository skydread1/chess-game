package model;

import java.util.List;
/**
 * @author loic and lucas
 * Chess board
 */
public class ChessBoard extends java.lang.Object
implements BoardGames{

	private Game jeu_WHITE;
	private Game  jeu_BLACK;
	private Game  jeu_courant;
	private Game jeu_non_courant;
	private String message="erreur";

	/**
	 * 
	 */
	public ChessBoard(){
		this.jeu_WHITE=new Game(Color.WHITE);
		this.jeu_BLACK=new Game(Color.BLACK);
		this.jeu_courant=this.jeu_WHITE;
		this.jeu_non_courant=this.jeu_BLACK;
	}

	/**
	 * @return liste de pièces IHM contenant toutes les pieces de l'echiquier (courantes et non courantes)
	 */
	public java.util.List<PieceIHM> getPiecesIHM(){
		List<PieceIHM> ret=null;
		List<PieceIHM> listounette=this.jeu_courant.getPiecesIHM();
		if(listounette.addAll(this.jeu_non_courant.getPiecesIHM())){
			ret= listounette;
		}
		else{
			setMessage("KO: pas de liste de piﾃｨces non courantes (c'est vraiment pas normal)");
		}
		return ret;
	}

	/**
	 * Change le joueur courant lorsqu'un joueur termine son rock
	 */
	public void switchJoueur(){
		Game temp;
		temp=this.jeu_courant;
		this.jeu_courant=this.jeu_non_courant;
		this.jeu_non_courant=temp;

	}

	/**
	 * @param xInit
	 * @param yInit
	 * @param xFinal
	 * @param yFinal
	 * @return un boolén 
	 */
	public boolean isPieceInBetween(int xInit,int yInit,int xFinal,int yFinal){
		boolean ret=false;
		boolean reste=true;
		//si la pièce qui va se dépacer est un bishop ou une queen(déplacement diagonal), on regarde si elle va ckingser une autre pièce lors de son déplacement
		if(this.jeu_courant.getPieceType(xInit, yInit).equals("Bishop") || this.jeu_courant.getPieceType(xInit, yInit).equals("Queen")){
			if(xInit!=xFinal && yInit!=yFinal){//on verifie que le déplacement est bien celui d'un bishop (pour la queen)
				//on va regarder s'il y a une pièce sur chaque case qui sépare le point de départ et le point d'arrivée
				for(int i=1; i<(Math.abs(xFinal-xInit)) && reste ;i++){ //si le bishop va de 1,3 a 3,5 on aura i<2+1 avec i=1 au début: le bishop se déplacant bien de 2 cases on entre 2 fois dans la boucle
					if(xFinal-xInit>0){//si le déplacement est positif selon les x
						if(yFinal-yInit>0){//si le déplacement est positif selon les y
							if(this.jeu_WHITE.isPieceHere(xInit+i, yInit+i) || this.jeu_BLACK.isPieceHere(xInit+i, yInit+i)){
								ret=true;
								reste=false;
							}
						}
						else{//si le déplacement est negatif selon les y
							if(this.jeu_WHITE.isPieceHere(xInit+i, yInit-i) || this.jeu_BLACK.isPieceHere(xInit+i, yInit-i)){
								ret=true;
								reste=false;
							}
						}
					}

					else{ //si le déplacement est negatif selon les x
						if(yFinal-yInit>0){//si le déplacement est positif selon les y
							if(this.jeu_WHITE.isPieceHere(xInit-i, yInit+i) || this.jeu_BLACK.isPieceHere(xInit-i, yInit+i)){
								ret=true;
								reste=false;
							}
						}
						else{//si le déplacement est negatif selon les y
							if(this.jeu_WHITE.isPieceHere(xInit-i, yInit-i) || this.jeu_BLACK.isPieceHere(xInit-i, yInit-i)){
								ret=true;
								reste=false;
							}
						}

					}
				}
			}
		}
		//si la pièce qui va se dépacer est une rock ou une queen(déplacement en ligne dkingte), on regarde si elle va ckingser une autre pièce lors de son déplacement
		if(this.jeu_courant.getPieceType(xInit, yInit).equals("Rock") || this.jeu_courant.getPieceType(xInit, yInit).equals("Queen")){
			if((xFinal==xInit || yFinal==yInit)){//on verifie que le déplacement est bien celui d'une rock (pour la queen)
				if(yFinal==yInit){  //si le déplacement est horizontal
					//on va regarder s'il y a une pièce sur chaque case qui sépare le point de départ et le point d'arrivée
					for(int i=1; i<(Math.abs((xFinal-xInit))) && reste ;i++ ){ //si la rock va de 1,3 a 3,3 on aura i<2+1 avec i=1 au début: la rock se déplacant bien de 2 cases on entre 2 fois dans la boucle
						if((xFinal-xInit)>0){//si le déplacement est positif
							if(this.jeu_WHITE.isPieceHere(xInit+i, yInit) || this.jeu_BLACK.isPieceHere(xInit+i, yInit)){
								ret=true;
								reste=false;
							}
						}
						else{//si le déplacement est négatif
							if(this.jeu_WHITE.isPieceHere(xInit-i, yInit) || this.jeu_BLACK.isPieceHere(xInit-i, yInit)){
								ret=true;
								reste=false;
							}
						}
					}
				}

				else{//si le déplacement est vertical
					//on va regarder s'il y a une pièce sur chaque case qui sépare le point de départ et le point d'arrivée
					for(int i=1; i<(Math.abs((yFinal-yInit))) && reste ;i++){ //si la rock va de 1,3 a 1,5 on aura i<2+1 avec i=1 au début: la rock se déplacant bien de 2 cases on entre 2 fois dans la boucle
						if((yFinal-yInit)>0){//si le déplacement est positif
							if(this.jeu_WHITE.isPieceHere(xInit, yInit+i) || this.jeu_BLACK.isPieceHere(xInit, yInit+i)){
								ret=true;
								reste=false;
							}
						}
						else{//si le déplacement est négatif
							if(this.jeu_WHITE.isPieceHere(xInit, yInit-i) || this.jeu_BLACK.isPieceHere(xInit, yInit-i)){
								ret=true;
								reste=false;
							}
						}
					}
				}
			}

		}

		return ret;
	}



	/**
	 * @param xInit
	 * @param yInit
	 * @param xFinal
	 * @param yFinal
	 * @return un booléen indiquant si le mouvement est possible
	 */
	public boolean isMoveOk(int xInit,int yInit,int xFinal,int yFinal){
		boolean ret=false;

		//piece appartient au joueur
		if(this.getColorCurrentPlayer().equals(this.getPieceColor(xInit,yInit))) {	
			//verif si il y a bien deplacement
			if(!(xInit==xFinal && yInit==yFinal)){ 
				//il y a bien deplacement
				//cas de la capture
				if(this.jeu_non_courant.isPieceHere(xFinal,yFinal)){
					ret= jeu_non_courant.isCapturePossible(xFinal, yFinal) && jeu_courant.isMoveOk(xInit, yInit, xFinal, yFinal) ;
					//si la pièce est un pawn on vérifie la prise en diagonale
					if(this.jeu_courant.getPieceType(xInit, yInit).equals("Pawn")) 
					{
						if(this.jeu_non_courant.isCapturePossible(xFinal, yFinal)){
							ret=((Pawn) this.jeu_courant.findPiece(xInit,yInit)).isMoveDiagOk(xFinal,yFinal);
						}
					}
				}
				else{ 
					//cas ou piece arrivee est mm color que piece joueur courant
					if(this.jeu_courant.isPieceHere(xFinal,yFinal)){
						ret=false;
					}
					else{//cas deplacement simple
						ret= jeu_courant.isMoveOk(xInit, yInit, xFinal, yFinal);	
					}
				}
				//la fonction rerockne true si il y a une piece qui gene le déplacement 
				if(isPieceInBetween(xInit,yInit,xFinal,yFinal)){
					ret=false;
					setMessage("KO: il y a une pièce qui gène le déplacement");
				}
			}
			else{
				setMessage("KO: vous n'avez pas bougé");
				ret=false;
			}
		}
		else{
			setMessage("KO: vous ne pouvez deplacer que des pieces de votre color");
		}
		return ret;		
	}


	public boolean move(int xInit,int yInit,int xFinal,int yFinal){
		boolean ret=false;

		if(this.isMoveOk(xInit, yInit, xFinal, yFinal))
		{
			//gestion capture
			this.jeu_non_courant.isCapture(xFinal,yFinal);
			ret= (this.jeu_courant.move(xInit, yInit, xFinal, yFinal));
		}	
		else{
			setMessage("KO: Problème déplacement impossible");
		}		
		return ret;
	}

	public  String toString(){
		return "Jeu White: \r" + this.jeu_WHITE.toString() + " \r Jeu Black: \r" + this.jeu_BLACK.toString()+ "\r";
	}

	public Color getColorCurrentPlayer(){
		return this.jeu_courant.getColor();
	}

	public Color getPieceColor(int x,int y){
		return this.jeu_courant.getPieceColor(x,y);
	}

	public java.lang.String getMessage(){
		return this.message;		

	}

	private  void setMessage(String message){
		this.message=message;
	}

	public boolean isEnd(){
		return false;
		/*
		 * TODO
		 */
	}








}
